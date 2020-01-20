import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * This program is to calculate the square root of a positive number.
 *
 * @author Hangxiao Zhu
 *
 */
public final class Newton6 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton6() {
    }

    /**
     * Computes estimate of k-th root of x to within relative error epsilon.
     *
     * @param k
     *            the root
     * @param x
     *            positive number to compute square root of
     * @param epsilon
     *            the expected relative error
     * @return estimate of square root
     */
    private static double krt(double k, double x, double epsilon) {
        double guess = x;
        double verify = (Math.pow(guess, k) - x) / x;

        if (x == 0) {
            guess = 0;
        } else {
            while (!(verify < epsilon * epsilon
                    && (-epsilon * epsilon) < verify)) {
                if (Math.pow(guess, k) > x) {
                    guess = ((k - 1) * guess + x / Math.pow(guess, k - 1)) / k;
                    verify = (Math.pow(guess, k) - x) / x;
                }
            }
        }

        return guess;
    }

    private static double checkAndConvert(String str) {
        double result = 0;
        // Check whether the user input a real number.
        if (FormatChecker.canParseDouble(str)) {
            result = Double.parseDouble(str);
        }
        return result;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        boolean flag = true;

        //Ask the user to provide the root.
        double root = 0;
        while (flag) {
            out.println("Please provide the root: ");
            String inputRoot = in.nextLine();
            if (checkAndConvert(inputRoot) >= 2) {
                root = checkAndConvert(inputRoot);
                flag = false;
            } else {
                out.println(
                        "You should provide a root which is greater than or equal to 2!");
            }
        }

        flag = true;
        // Ask the user to provide the expected relative error.
        double e = 1;
        while (flag) {
            out.println("Please provide your expected relative error: ");
            String inputE = in.nextLine();
            if (checkAndConvert(inputE) > 0) {
                e = checkAndConvert(inputE);
                flag = false;
            } else {
                out.println("You should provide a positive real number!");
            }
        }

        flag = true;
        // Ask the use to provide a positive number for calculating.
        double x = 1;
        while (flag) {
            out.println("Please provide a positive number:");
            String inputX = in.nextLine();
            if (checkAndConvert(inputX) > 0) {
                x = checkAndConvert(inputX);
                flag = false;
            } else {
                out.println("You should provide a positive real number!");
            }
        }

        // Calculate and print the square root of the positive number provided.
        out.println("The square root of " + x + " is " + krt(root, x, e));

        // Ask the user to provide another number.
        out.println("Please provide another number. "
                + "If you privide a negative number then the program will quit.");
        x = in.nextDouble();

        /*
         * If the user provides a positive number then continue calculating and
         * keep asking the user to provide another number.
         */
        while (x >= 0) {
            out.println("The square root of " + x + " is " + krt(root, x, e));
            out.println("Please provide another number. "
                    + "If you privide a negative number then the program will quit.");
            x = in.nextDouble();
        }

        // If the user provides a negative number then quit the program.
        if (x < 0) {
            out.println("Thank you! Have a good day!");
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
