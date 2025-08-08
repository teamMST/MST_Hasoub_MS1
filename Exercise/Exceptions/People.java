public class People {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Alice", 25); // Valid
            System.out.println(p1.getName() + " is " + p1.getAge() + " years old.");

            Person p2 = new Person("Bob", 150); // Invalid
            System.out.println(p2.getName() + " is " + p2.getAge() + " years old.");
        } catch (WrongAgeValueException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Person p3 = new Person("Charlie", -5); // Invalid
            System.out.println(p3.getName() + " is " + p3.getAge() + " years old.");
        } catch (WrongAgeValueException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
