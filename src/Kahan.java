//https://www.geeksforgeeks.org/kahan-summation-algorithm/
public class Kahan {
    // Function to implement the Kahan
    // summation algorithm
    private static double kahanSum(double... fa)
    {
        double sum = 0.0;

        // Variable to store the error
        double c = 0.0;

        // Loop to iterate over the array
        for (double f : fa) {

            double y = f - c;
            double t = sum + y;

            // Algebraically, c is always 0
            // when t is replaced by its
            // value from the above expression.
            // But, when there is a loss,
            // the higher-order y is cancelled
            // out by subtracting y from c and
            // all that remains is the
            // lower-order error in c
            c = (t - sum) - y;

            sum = t;
        }

        return sum;
    }

    // Function to implement the sum
    // of an array
    private static double sum(double... fa)
    {
        double sum = 0.0;

        // Loop to find the sum of the array
        for (double f : fa) {
            sum = sum + f;
        }

        return sum;
    }

    // Driver code
    public static void main(String[] args)
    {
        double[] no = new double[10];
        for (int i = 0; i < no.length; i++) {
            no[i] = 0.1;
        }

//        double[] no = new double[4];
//        no[0]=1.0; no[1]=1e100; no[2]=1.0;no[3]=-1e100;

        // Comparing the results
        System.out.println("Normal sum: " + sum(no));
        System.out.println("Kahan sum: " + kahanSum(no));
    }
}