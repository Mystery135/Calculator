import java.util.Scanner;

//Helper class to avoid redundancy
public class InputHelper {
    public static boolean isInt(String string){
        try {
            //Attempt to parse the string. If it does not error, return true. Otherwise, return false.
            Integer.parseInt(string);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static int getIntInput(Scanner scanner, String question, String errorMessage, boolean printLine){
        //Loop until user inputs valid int
        while (true){
            //If printLine is true, use System.out.println. Otherwise, use System.out.print.
            if (printLine){
                System.out.println(question);
            }else{
                System.out.print(question);
            }
            try {
                //Scan the next int. If this errors, print the error message and loop. Otherwise, return the int.
                int input = scanner.nextInt();
                return input;
            }catch (Exception e){
                System.out.println();
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }
    public static double getDoubleInput(Scanner scanner, String question, String errorMessage, boolean printLine){
        //Loop until user inputs valid int
        while (true){
            //If printLine is true, use System.out.println. Otherwise, use System.out.print.
            if (printLine){
                System.out.println(question);
            }else{
                System.out.print(question);
            }
            try {
                //Scan the next double. If this errors, print the error message and loop. Otherwise, return the doubke.
                double input = scanner.nextDouble();
                return input;
            }catch (Exception e){
                System.out.println();
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }
    public static String getStringInput(Scanner scanner, String question, boolean printLine){
        //If printLine is true, use System.out.println. Otherwise, use System.out.print.
        if (printLine){
                System.out.println(question);
            }else{
                System.out.print(question);
            }
                //Return the string input
                String input = scanner.nextLine();
                return input;
    }


}
