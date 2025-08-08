public class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws WrongAgeValueException {
        this.name = name;
        setAge(age); // This will validate and throw if needed
    }

    public void setAge(int age) throws WrongAgeValueException {
        if (age < 0 || age > 120) {
            throw new WrongAgeValueException(age);
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
