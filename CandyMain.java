import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class CandyMain {

	public static void load() throws URISyntaxException, IOException {

		URL openKeyFile = CandyMain.class.getResource("input.txt");
		Scanner sc = new Scanner(new File(openKeyFile.toURI()));
		
		// Used to output for debugging.
		int inputCase = 1;

		int numOfCandy = sc.nextInt();
		double totalMoney = sc.nextDouble();

		// 0 0.00 is the terminating condition for accepting input.
		while (numOfCandy != 0 && totalMoney != 0) {
			
			// Print statement for debugging.
			System.out.println("Input put case " + inputCase + " with $" + totalMoney + ":");
			
			// Initialize both input arrays.
			int[] caloriesArray = new int[numOfCandy];
			double[] moneyArray = new double[numOfCandy];

			// Loads both arrays with value from an input file.
			for(int i = 0; i < numOfCandy; i++)
			{
				caloriesArray[i] = sc.nextInt();
				moneyArray[i] = sc.nextDouble();
			}
			
			// Prints both arrays for debugging purposes.
			for(int i = 0; i < numOfCandy; i++)
			{
				System.out.print(caloriesArray[i] + " ");
				System.out.println(moneyArray[i]);
			}
			
			// Initialize a used array.
			boolean[] used = new boolean[numOfCandy];
			

			// Call the function that returns the most calories possible.
			int mostCalories = findMostCalories(caloriesArray, moneyArray, totalMoney, numOfCandy-1, used);

			System.out.println(mostCalories);

			// Reset used array before next looping.
			for(int i = 0; i < numOfCandy; i++)
				used[i] = false;
			
			// Increase case count.
			inputCase++;

			// Take in the next line and compare at while loop.
			numOfCandy = sc.nextInt();
			totalMoney = sc.nextDouble();

		}

		sc.close();
	}

	// This would would the problem and return the smallest amount of calories.
	public static int findMostCalories(int[] calories, double[] money, double cash, int index, boolean[] used) {

		if(index < 0)
			return 0;
		
		if(money[index] > cash)
			return findMostCalories(calories, money, cash, index-1, used);
		
		double one = findMostCalories(calories, money, cash, index-1, used);
		double two = findMostCalories(calories, money, cash - money[index], index, used) + calories[index];
		
		if(one < two)
			used[index] = true;
		
		return (int) (Math.max(one, two));
	}

	public static void main(String[] args) {

		try {
			load();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
