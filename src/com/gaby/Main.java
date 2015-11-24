/*The coffee shop sells 12 different drinks. The name of each drink, the price the shop charges the customer, 
and how much it costs to make each drink, are shown in the file coffee.txt. 
The data is in the format name;cost to make;price charged
example
cappuccino;1.56;3.50
Your program should read this data from coffee.txt, and store it in some kind of data structure.
Your program should ask the user how many of each drink were sold today. 
So, it might ask "How many cappuccino drinks were sold today?" and the user can type in a number. 
It will need to ask for each drink individually. You'll need to store this data somehow.
You should add input validation so that if the user enters "ten" or "10.4" or -45 then your program will respond appropriately.  
You should also deal with any file-related exceptions properly. 
Once you have gathered all the data, generate a report that will be written out to a new file called sales-report.txt. 
For each drink, record the number of drinks sold, the total that it cost to make those drinks (expenses), 
and the total amount (revenue) spent by customers on that drink. So, for example, 
if the coffee shop sold 10 cappuccinos today, you'll write a line that says
Cappuccino: Sold 10, Expenses $15.60, Revenue $35.00, Profit $19.40
And a similar line for each of the drinks, with the correct data.
At the bottom of the file, write the total expenses, total revenue, and total profit for all drinks.
*/

package com.gaby;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//create drink objects for every kind of drink
static Drink cappuccino;
static Drink espresso;
static Drink latte;
static Drink blackTea;
static Drink herbalTea;
static Drink macchiato;
static Drink americano;
static Drink coldPress;
static Drink hotChocolate;
static Drink coffee;
static Drink chaiTea;
static Drink mocha;

private static File drinkListFile;
private static ArrayList<Drink> drinkList;

public static void main(String[] args) throws IOException{

//read coffee file into drinkList...
	FileReader reader = new FileReader();
	drinkListFile = new File("C:/workspace/CoffeeShop/src/com/gaby/coffee.txt");
	try {
	//..with generateDrinks method
	drinkList = reader.generateDrinks(drinkListFile);
	}
	catch(Exception ex) {
		throw ex;
	}
	
	//Query user for sales info, with input validation, use setters to add to Drinks
	//new report object, loop through the list to query user for sales info (input validation in method)
	Report report = new Report();
	for(int i = 0; i < drinkList.size(); i++) {
		report.queryUserForTotals(drinkList.get(i));
	}
	System.out.println("I've got all the data, next to generate a report of the total sales.");
	
//generate sales report for each Drink and write to sales-report.txt
	report.makeReport(drinkList);
	System.exit(0);

	
	

}
}