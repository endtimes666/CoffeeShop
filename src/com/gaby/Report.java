package com.gaby;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Report {

	// sc4nn3r
	static Scanner scan = new Scanner(System.in);

	public void queryUserForTotals(Drink typeOfDrink) {
		// Query user for sales info, check if it's an integer, use setTotalSold
		// to add
		// data to Drink objects,
		System.out.println("How many " + typeOfDrink.getName()
				+ " drinks were sold today?");
		while (!scan.hasNextInt()) {
			System.out.println("That's not an integer!");
			scan.nextInt();

		}
		typeOfDrink.setTotalSold(scan.nextInt());
	}

	// takes arraylist, create variables for name, totalSold, cost, price
	// revenue and profit(totalSold*(price-cost)),
	// prints profit for each then total profit.
	public void makeReport(ArrayList drinklist) throws IOException {

		Drink drink = null;

		// new filewriter

		FileWriter writer = new FileWriter(
				"C:/Users/admin/Documents/sales-report.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(writer);

		// init totalRevenue and total expenses and totalProfit to 0
		float totalRevenue = 0;
		float totalCost = 0;
		float totalProfit = 0;

		// loop thru arraylist
		for (int index = 0; index < drinklist.size(); index++) {
			drink = (Drink) drinklist.get(index);
			String name = drink.getName();
			float price = drink.getPrice();
			float cost = drink.getCost();
			int totalSold = drink.getTotalSold();
			float drinkProfit = totalSold * (price - cost);
			float revenue = totalSold * price;
			totalRevenue += revenue;
			totalCost += cost;
			totalProfit += drinkProfit;

			bufferedWriter.write(totalSold+" "+name+" sold; Expenses $"+cost +"; Revenue $"+revenue+"; Profit $"+drinkProfit);
			bufferedWriter.newLine();


		}
		bufferedWriter.newLine();
		// total expenses, total revenue, and total profit
		bufferedWriter.write("Total expenses: $" + totalCost);
		bufferedWriter.newLine();
		bufferedWriter.write("Total revenue: $" + totalRevenue);
		bufferedWriter.newLine();
		bufferedWriter.write("Total profit: $" + totalProfit);

		bufferedWriter.close();
	}

}
