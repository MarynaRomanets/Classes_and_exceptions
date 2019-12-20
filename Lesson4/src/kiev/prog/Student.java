package kiev.prog;

import java.util.Comparator;
import java.util.Scanner;

public class Student extends Human implements Voenkom, InteractiveInputStudent {
    private int department;
    private int groupNumber;
    private int recordBook;
    private double studyResult;

    public Student() {
    }

    public Student(String lastName, String firstName, boolean sex, int age, int department, int groupNumber, int recordBook, double studyResult) {
        super(lastName, firstName, sex, age);
        this.department = department;
        this.groupNumber = groupNumber;
        this.recordBook = recordBook;
        this.studyResult = studyResult;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getRecordBook() {
        return recordBook;
    }

    public void setRecordBook(int recordBook) {
        this.recordBook = recordBook;
    }

    public double getStudyResult() {
        return studyResult;
    }

    public void setStudyResult(double studyResult) {
        this.studyResult = studyResult;
    }

    @Override
    public String toString() {
        return  "Student{" + super.toString() +
                "department=" + department +
                ", group=" + groupNumber +
                ", recordBook=" + recordBook +
                ", studyResult = " + studyResult +
                '}';
    }

    @Override
    public boolean askIfMan() {
        return super.isSex();
    }

    @Override
    public boolean askIfAge() {
        if (super.getAge() >= 18) {
            return true;
        }
        return false;
    }

    public static Comparator<Student> LN_Comparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return (student1.getLastName().compareTo(student2.getLastName()));
        }
    };

   public static Comparator<Student> Study_Comparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            if ((student1.getStudyResult() - student2.getStudyResult()) > 0) {
                return -1;
            } else if ((student1.getStudyResult() - student2.getStudyResult()) < 0) {
                return 1;
            }
            return 0;
        }
    };

    public static Comparator<Student> RecordBook_Comparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return (student1.getRecordBook() - student2.getRecordBook());
        }
    };

    @Override
    public String inputLastName() throws InteractiveInputException {
        System.out.println("Input Last Name of student (format String): ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            throw new InteractiveInputException("Mistake! Number is not Last Name", null);
        }
        String lastNameInput = sc.nextLine();
        if (lastNameInput.isEmpty()) {
            throw new InteractiveInputException("Mistake! Empty string for Last Name", lastNameInput);
        }
        return lastNameInput;
    }

    @Override
    public String inputFirstName() throws InteractiveInputException {
        System.out.println("Input First Name of student (format String): ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            throw new InteractiveInputException("Mistake! Number is not First Name", null);
        }
        String firstNameInput = sc.nextLine();
        if (firstNameInput.isEmpty()) {
            throw new InteractiveInputException("Mistake! Empty string for First Name", firstNameInput);
        }
        return firstNameInput;
    }

    @Override
    public boolean inputSex() throws InteractiveInputException {
        System.out.println("Input Sex of student (input 'm' or 'f'): ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            throw new InteractiveInputException("Mistake! Number is not Sex", null);
        }
        String sex = sc.nextLine();
        if (sex.isEmpty()) {
            throw new InteractiveInputException("Mistake! Empty string for Sex", sex);
        } else if (sex.length() > 1) {
            throw new InteractiveInputException("Mistake! It's possible to input only 'm' or 'f': ", sex);
        } else if (sex.equalsIgnoreCase("m")) {
            return true;
        } else if (sex.equalsIgnoreCase("f")) {
            return false;
        } else {
            throw new InteractiveInputException("Mistake! ", sex);
        }
    }

    @Override
    public int inputAge() throws InteractiveInputException {
        System.out.println("Input Age of student (format number from 16 to 90): ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
           int ageInput = sc.nextInt();
           if (ageInput >= 16 && ageInput <=90) {
               return ageInput;
           } else {
               throw new InteractiveInputException("Student age must be from 16 to 90: ", null);
           }
        } else {
            throw new InteractiveInputException("Mistake! It's possible to input only number", null);
        }
    }

    @Override
    public int inputDepartment() {
        return 25;
    }

    @Override
    public int inputGgroupNumber() {
        return 1;
    }

    @Override
    public int inputRecordBook() throws InteractiveInputException {
        System.out.println("Input RecordBook of student (format number from 1000 to 2000): ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int recBook = sc.nextInt();
            if (recBook >= 1000 && recBook <=2000) {
                return recBook;
            } else {
                throw new InteractiveInputException("RecordBook number must be from 1000 to 2000: ", null);
            }
        } else {
            throw new InteractiveInputException("Mistake! It's possible to input only number", null);
        }
    }

    @Override
    public double inputStudyResult() throws InteractiveInputException {
        System.out.println("Input StudyResult of student (format number from '0,0' to '12,0'): ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextDouble()) {
            double result = sc.nextDouble();
            if (result <= 0) {
                throw new InteractiveInputException("StudyResult couldn't be 0 or < 0 " , null);
            }
            if (result > 0.0 && result <= 12.0) {
                return result;
            } else {
                throw new InteractiveInputException("StudyResult must be from '0,0' to '12,0': ", null);
            }
        } else {
            throw new InteractiveInputException("Mistake! It's possible to input only number", null);
        }
    }
}
