import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program is to calculate the square root of a positive number.
 *
 * @author Hangxiao Zhu
 *
 */
public final class Newton5 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton5() {
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
    private static double krt(int k, double x, double epsilon) {
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

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //Ask the user to provide the root.
        out.println("Please provide the root: ");
        int root = in.nextInteger();

        // Ask the user to provide the expected relative error.
        out.println("Please provide your expected relative error: ");
        double e = in.nextDouble();

        // Ask the use to provide a positive number for calculating.
        out.println("Please provide a positive number:");
        double x = in.nextDouble();

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
