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
private static final String COMPUTE_PASCALS_TRIANGLE = "pascal's triangle";
private static final String COMPUTE_QUADRATIC = "quadratic";
private static final String COMPUTE_COMPOUND_INTEREST = "compound interest";
private static final Set<String> COMPUTE_TYPES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                    COMPUTE_PASCALS_TRIANGLE,
                    COMPUTE_QUADRATIC,
                    COMPUTE_COMPOUND_INTEREST
            )));
private static final Map<Integer, String> NUMBER_TO_COMPUTE_TYPE = Map.of(
        1, COMPUTE_PASCALS_TRIANGLE,
        2, COMPUTE_QUADRATIC,
        3, COMPUTE_COMPOUND_INTEREST
);
private static final Map<String, Integer> COMPUTE_TYPE_TO_NUMBER = Map.of(
        COMPUTE_PASCALS_TRIANGLE, 1,
        COMPUTE_QUADRATIC, 2,
        COMPUTE_COMPOUND_INTEREST, 3
);


   private static final Scanner scanner = new Scanner(System.in);

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
                String aString, bString, cString;
                boolean aPicked = false, bPicked = false, cPicked = false;
                do {
                    System.out.println("Enter a (a in ax² + bx + c = 0): ");
                    aString = scanner.nextLine();
                    if (!aPicked) {
                        try {
                            a = Integer.parseInt(aString);
                            aPicked = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter in a valid double!");
                            continue;
                        }
                    }
                    if (!bPicked) {
                        System.out.println("Enter b (a in ax² + bx + c = 0): ");
                        bString = scanner.nextLine();
                        try {
                            b = Integer.parseInt(bString);
                            bPicked = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter in a valid double!");
                            continue;
                        }
                    }
                    System.out.println("Enter c (a in ax² + bx + c = 0): ");
                    cString = scanner.nextLine();
                    try {
                            c = Integer.parseInt(cString);
                            cPicked = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter in a valid double!");
                        }
                }while (!aPicked || !bPicked || !cPicked);
                System.out.println("The two answers are: " + computeQuadratic(a, b, c));;
            }

        }
    }
    private static boolean isInt(String string){
        try {
            Integer.parseInt(string);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    private static String getUserOption(){
        String optionPicked = "";
        do {
            System.out.print("Choose and type in an option or its corresponding number to compute: ");
            int i = 0;
            for (String string : COMPUTE_TYPES) {
                i++;
                System.out.print(string + " (" + COMPUTE_TYPE_TO_NUMBER.get(string) + ")");
                if (i != COMPUTE_TYPES.size()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            String userInput = scanner.nextLine();
            if (isInt(userInput)){
                int numChosen = Integer.parseInt(userInput);
                optionPicked = NUMBER_TO_COMPUTE_TYPE.get(numChosen);
            }else{
                for (String string : COMPUTE_TYPES) {
                    if (userInput.equalsIgnoreCase(string)) {
                        optionPicked = string;
                        break;
                    }
                }
            }

        } while (optionPicked.equals(""));
        return optionPicked;
    }
    private static List<Double> computeQuadratic(double a, double b, double c){
        double formula = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        System.out.println(-b + -2);
        double xPos = (-b + (formula/2*a));
        double xNeg = (-b - (formula/2*a));
        return Arrays.asList(xPos, xNeg);
//        Test  questions: https://www.mathsisfun.com/algebra/quadratic-equation.html
//        2, 5, 3 -> -1, -3/2
    }
    private static void computePascalsTriangle(int rows){

    }
    private static double computeCompoundInterest(double principal, double rate, int frequency, int years){
        double amount = principal*Math.pow((1+rate/frequency), frequency*years);
        return Math.round(amount*100.0)/100.0;
    }
}