package kiev.prog;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Group group1 = new Group();
        Student student1 = new Student("Z", "Sergiy", true, 18, 25, 1, 1024, 10.8);
        Student student2 = new Student("V", "Nataliya", false, 18, 25, 1, 1025, 9.6);
        Student student3 = new Student("A", "Alex", true, 17, 25, 1, 1026, 11.5);
        Student student4 = new Student("C", "Maria", false, 16, 25, 1, 1027, 8.4);
        Student student5 = new Student("T", "Stepan", true, 18, 25, 1, 1028, 9.3);
        Student student6 = new Student("S", "Stephan", true, 19, 25, 1, 1029, 10.9);
        Student student7 = new Student("L", "Olha", false, 17, 25, 1, 1030, 9.5);
        Student student8 = new Student("L", "Andrey", true, 20, 25, 1, 1031, 10.6);
        Student student9 = new Student("A", "Ihor", true, 18, 25, 1, 1032, 9.3);
        Student student10 = new Student("W", "Boris", true, 17, 25, 1, 1033, 8.2);

        Student student11 = new Student("S", "David", true, 21, 25, 1, 1034, 10.5);
        Student student12 = new Student("R", "Nick", true, 17, 25, 1, 1035, 10.2);
        Student student13 = new Student("F", "Peter", true, 19, 25, 1, 1036, 9.3);

        try {
            group1.addStudent(student1);
            group1.addStudent(student2);
            group1.addStudent(student3);
            group1.addStudent(student4);
            //group1.addStudent(student5);
            //group1.addStudent(student6);
            //group1.addStudent(student7);
            //group1.addStudent(student8);
            //group1.addStudent(student9);
            //group1.addStudent(student10);
            System.out.println(group1);

            group1.interactAddStudent();

            Student[] listArmy = group1.getArmyList();
            System.out.println("List Army: " + listArmy.length + " " + Arrays.toString(listArmy));

            /* sorted on Last Name */
            group1.sortLastName();
            System.out.println(group1);

            group1.sortParamRecordBook();
            System.out.println("Sorted on record book: " + group1);

            group1.sortParamStudyResult();
            System.out.println("Sorted on study result: " + group1);

            group1.sortParamLastName();
            System.out.println("Sorted on last name: " + group1);

            /* delete student from group */
            group1.deleteStudent(student2);
            System.out.println(group1);

            /* attempt to delete student which is not from this group */
            group1.deleteStudent(student12);
            System.out.println(group1);

            /* delete student from group */
            group1.deleteStudent(student3);
            System.out.println(group1);

            /* search student6 */
            System.out.println("Search student: " + group1.searchStudent(student6));

            /* search student12 which is not from this group */
            System.out.println("Search student: " + group1.searchStudent(student12));

            /* add student11 */
            group1.addStudent(student11);
            System.out.println(group1);

            /* add student12 */
            group1.addStudent(student12);
            System.out.println(group1);

            /*listArmy = group1.getArmyList();
            System.out.println("List Army: " + listArmy.length + " " + Arrays.toString(listArmy));*/

            /* add more students then size of group */
            group1.addStudent(student13);
            System.out.println(group1);



        } catch (SizeGroupException e) {
            System.out.println(e.getMessage() + e.getSize());
        } catch (StudentInfoException e) {
            System.out.println(e.getMessage() + e.getStudent());
        } catch (InteractiveInputException e) {
            System.out.println(e.getMessage());
        }

        /* view student after attempt to add student, when group size = 10 */
        System.out.println("MistakeList: " + group1.viewMistakeList());
    }
}
