#!/bin/bash
echo "Starting a background process..."
sleep 100 &

echo "Listing jobs:"
jobs

PID=$!
echo "The process ID is $PID"

echo "Listing the process with ps:"
ps -p $PID

echo "Killing the process..."
kill -9 $PID

echo "Checking if process is still running..."
ps -p $PID || echo "Process terminated!"
