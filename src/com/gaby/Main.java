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