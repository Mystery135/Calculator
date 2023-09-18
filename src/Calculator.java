import javax.xml.datatype.DatatypeConstants;
import java.util.*;

public class Calculator {
//    You are to create an interactive "calculator"
//    that computes three interesting things using methods
//    (binomial expansion, quadratic equation, drawing objects or
//    designs of different sizes, calculating taxes and tips on dinners, etc.).
//    You are to ask for user input as to which calculation/operation to perform as well as,
//    possibly, input required parameters.
//    Inclusion of all elements: 10 points
//    Does the program work? 2 points
//    Is the program easy to follow? 3 points
//    Is the program streamlined (efficient use of code)? 5 points
public static final String COMPUTE_PASCALS_TRIANGLE = "pascal's triangle";
public static final String COMPUTE_QUADRATIC = "quadratic";
public static final String COMPUTE_COMPOUND_INTEREST = "compound interest";
public static final Set<String> COMPUTE_TYPES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                    COMPUTE_PASCALS_TRIANGLE,
                    COMPUTE_QUADRATIC,
                    COMPUTE_COMPOUND_INTEREST
            )));
   private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String optionPicked = getUserOption();
        System.out.println("You picked " + optionPicked + "!");

        switch (optionPicked){
            case COMPUTE_COMPOUND_INTEREST -> {
                double principal = 0, rate = 0;
                int frequency = 0, years = 0;
                String principalString, rateString, frequencyString, yearsString;
                boolean principalChosen = false, rateChosen = false, frequencyChosen = false, yearsChosen = false;
                do{
                    if (!principalChosen) {
                        System.out.print("Enter in the principal amount (starting value): ");
                        principalString = scanner.nextLine();
                        try {
                            principal = Double.parseDouble(principalString);
                            principalChosen = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter in a valid double!");
                            continue;
                        }
                    }
                    if (!rateChosen) {
                        System.out.print("Enter in the interest rate (decimal): ");
                        rateString = scanner.nextLine();
                        try {
                            rate = Double.parseDouble(rateString);
                            rateChosen = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter in a valid double!");
                            continue;
                        }
                    }
                    if (!frequencyChosen) {
                        System.out.print("Enter in the amount of times interest is compounded per year: ");
                        frequencyString = scanner.nextLine();
                        try {
                            frequency = Integer.parseInt(frequencyString);
                            frequencyChosen = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter in a valid integer!");
                            continue;
                        }
                    }
                    System.out.print("Enter in the amount of time you want to calculate for (years): ");
                    yearsString = scanner.nextLine();
                    try {
                        years = Integer.parseInt(yearsString);
                        yearsChosen = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter in a valid integer!");
                        continue;
                    }
                }while(!principalChosen || !rateChosen || !frequencyChosen || !yearsChosen);
                System.out.println("After " + years + " years, you will have $" + computeCompoundInterest(principal, rate, frequency, years) + "!");
            }
            case COMPUTE_PASCALS_TRIANGLE ->{
//                do {
//                    computePascalsTriangle();
//                }while ();
            }
            case COMPUTE_QUADRATIC -> {
                double a = 0, b = 0, c = 0;
                boolean aPicked = false, bPicked = false, cPicked = false;
                do {
                    System.out.println("Enter a (a in ax² + bx + c = 0): ");
                    try {

                    }catch (NumberFormatException e){

                    }
                }while (!aPicked && bPicked && cPicked);
            }

        }
    }
    private static String getUserOption(){
        String optionPicked = "";
        do {
            System.out.print("Choose and type in an option to compute: ");
            int i = 0;
            for (String string : COMPUTE_TYPES) {
                i++;
                System.out.print(string);
                if (i != COMPUTE_TYPES.size()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            String userInput = scanner.nextLine();
            for (String string : COMPUTE_TYPES) {
                if (userInput.equalsIgnoreCase(string)) {
                    optionPicked = string;
                    break;
                }
            }
        } while (optionPicked.equals(""));
        return optionPicked;
    }
    private static void computeQuadratic(int x, int y){


    }
    private static void computePascalsTriangle(int rows){

    }
    private static double computeCompoundInterest(double principal, double rate, int frequency, int years){
        double amount = principal*Math.pow((1+rate/frequency), frequency*years);
        return Math.round(amount*100.0)/100.0;
    }
}