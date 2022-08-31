package ba.edu.ibu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    public int studentID;
    public int yearOfEnrolment;
    public String nameAndSurname;
    public String dateOfBirth;
    public String universityName;
    public String departmentCode;
    public String departmentName;

    public Student(){}

    public Student(int studentID, int yearOfEnrolment, String nameAndSurname, String dateOfBirth, String universityName, String departmentCode, String departmentName) {
        this.studentID = studentID;
        this.yearOfEnrolment = yearOfEnrolment;
        this.nameAndSurname = nameAndSurname;
        this.dateOfBirth = dateOfBirth;
        this.universityName = universityName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getYearOfEnrolment() {
        return yearOfEnrolment;
    }

    public void setYearOfEnrolment(int yearOfEnrolment) {
        this.yearOfEnrolment = yearOfEnrolment;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /* Read the IPAddress list from a file in the given path */
    public static ArrayList<Student> readStudents(String path) throws FileNotFoundException {
        ArrayList<Student> students= new ArrayList<Student>(); // I used ArrayList because the size of the binary tree will constantly be changing


        BufferedReader objReader = null;
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(path));

            while ((strCurrentLine = objReader.readLine()) != null) {

                students.add(convertToStudent(strCurrentLine));
            }

        } catch (IOException err) {

            err.printStackTrace();

        } finally {

            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
        System.out.println("Read Successfully");
        return students;
    }


    /*Converts the .csv file students into ones usable by our class*/
    public static Student convertToStudent(String raw) {
        String[] splitted = raw.split(";"); //splitting the string by commas surrounded by quotation marks in both sides
        int studentID = Integer.parseInt(splitted[0]);
        String nameAndSurname = splitted[1];
        String dateOfBirth = splitted[2];
        String universityName = splitted[3];
        String departmentCode = splitted[4];
        String departmentName = splitted[5];
        int yearOfEnrolment = Integer.parseInt(splitted[6]);

        return new Student(studentID, yearOfEnrolment, nameAndSurname,
                dateOfBirth, universityName, departmentCode, departmentName);

    }

    @Override
    public String toString() {
        return ("Student ID: " + this.studentID + "\nName and Surname: " +
                this.nameAndSurname + "\nDate Of Birth: " +
                this.dateOfBirth + "\nUniversity Name: " +
                this.universityName + "\nDepartment Code: " +
                this.departmentCode + "\nDepartment Name: " +
                this.departmentName);
    }


}
