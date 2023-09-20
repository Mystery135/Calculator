import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    // Constants representing the functions of the calculator
    private static final String DRAW_SHAPE = "draw shape";
    private static final String COMPUTE_QUADRATIC = "quadratic";
    private static final String COMPUTE_COMPOUND_INTEREST = "compound interest";
    private static final String COMPUTE_TRIANGLE = "triangle";

    //Assigning the constants to a number
    private static final Map<Integer, String> NUMBER_TO_COMPUTE_TYPE = Map.of(
            1, DRAW_SHAPE,
            2, COMPUTE_QUADRATIC,
            3, COMPUTE_COMPOUND_INTEREST,
            4, COMPUTE_TRIANGLE
    );

    //Global scanner object to read user input
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Get user computation option using method
        String optionPicked = getUserOption();
        System.out.println("You picked " + optionPicked + "!");

        //Get user inputs and assign them to variables for user's chosen computation option
        switch (optionPicked) {
            case COMPUTE_COMPOUND_INTEREST -> {
                double principal = InputHelper.getDoubleInput(scanner, "Enter in the principal amount (starting value): ", "Error! Please enter in a valid double!", false);
                System.out.println();
                double rate = InputHelper.getDoubleInput(scanner, "Enter in the interest rate (decimal): ", "Error! Please enter in a valid double!", false);
                System.out.println();
                int frequency = InputHelper.getIntInput(scanner, "Enter in the amount of times interest is compounded per year: ", "Error! Please enter in a valid integer!", false);
                System.out.println();
                int years = InputHelper.getIntInput(scanner, "Enter in the amount of time you want to calculate for (years): ", "Error! Please enter in a valid integer!", false);
                System.out.println();

                //Send user inputs to computation method and print the answer
                System.out.println("\tAfter " + years + " years, you will have $" + computeCompoundInterest(principal, rate, frequency, years) + "!");
            }
            case DRAW_SHAPE -> {
                String pattern = InputHelper.getStringInput(scanner, "Enter in a pattern (1D). You may use any character, including \" and \\: ", true);
                System.out.println();
                int width = InputHelper.getIntInput(scanner, "Enter in the width of the drawing: ", "Error! Please enter in a valid integer!", false);
                System.out.println();
                int height = InputHelper.getIntInput(scanner, "Enter in the height of the drawing: ", "Error! Please enter in a valid integer!", false);
                System.out.println();

                //Send user inputs to computation method and print the drawing
                System.out.println(computeDrawShape(pattern, width, height));
            }
            case COMPUTE_QUADRATIC -> {
                double a = InputHelper.getDoubleInput(scanner, "Enter a (a in ax^2 + bx + c = 0): ", "Error! Please enter in a valid double!", false);
                System.out.println();
                double b = InputHelper.getDoubleInput(scanner, "Enter b (b in ax^2 + bx + c = 0): ", "Error! Please enter in a valid double!", false);
                System.out.println();
                double c = InputHelper.getDoubleInput(scanner, "Enter c (c in ax^2 + bx + c = 0): ", "Error! Please enter in a valid double!", false);
                System.out.println();

                //Send user inputs to computation method and print the answer
                System.out.println("\tThe two answers are: " + computeQuadratic(a, b, c));
            }
            case COMPUTE_TRIANGLE -> {
                int height = InputHelper.getIntInput(scanner, "Enter ths height of the triangle: ", "Error! Please enter in a valid integer!", false);
                System.out.println();

                //Send user inputs to computation method and print the drawing
                System.out.println(computeTriangle(height));
            }

        }
    }

    private static String getUserOption() {
        String optionPicked = "";
        //Prompt the user for what they want to compute. Do while loop so it runs once, and if the user inputs an incorrect value, loop again
        do {
            System.out.print("Choose and type in an option or its corresponding number to compute: ");
            int i = 0;
            //Loop through each compute type and print them with their corresponding numbers
            for (String string : NUMBER_TO_COMPUTE_TYPE.values()) {
                i++;
                System.out.print(string + " (" + i + ")");
                if (i != NUMBER_TO_COMPUTE_TYPE.values().size()) {
                    //Put commas between compute types if it is not the last compute type
                    System.out.print(", ");
                }
            }
            System.out.println();

            //Get user input as string
            String userInput = scanner.nextLine();

            //Check if user's input is string or integer using a helper method
            if (InputHelper.isInt(userInput)) {
                //If user's input is an integer, check if there is a corresponding compute type, then
                //find the corresponding compute type. After that, set optionPicked to the compute type selected
                if (Integer.parseInt(userInput) <= NUMBER_TO_COMPUTE_TYPE.values().size() && Integer.parseInt(userInput) > 0) {
                    int numChosen = Integer.parseInt(userInput);
                    optionPicked = NUMBER_TO_COMPUTE_TYPE.get(numChosen);
                }
            } else {
                //If user's input was a string, check if their input was valid, then set optionPicked to the compute type selected.
                for (String string : NUMBER_TO_COMPUTE_TYPE.values()) {
                    if (userInput.equalsIgnoreCase(string)) {
                        optionPicked = string;
                        break;
                    }
                }
            }

        } while (optionPicked.equals(""));
        return optionPicked;
    }

    //Compute quadratic formula. Part of formula used in both methods stored in a variable to avoid redundancy
    private static List<Double> computeQuadratic(double a, double b, double c) {
        double reusedFormula = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        double xPos = ((-b + reusedFormula) / (2 * a));
        double xNeg = ((-b - reusedFormula) / (2 * a));
        return Arrays.asList(xPos, xNeg);
    }
    //Draw shape based on user's pattern with nested for loops
    private static String computeDrawShape(String pattern, int width, int height) {
        //String builder to make joining strings easier
        StringBuilder builder = new StringBuilder();

        //Loop through each row of drawing
        for (int i = 0; i < height; i++) {
            //Loop through each column of drawing and add pattern
            for (int j = 0; j < width; j++) {
                builder.append(pattern);
            }
            //Start a new line
            builder.append("\n");
        }
        //Return the drawing
        return builder.toString();
    }

    //Compute compound interest based on user's inputs using the compound interest formula
    private static double computeCompoundInterest(double principal, double rate, int frequency, int years) {
        double amount = principal * Math.pow((1 + rate / frequency), frequency * years);
        return Math.round(amount * 100.0) / 100.0;
    }

    //Compute triangle drawing based on user's inputs
    private static String computeTriangle(int height) {
        //String builder to make joining strings easier
        StringBuilder builder = new StringBuilder();

        //Loop through each row of triangle
        for (int i = 0; i < height; i++) {
            //Add spaces to the left of the triangle
            for (int j = 0; j < (height - 1 - i); j++) {
                builder.append(" ");
            }
            //Add left side of the triangle
            builder.append("/");

            //Add spaces to fill up the triangle
            for (int j = 0; j < i * 2; j++) {
                if (i != height - 1) {
                    builder.append(" ");
                } else {
                    //If it's the last row, use _ instead of a space
                    builder.append("_");
                }
            }
            //Add the right side of the triangle
            builder.append("\\");
            //Start a new line
            builder.append("\n");
        }
        //Return the drawing
        return builder.toString();
    }
}