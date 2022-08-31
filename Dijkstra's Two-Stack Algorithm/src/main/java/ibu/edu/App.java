package ibu.edu;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner reader = new Scanner(System.in);

    System.out.println("Input an expression: ");
    String expression = reader.nextLine();

    if (checkIfValid(expression)) {
      perfOp(expression);
    } else {
      System.out.println("Invalid expression.");
    }


  }
     public static void perfOp(String s) {
    String[] str = s.split("\\s+"); //Splitting the inputted string into separate values

    Stack<Double> values = new Stack<Double>(); //Value Stack
    Stack<String> operands = new Stack<String>(); //Operand Stack

    for (int i = 0; i < str.length; i++) { //Looping through the inputted string
      String currentChar = str[i]; //Setting a new value through each iteration of the loop

      switch (currentChar) { //Looks for an operation or bracket
        case "(": //Left brackets are skipped
          break;
        case "+":
        case "-":
        case "*":
        case "/":
        case "%":
          operands.push(currentChar); //+, -, *, / and % are sent to the operation Stack
          break;
        case ")":
          values.push(evaluateOp(operands, values)); //Right brackets activates the evaluateOp method
          break;
        default:
          values.push(Double.parseDouble(currentChar));  //If currentChar -> Current character,
                                                        // is not an operation or bracket, it has to be a value
          break;
      }
    }
    System.out.println(s + " = " + evaluateOp(operands, values)); //Prints out the value of the expression
    }


  private static Double evaluateOp(Stack<String> operands, Stack<Double> values) {
    double tempVal = values.pop(); //Pops the first value from the stack
    if (!operands.isEmpty()) { //Checks if the operands Stack is empty, if not proceed with operations
      String op = operands.pop(); //Sets a temp value for the operation currently being checked
      switch (op) { //Each case pops another value from the Stack and adds it
        case "+":
          tempVal = values.pop() + tempVal;
          break;
        case "-":
          tempVal = values.pop() - tempVal;
          break;
        case "*":
          tempVal = values.pop() * tempVal;
          break;
        case "/":
          tempVal = values.pop() / tempVal;
          break;
        case "%":
          tempVal = values.pop() % tempVal;
          break;
        default:
          break;
      }
    }
    return tempVal;
  }

  public static boolean checkIfValid(String s) {
    String[] str = s.split("\\s+");

    for (int i = 0; i<str.length; i++) {
      if (isNumeric(str[i]) || isOperand(str[i])) {
        continue;
      } else return false;
    }
    return true;
  }

  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch(NumberFormatException e){
      return false;
    }
  }

  public static boolean isOperand(String str) {
    switch (str) {
      case "(":
      case "+":
      case "-":
      case "*":
      case "/":
      case "%":
      case ")":
        return true;
      default:
        return false;
    }
  }
  }
