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
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double guess = x;
        final double epsilon = 0.0001;
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

        out.println("Please provide a positive number:");
        double x = in.nextDouble();
        out.println("The square root of " + x + " is " + sqrt(x));

        out.println("Do you want to calculate another square root? "
                + "Input \"y\" for yes and anything else for no: ");
        String decision = in.nextLine();

        while (decision.equals("y")) {
            out.println("Please provide a positive number:");
            x = in.nextDouble();
            out.println("The square root of " + x + " is " + sqrt(x));
            out.println("Do you want to calculate another square root? "
                    + "Input \"y\" for yes and anything else for no: ");
            decision = in.nextLine();
        }

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
