import java.util.Arrays;
import java.security.SecureRandom;

/**
 * Created by rubatharisan on 05/11/2016.
 */

public class Tester {


    public static void main(String args[]){

        /*
            Balls and bins for 10.007,
         */

        // Amount of Balls and Bins.
        int amountOfBallsAndBins = 10007;

        // Generate balls and bins with normal random distribution.
        int maxBalls = generateBallsForBins(amountOfBallsAndBins);

        // Generate balls and bins with power of two choice distribution.
        int maxBallsPOTC = generateBallsForBinsPOTC(amountOfBallsAndBins);

        // Get the stats.
        getStats(amountOfBallsAndBins, maxBalls, maxBallsPOTC);


        /*
            Balls and bins for 1.000.000,
        */

        // Amount of Balls and Bins.
        amountOfBallsAndBins = 1000000;

        // Generate balls and bins with normal random distribution.
        maxBalls = generateBallsForBins(amountOfBallsAndBins);

        // Generate balls and bins with power of two choice distribution.
        maxBallsPOTC = generateBallsForBinsPOTC(amountOfBallsAndBins);

        // Get the stats.
        getStats(amountOfBallsAndBins, maxBalls, maxBallsPOTC);

    }

    static int generateBallsForBins(int binsAndBalls){

        // Initiate an array with amount of bins and balls.
        int[] myBinsArray = new int[binsAndBalls];

        // Create a for loop which generates the random numbers.
        for (int i = 0; i < binsAndBalls; i++){

            // Java standard secure random algorithm.
            SecureRandom number = new SecureRandom();

            // Get a random number from our random number generator.
            int randomNumber = number.nextInt(binsAndBalls);
            //System.out.println(randomNumber);

            //System.out.println(randomNumber);

            // Get the index of random number and increment it with 1.
            myBinsArray[randomNumber]++;

        }



        //printMyBinsArray(myBinsArray);
        // Print out some text explaining the distribution.
        System.out.println("#####");
        System.out.println("## Normal random distribution");
        System.out.println("####");

        return getInfoOnBins(myBinsArray, binsAndBalls);
    }

    static int generateBallsForBinsPOTC(int binsAndBalls){

        // Initiate an array with amount of bins and balls.
        int[] myBinsArray = new int[binsAndBalls];

        // Create a for loop which generates the random numbers.
        for (int i = 0; i < binsAndBalls; i++){

            // Java standard secure random algorithm.
            SecureRandom rand = new SecureRandom();

            // Get the two bins
            int randomNumberBinOne = rand.nextInt(binsAndBalls);
            int randomNumberBinTwo = rand.nextInt(binsAndBalls);

            //System.out.println("First random: " + randomNumberBinOne + ", Second random: " + randomNumberBinTwo);

            // If the two bins are exactly the same bin - then decrement one of the bins with one.
            if(randomNumberBinOne == randomNumberBinTwo){
                if(randomNumberBinOne == 0){
                    randomNumberBinTwo = binsAndBalls - 1;
                } else {
                    randomNumberBinTwo = randomNumberBinTwo - 1;
                }
            }

            // Pick the bin with least balls, and increment it.
            if(myBinsArray[randomNumberBinOne] < myBinsArray[randomNumberBinTwo]){
                myBinsArray[randomNumberBinOne]++;
            } else {
                myBinsArray[randomNumberBinTwo]++;
            }

        }

        // Explain which distribution we are using.
        System.out.println("#####");
        System.out.println("## Power of two choices distribution");
        System.out.println("####");

        return getInfoOnBins(myBinsArray, binsAndBalls);
    }

