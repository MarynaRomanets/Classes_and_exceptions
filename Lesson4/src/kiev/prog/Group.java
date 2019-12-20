package kiev.prog;

import java.util.Arrays;

public class Group {
    private final byte SIZE = 10;
    private final byte SIZE_MISTAKE = 1;
    private int index;
    private Student[] group = new Student[SIZE];
    private Student[] mistakeList = new Student[SIZE_MISTAKE];

    public Group() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Student[] getGroup() {
        return group;
    }

    public void setGroup(Student[] group) {
        this.group = group;
    }

    public Student[] getMistakeList() {
        return mistakeList;
    }



    public void setMistakeList(Student[] mistakeList) {
        this.mistakeList = mistakeList;
    }

    @Override
    public String toString() {
        return "Group " + index + "{" +
                Arrays.toString(group)  +
                '}';
    }

    public boolean checkStudent (Student student) throws SizeGroupException, StudentInfoException {
        if (student instanceof Student) {
            if (student.getLastName() == null) {
                throw new StudentInfoException("It's not possible to add Student without LastName: ", student);
            } else if (student.getFirstName() == null) {
                throw new StudentInfoException("It's not possible to add Student without FirstName: ", student);
            } else if (student.getAge() < 16) {
                throw new StudentInfoException("It's not possible to add Student with age < 16: ", student);
            } else if (student.getDepartment() == 0) {
                throw new StudentInfoException("It's not possible to add Student without department number: ", student);
            }
        }
        return true;
    }

    public Student[] addStudent (Student student) throws SizeGroupException, StudentInfoException {
        if (index < SIZE) {
            if (checkStudent(student)) {
                    Student[] temp = new Student[index + 1];
                    for (int i = 0; i < index; i++) {
                        temp[i] = group[i];
                    }
                    temp[index] = student;
                    group = temp;
                    index++;
                    return group;
                }
        } else {
            mistakeList[0] = student;
            throw new SizeGroupException("Size of group must be < 10, size now is: ", index);
        }
        return group;
    }

    public Student[] deleteStudent (Student student) throws SizeGroupException {
        boolean flag = true;
        if (student instanceof Student) {
            if (index == 0) {
                throw new SizeGroupException("It's not possible to delete Student from empty group: ", index);
            } else {
                for (int i = 0; i < index; i++) {
                    if (group[i].getLastName().equals(student.getLastName()) && group[i].getFirstName().equals(student.getFirstName())) {
                        Student[] temp = new Student[index - 1];
                        for (int j = 0; j < i; j++) {
                            temp[j] = group[j];
                        }
                        for (int j = i; j < index-1; j++) {
                            temp[j] = group[j + 1];
                        }
                        index--;
                        group = temp;
                        flag = false;
                    }
                }
            }
        }
        return group;
    }

    public Student searchStudent (Student student) {
        Student result = new Student();
        if (student instanceof Student) {
            for (int i = 0; i < index; i++) {
                if (group[i].getLastName().equals(student.getLastName()) && group[i].getFirstName().equals(student.getFirstName())) {
                    result = group[i];
                }
            }
        }
        return result;
    }

    public String viewMistakeList() {
        return "MistakeList{" + Arrays.toString(mistakeList) + '}';
    }

    public Student[] getArmyList() {
        int counter = 0;
        Student[] listArmy = new Student[index];
        for (int i = 0; i < index; i++) {
            if (group[i].askIfMan()) {
                if (group[i].askIfAge()) {
                    listArmy[counter++] = group[i];
                }
            }
        }
        listArmy = Arrays.copyOf(listArmy, counter);
        return listArmy;
    }

    public void sortLastName() {
        Arrays.sort(group, new StudentLastNameComparator());
    }

    public void sortParamLastName() {
        Arrays.sort(group, Student.LN_Comparator);
    }

    public void sortParamStudyResult() {
        Arrays.sort(group, Student.Study_Comparator);
    }

    public void sortParamRecordBook() {
        Arrays.sort(group, Student.RecordBook_Comparator);
    }

    public void interactAddStudent() throws InteractiveInputException {
            Student studentInter = new Student();
            studentInter.setLastName(studentInter.inputLastName());
            studentInter.setFirstName(studentInter.inputFirstName());
            studentInter.setSex(studentInter.inputSex());
        studentInter.setAge(studentInter.inputAge());
            for (int i = 0; i < index; i++) {
                if (studentInter.getLastName().equalsIgnoreCase(group[i].getLastName())  &&
                        studentInter.getFirstName().equalsIgnoreCase(group[i].getFirstName()) &&
                        studentInter.getAge() == group[i].getAge()) {
                    System.out.println("Student with such LastName, FirstName and Age is already exist.");
                    System.out.println("If you'll continue - you can possibly create duplicate of dates.");
                }
            }
            studentInter.setDepartment(studentInter.inputDepartment());
            studentInter.setGroupNumber(studentInter.inputGgroupNumber());
            studentInter.setRecordBook(studentInter.inputRecordBook());
            for (int i = 0; i < index; i++) {
                if (studentInter.getRecordBook() == group[i].getRecordBook()) {
                    throw new InteractiveInputException("The number of RecordBook is already used: ", null);
                }
            }
            studentInter.setStudyResult(studentInter.inputStudyResult());
            System.out.println(studentInter);

            try {
                addStudent(studentInter);
            } catch (SizeGroupException e) {
                System.out.println(e.getMessage() + e.getSize());
            } catch (StudentInfoException e) {
                System.out.println(e.getMessage() + e.getStudent());
            }
    }
}
