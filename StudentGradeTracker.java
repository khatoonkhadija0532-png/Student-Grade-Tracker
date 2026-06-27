import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    int total;
    double average;
    char grade;

    // Constructor
    Student(String name, int rollNo, int total, double average, char grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.total = total;
        this.average = average;
        this.grade = grade;
    }

    // Display student report
    void displayReport() {
        System.out.println("\n--------------------------------------");
        System.out.println("           STUDENT REPORT");
        System.out.println("--------------------------------------");
        System.out.println("Name        : " + name);
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Total Marks : " + total);
        System.out.println("Average     : " + average);
        System.out.println("Grade       : " + grade);

        if (grade == 'A') {
            System.out.println("Suggestion  : Excellent! Keep practicing.");
        } else if (grade == 'B') {
            System.out.println("Suggestion  : Good work. Improve your weak subjects.");
        } else if (grade == 'C') {
            System.out.println("Suggestion  : Practice daily and revise regularly.");
        } else {
            System.out.println("Suggestion  : Work hard and seek help from teachers.");
        }

        System.out.println("--------------------------------------");
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n========= STUDENT GRADE TRACKER =========");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Find Topper");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();

                    System.out.print("Enter Number of Subjects: ");
                    int subjects = sc.nextInt();

                    int total = 0;

                    for (int i = 1; i <= subjects; i++) {
                        System.out.print("Enter Marks of Subject " + i + ": ");
                        total += sc.nextInt();
                    }

                    double average = (double) total / subjects;

                    char grade;

                    if (average >= 90)
                        grade = 'A';
                    else if (average >= 75)
                        grade = 'B';
                    else if (average >= 60)
                        grade = 'C';
                    else
                        grade = 'D';

                    Student s = new Student(name, roll, total, average, grade);

                    students.add(s);

                    System.out.println("\nStudent Added Successfully!");

                    break;

                case 2:

                    if (students.isEmpty()) {
                        System.out.println("No Student Records Found.");
                    } else {

                        for (Student st : students) {
                            st.displayReport();
                        }

                    }

                    break;



                case 3:

                    System.out.print("Enter Roll Number: ");
                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (Student st : students) {

                        if (st.rollNo == searchRoll) {
                            st.displayReport();
                            found = true;
                            break;
                        }

                    }

                    if (!found)
                        System.out.println("Student Not Found!");

                    break;

                case 4:

                    if (students.isEmpty()) {
                        System.out.println("No Student Records.");
                    } else {

                        Student topper = students.get(0);

                        for (Student st : students) {

                            if (st.average > topper.average) {
                                topper = st;
                            }

                        }

                        System.out.println("\n**** CLASS TOPPER ****");
                        topper.displayReport();

                    }

                    break;

                case 5:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 5);

        sc.close();
    }
}