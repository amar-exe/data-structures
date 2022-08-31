package ba.edu.ibu;



import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        Student s = new Student();
        RedBlackTree<Integer, Student> redBlackTree = new RedBlackTree<>();

        ArrayList<Student> students = Student.readStudents("C:/Users/Amar/Downloads/Global_University_Students.csv");


        for (Student student : students) {
            redBlackTree.put(student.getStudentID(), student);
        }

        System.out.println("Put students successfully");

        searchStudent(redBlackTree);

        redBlackTree.countRedLinks();


    }

    public static void searchStudent(RedBlackTree redBlackTree) {
        Scanner studentReader = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        int studentScanner = studentReader.nextInt();
        HashMap<Integer, Node> readStudent = redBlackTree.get(studentScanner);
        if (readStudent.containsValue(null)) {
            System.out.println("No such student");
            for (Integer key: readStudent.keySet()){
                System.out.println("\nSteps taken : " + key);
            }
        } else {
            for (Integer key: readStudent.keySet()){
                System.out.println(readStudent.get(key));
                System.out.println("\nSteps taken : " + key);
            }
        }
    }
}


