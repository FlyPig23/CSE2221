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
public final class Newton3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton3() {
    }

    /**
     * Computes estimate of square root of x to within relative error epsilon.
     *
     * @param x
     *            positive number to compute square root of
     * @param epsilon
     *            the expected relative error
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {
        double guess = x;
        double verify = (guess * guess - x) / x;

        if (x == 0) {
            guess = 0;
        } else {
            while (!(verify < epsilon * epsilon
                    && (-epsilon * epsilon) < verify)) {
                if (guess * guess > x) {
                    guess = (guess + x / guess) / 2;
                }
                verify = (guess * guess - x) / x;
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

        // Ask the user to provide the expected relative error.
        out.println("Please provide your expected relative error: ");
        double e = in.nextDouble();

        // Ask the use to provide a positive number for calculating.
        out.println("Please provide a positive number:");
        double x = in.nextDouble();

        // Calculate and print the square root of the positive number provided.
        out.println("The square root of " + x + " is " + sqrt(x, e));

        // Ask the user whether to continue calculating another square root.
        out.println("Do you want to calculate another square root? "
                + "Input \"y\" for yes and anything else for no: ");
        String decision = in.nextLine();

        /*
         * If the user wish to continue then continue calculating and keep
         * asking whether to continue calculating another square root.
         */
        while (decision.equals("y")) {
            out.println("Please provide a positive number:");
            x = in.nextDouble();
            out.println("The square root of " + x + " is " + sqrt(x, e));
            out.println("Do you want to calculate another square root? "
                    + "Input \"y\" for yes and anything else for no: ");
            decision = in.nextLine();
        }

        /*
         * If the user doesn't wish to calculating another square root then quit
         * the program.
         */
        if (!decision.equals("y")) {
            out.println("Thank you! Have a good day!");
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
