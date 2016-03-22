import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.plaf.InputMapUIResource;

public class CandyMain {
	
	public static final int WIDTH = 2;

	public static void load() throws URISyntaxException, IOException {

		URL openKeyFile = CandyMain.class.getResource("input.txt");
		Scanner sc = new Scanner(new File(openKeyFile.toURI()));
		
		// Input for debugging.
		int inputCase = 1;
		
		int numOfCandy = sc.nextInt();
		double totalCash = sc.nextDouble();
		
		
		while(numOfCandy != 0 && totalCash != 0)
		{
			System.out.println("Input put case " + inputCase + ":");
			// First index contains the number
			double[][] inputMatrix = new double[numOfCandy][WIDTH];
			
			for(int i = 0; i < numOfCandy; i++)
			{
				for(int j = 0; j < WIDTH; j++)
				{
					inputMatrix[i][j] = sc.nextDouble();
				}
					
			}
			
			for(int i = 0; i < numOfCandy; i++)
			{
				for(int j = 0; j < WIDTH; j++)
				{
					System.out.print(inputMatrix[i][j] + " ");
				}
				System.out.println();
					
			}
			
			inputCase++;
			
			// Take in the next line
			numOfCandy = sc.nextInt();
			totalCash = sc.nextDouble();
			
			if(numOfCandy == 0 && totalCash == 0)
				break;
		}
		
		
		
	}
	
	public static void main(String[] args) {

		try {
			load();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
