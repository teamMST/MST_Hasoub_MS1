package com.mst.threads;

class SharedResource {
    private boolean flag = false;

    synchronized void produce(int i) {
    	System.out.println("Produce::" + i);
        if (flag) {
            try {
            	System.out.println("Waiting for Consumer!");
                wait(); // Wait for the consumer to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producing...");
        flag = true;
        notify(); // Notify the consumer that the product is ready
    }

    synchronized void consume(int i) {
    	System.out.println("Consume::" + i);
        if (!flag) {
            try {
            	System.out.println("Waiting for Producer!");
                wait(); // Wait for the producer to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consuming...");
        flag = false;
        notify(); // Notify the producer that the consumption is done
    }
}

public class ProducerConsumerExample {
    public static void main(String args[]) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.produce(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.consume(i);
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
