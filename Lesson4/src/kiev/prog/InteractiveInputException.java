package kiev.prog;

public class InteractiveInputException extends Exception {
    private String lastName;

    public InteractiveInputException(String message, String lastName) {
        super(message);
        this.lastName = lastName;
    }

    public InteractiveInputException() {
    }

    @Override
    public String toString() {
        return "InteractiveInputException{" +
                " lastName='" + lastName + '\'' +
                '}';
    }
}
