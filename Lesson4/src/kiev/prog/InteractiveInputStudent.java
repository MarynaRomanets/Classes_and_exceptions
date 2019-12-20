package kiev.prog;

public interface InteractiveInputStudent {

    public String inputLastName() throws InteractiveInputException;
    public String inputFirstName() throws InteractiveInputException;
    public boolean inputSex() throws InteractiveInputException;
    public int inputAge() throws InteractiveInputException;
    public int inputDepartment();
    public int inputGgroupNumber();
    public int inputRecordBook() throws InteractiveInputException;
    public double inputStudyResult() throws InteractiveInputException;

}
