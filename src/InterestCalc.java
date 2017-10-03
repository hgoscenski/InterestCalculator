import java.util.Scanner;
/**
 * Firstly      -ask user for input, balance and interest rate
 * Secondly     -make a function to calculate interest
 * Thirdly      -the function will take three inputs
 *                  starting value- from user input
 *                  interest rate- from user input
 *                  term length- based on yearly,monthly,daily
 * Fourthly     -return the values
 *
 * Created by hgoscenski on 9/13/16.
 */
public class InterestCalc {
    public static void main(String[] args){
        while(true){
            Scanner reader = new Scanner(System.in);
            System.out.println("Please enter the balance as an whole number or -1 to exit: ");
            int startingValue = reader.nextInt();
            if(startingValue == -1){break;}
            System.out.println("Please enter the interest rate i.e. 5 for 5 percent:");
            Double interestRate = reader.nextDouble();
            System.out.println("The total value after ten years annually compounded: " + dailyInterest(startingValue, interestRate, 1));
            System.out.println("The total value after ten years monthly compounded: " + dailyInterest(startingValue, interestRate, 12));
            System.out.println("The total value after ten years daily compounded: " + dailyInterest(startingValue, interestRate, 365));
            System.out.println("Go ahead and enter another set or enter -1 to exit. \n");
        }
    }
    private static double dailyInterest(int startingValue, Double interestRate, int termLength){
        double endValue = startingValue;
        interestRate = interestRate / 100;
        int calcTime = termLength * 10;
        for(int i = 1; i <= calcTime; i++){
            endValue = endValue * (1+ (interestRate/termLength));
        }
        endValue = endValue*100;
        endValue = Math.round(endValue);
        endValue = endValue /100;
        return (endValue);
    }
}
