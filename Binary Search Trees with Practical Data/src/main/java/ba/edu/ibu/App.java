package ba.edu.ibu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws FileNotFoundException {

    Student s = new Student();
    BinarySearchTree<Integer, Student> binarySearchTree = new BinarySearchTree<>();


    ArrayList<Student> students = Student.readStudents("C:/Users/Amar/Downloads/Global_University_Students.csv");

    for (Student student : students) {

      binarySearchTree.put(student.getStudentID(), student);


    }

    System.out.println("Put students successfully");



    Scanner actionReader = new Scanner(System.in);
    Scanner studentReader = new Scanner(System.in);
    boolean shouldLoop = true;

    while(shouldLoop) {
      System.out.println("===========================================");

      System.out.println("Press 2 to traverse tree");
      System.out.println("Press 1 to search for a student");
      System.out.println("Press 0 to exit program");
      System.out.println("Your input: ");
      int actionScanner = actionReader.nextInt();

      if(actionScanner == 1){
        System.out.println("Enter student ID: ");
        int studentScanner = studentReader.nextInt();
        Student readStudent = binarySearchTree.get(studentScanner);
        if(readStudent == null) {
          System.out.println("No such student");
        }
        else {
          System.out.println(readStudent);
        }
      }

      else if(actionScanner == 0) {
        System.out.println("Exiting program...");
        shouldLoop = false;
      }

      else if(actionScanner == 2) {

        Scanner traverseTree = new Scanner(System.in);
        System.out.println("Press 1 to traverse inorder");
        System.out.println("Press 2 to traverse postorder");
        System.out.println("Press 3 to traverse preorder");

        int order = traverseTree.nextInt();

        if(order == 1) {
          System.out.println("Enter the number of elements");
          int numOfElements = traverseTree.nextInt();
          binarySearchTree.inorder(numOfElements);
        }

        else if(order==2) {
          System.out.println("Enter the number of elements");
          int numOfElements = traverseTree.nextInt();
          binarySearchTree.postorder(numOfElements);
        }

        else if(order==3) {
          System.out.println("Enter the number of elements");
          int numOfElements = traverseTree.nextInt();
          binarySearchTree.preorder(numOfElements);
        }
        else {
          System.out.println("Invalid input");
        }

      }

      else {
        System.out.println("Invalid input");
        shouldLoop = false;
      }


    }

  }
  
}
