public class WrongAgeValueException extends Exception {
    private int invalidAge;

    public WrongAgeValueException(int invalidAge) {
        super("Invalid age value: " + invalidAge + ". Age must be between 0 and 120.");
        this.invalidAge = invalidAge;
    }

    public int getInvalidAge() {
        return invalidAge;
    }
}
