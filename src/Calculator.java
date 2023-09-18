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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("You picked " + optionPicked + "!");
    }

    private void computeQuadratic(){

    }
    private void computePascalsTriangle(){

    }
    private void computeCompoundInterest(){



    }




}
