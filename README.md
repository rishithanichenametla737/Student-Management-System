# 🎓 Student Management System

A console-based **Student Management System** built in **Java** that allows users to manage student records efficiently. The application supports full CRUD operations and stores data persistently using Java File Serialization.

---

## 📌 Features

- ➕ **Add Student** — Add a new student with roll number, name, grades, year, branch, and phone number
- 📋 **View Students** — Display all student records with total count
- ✏️ **Update Student** — Modify existing student details by roll number
- ❌ **Delete Student** — Remove a student record with confirmation prompt
- 🔍 **Search Student** — Search by roll number or name
- 💾 **Persistent Storage** — All data is saved to a `.dat` file and loaded automatically on next run

---

## 🛠️ Technologies Used

- **Language:** Java
- **Concepts:** Object-Oriented Programming (OOPs), File I/O, Serialization
- **Collections:** ArrayList, Iterator
- **Input Handling:** Scanner class
- **Validation:** Regular Expressions (regex)

---

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or above installed
- Any IDE (VS Code, IntelliJ, Eclipse) or Command Prompt / Terminal

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/your-username/Student-Management-System.git
cd Student-Management-System
```

**2. Compile the Java file**
```bash
javac StudentManagementSystem.java
```

**3. Run the program**
```bash
java StudentManagementSystem
```

---

## 📸 Sample Output

```
=================================
     STUDENT MANAGEMENT SYSTEM
=================================
1. Add Student
2. View Students
3. Delete Student
4. Update Student
5. Search Student
6. Exit
---------------------------------
Enter your choice:
```

---

## 📂 Project Structure

```
Student-Management-System/
│
├── StudentManagementSystem.java   # Main source code
├── students.dat                   # Auto-generated data file (after first run)
└── README.md                      # Project documentation
```

---

## ✅ Input Validations

| Field        | Validation Rule                          |
|--------------|------------------------------------------|
| Roll Number  | Only letters and numbers allowed         |
| Year         | Must be between 1 and 4                  |
| Phone Number | Must be exactly 10 digits                |
| Duplicate    | Duplicate roll numbers are not allowed   |

---

## 👩‍💻 Author

**Nichenametla Rishitha**
B.Tech – Computer Science & Engineering
Ravindra College of Engineering for Women

- 🔗 [LinkedIn](https://linkedin.com/in/rishitha-nichenametla-52553932b)
- 💻 [LeetCode](https://leetcode.com/u/Rishithanichenametla/)
- 🏆 [CodeChef](https://codechef.com/users/rishitha_737)

---

## 📄 License

This project is open source and available for educational purposes.
