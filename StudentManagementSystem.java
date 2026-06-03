import java.io.*;
import java.util.*;

class Student implements Serializable {

    String rollNumber;
    String name;
    String grades;
    int year;
    String branch;
    String phoneNumber;

    Student(String rollNumber, String name, String grades, int year, String branch, String phoneNumber) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grades = grades;
        this.year = year;
        this.branch = branch;
        this.phoneNumber = phoneNumber;
    }

    void display() {
        System.out.println("Name         : " + name);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Grades /cgpa      : " + grades);
        System.out.println("Year         : " + year);
        System.out.println("Branch       : " + branch);
        System.out.println("Phone Number : " + phoneNumber);
        System.out.println("--------------------------------");
    }
}

public class StudentManagementSystem {

    static final String FILE_NAME = "students.dat";
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();


    // Load students from file
    static void loadStudents() {
        try {
            FileInputStream file = new FileInputStream(FILE_NAME);
            ObjectInputStream in = new ObjectInputStream(file);
            students = (ArrayList<Student>) in.readObject();
            in.close();
        } catch (Exception e) {
            students = new ArrayList<>();
        }
    }


    // Save students to file
    static void saveStudents() {
        try {
            FileOutputStream file = new FileOutputStream(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(students);
            out.close();
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }


    // Check duplicate roll number
    static boolean rollExists(String roll) {
        for (Student s : students) {
            if (s.rollNumber.equalsIgnoreCase(roll))
                return true;
        }
        return false;
    }


    // Validate roll number (letters + numbers)
    static boolean validRoll(String roll) {
        return roll.matches("[A-Za-z0-9]+");
    }


    // Validate phone number
    static boolean validPhone(String phone) {
        return phone.matches("\\d{10}");
    }


    // Add Student
    static void addStudent() {

        System.out.print("Enter Roll Number (letters + numbers): ");
        String roll = sc.nextLine();

        if (!validRoll(roll)) {
            System.out.println("Invalid roll number. Only letters and numbers allowed.");
            return;
        }

        if (rollExists(roll)) {
            System.out.println("Error: Roll number already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Grades: ");
        String grades = sc.nextLine();

        System.out.print("Enter Year (1-4): ");
        int year = sc.nextInt();
        sc.nextLine();

        if (year < 1 || year > 4) {
            System.out.println("Error: Year must be between 1 and 4.");
            return;
        }

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter Phone Number (10 digits): ");
        String phone = sc.nextLine();

        if (!validPhone(phone)) {
            System.out.println("Error: Invalid phone number.");
            return;
        }

        students.add(new Student(roll, name, grades, year, branch, phone));
        saveStudents();

        System.out.println("Student added successfully.");
    }


    // View Students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n----- Student Records -----");

        for (Student s : students) {
            s.display();
        }

        System.out.println("Total Students: " + students.size());
    }


    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter Roll Number to delete: ");
        sc.nextLine();
        String roll = sc.nextLine();

        Iterator<Student> it = students.iterator();
        boolean found = false;

        while (it.hasNext()) {

            Student s = it.next();

            if (s.rollNumber.equalsIgnoreCase(roll)) {

                System.out.print("Are you sure you want to delete this record? (y/n): ");
                char confirm = sc.next().charAt(0);

                if (confirm == 'y' || confirm == 'Y') {
                    it.remove();
                    saveStudents();
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("Deletion cancelled.");
                }

                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Record not found.");
    }


    // Update Student
    static void updateStudent() {

        System.out.print("Enter Roll Number to update: ");
        sc.nextLine();
        String roll = sc.nextLine();

        for (Student s : students) {

            if (s.rollNumber.equalsIgnoreCase(roll)) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Grades: ");
                s.grades = sc.nextLine();

                System.out.print("Enter New Year (1-4): ");
                s.year = sc.nextInt();
                sc.nextLine();

                if (s.year < 1 || s.year > 4) {
                    System.out.println("Invalid year.");
                    return;
                }

                System.out.print("Enter New Branch: ");
                s.branch = sc.nextLine();

                System.out.print("Enter New Phone Number: ");
                s.phoneNumber = sc.nextLine();

                if (!validPhone(s.phoneNumber)) {
                    System.out.println("Invalid phone number.");
                    return;
                }

                saveStudents();
                System.out.println("Record updated successfully.");
                return;
            }
        }

        System.out.println("Record not found.");
    }


    // Search Student
    static void searchStudent() {

        System.out.println("Search by:");
        System.out.println("1. Roll Number");
        System.out.println("2. Name");

        int choice = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        if (choice == 1) {

            System.out.print("Enter Roll Number: ");
            String roll = sc.nextLine();

            for (Student s : students) {
                if (s.rollNumber.equalsIgnoreCase(roll)) {
                    s.display();
                    found = true;
                }
            }

        } else if (choice == 2) {

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            for (Student s : students) {
                if (s.name.equalsIgnoreCase(name)) {
                    s.display();
                    found = true;
                }
            }

        } else {
            System.out.println("Invalid choice.");
        }

        if (!found)
            System.out.println("Record not found.");
    }


    public static void main(String[] args) {

        loadStudents();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.println("---------------------------------");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    searchStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