    static int getInfoOnBins(int[] myBinsArray, int binsAndBalls){

        // Initiate variables
        int maxBalls = 0;
        int binNumber = 0;
        int moreThanOneBall = 0;
        int emptyBins = 0;
        int oneBallInABin = 0;

        System.out.println("---");
        System.out.println("Lets distribute " + binsAndBalls + " balls into " + binsAndBalls + " bins");
        System.out.println("--");

        // Loop through the array, and increment the variables.
        for (int i = 0; i < myBinsArray.length; i++){

            // Check bin and check the max balls in the bin.
            if(myBinsArray[i] > maxBalls){
                maxBalls = myBinsArray[i];
                //binNumber = i;
            }

            // If a bin contains more than one ball, increment moreThanOneBall.
            if(myBinsArray[i] > 1){
                moreThanOneBall++;
            }

            // If a bin is empty, increment emptyBins;
            if(myBinsArray[i] == 0){
                emptyBins++;
            }

            // If a bin has exactly one ball, increment oneBallInABin.
            if(myBinsArray[i] == 1){
                oneBallInABin++;
            }


        }

        // Print out useful info.
        System.out.println("Bin with a maximum " + maxBalls + " balls exists in our bins array");
        System.out.println("Bins with one ball: " + oneBallInABin + " bins");
        System.out.println("Bins with more than one ball: " + moreThanOneBall + " bins");
        System.out.println("Bins with no balls: " + emptyBins + " bins");
        System.out.println("");

        return maxBalls;
    }


    static void getStats(int binsAndBalls, int maxBalls, int maxBallsPOTC){
        System.out.println("");
        System.out.println("#####");
        System.out.println("## Calculation and conclusion");
        System.out.println("####");
        System.out.println("");

        System.out.println("------------------------------");

        System.out.println("# Normal random distribution");
        System.out.println("Expected number of max balls in a bin with the use of normal random distribution is expressed as: log(n)/log(log(n))");

        double normalDistribution = (log2(binsAndBalls))/log2(log2(binsAndBalls));
        int normalDistributionRoundedUp = (int) Math.ceil(normalDistribution);

        System.out.println("=> log(" + binsAndBalls + ")/log(log(" + binsAndBalls + ")) = " + normalDistribution + " ~ " + normalDistributionRoundedUp + " balls");

        System.out.println("");
        System.out.println("** Comparison with our test results:");

        if(maxBalls == normalDistributionRoundedUp || maxBalls < normalDistributionRoundedUp){
            System.out.println("Success, the amount of max balls in our test ( " + maxBalls + " balls ) is with in our threshold ( " + normalDistributionRoundedUp + " balls ) ");
        } else {
            System.out.println("Failure, the amount of max balls in our test ( " + maxBalls + " balls ) is not with in our threshold ( " + normalDistributionRoundedUp + " balls ).");
            System.out.println("Maybe my random generator is not truly random? Did I mess up somewhere in my code?");
        }


        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("# Power of two choice random distribution");

        double powerOfTwoDistribution = log2(log2(binsAndBalls));
        int powerOfTwoDistributionRoundedUp = (int) Math.ceil(powerOfTwoDistribution);

        System.out.println("Expected number of balls in a bin with the use of power of two choices is expressed as: log(log(n))");
        System.out.println("=> log(log(" + binsAndBalls + ")) = " + powerOfTwoDistribution + " ~ " + powerOfTwoDistributionRoundedUp + " balls");

        System.out.println("");

        System.out.println("** Comparison with our test results:");

        if(maxBallsPOTC == powerOfTwoDistributionRoundedUp || maxBallsPOTC < powerOfTwoDistributionRoundedUp){
            System.out.println("Success, the amount of max balls in a bin done by our test ( " + maxBallsPOTC + " balls ) is with in our threshold ( " + powerOfTwoDistributionRoundedUp + " balls ) ");
            System.out.println("Our theory is confirmed with: O(log(log(N)))");
        } else {
            System.out.println("Failure, the amount of max balls in a bin done by our test ( " + maxBallsPOTC + " balls ) is not with in our threshold ( " + powerOfTwoDistributionRoundedUp + " balls ).");
            System.out.println("Maybe my random generator is not truly random? Did I mess up somewhere in my code?");
            System.out.println("Can you run me again?");
        }

        System.out.println("------------------------------");

        System.out.println("");
        System.out.println("");
        System.out.println("");

    }

    static void printMyBinsArray(int[] myBinsArray){
        System.out.println(Arrays.toString(myBinsArray));
    }

    static double logb( double a, double b )
    {
        return Math.log(a) / Math.log(b);
    }

    static double log2( double a )
    {
        return logb(a,2);
    }


}
