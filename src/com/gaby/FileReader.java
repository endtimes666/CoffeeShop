package com.gaby;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {
	
	private static final String delimiter = ";";

	//one arraylist for all drink data
	private ArrayList<Drink> drinkList = new ArrayList<Drink>();
	
	//convert file to fileinputstream, then to datainputstream, read it, and return arraylist of Drinks
	public ArrayList<Drink> generateDrinks(File drinkList) throws IOException {
		
		ArrayList<Drink> theListOfDrinks = new ArrayList<Drink>();
		//file
		FileInputStream fileStream = new FileInputStream(drinkList);
		DataInputStream dataStream = new DataInputStream(fileStream);
		BufferedReader reader = new BufferedReader(new InputStreamReader(dataStream));
		
		String fileLine;
		String[] lineData;
		//run while loop as long as file is readable
		boolean isFileReadable = drinkList.canRead();
		
		if (isFileReadable == true)
		{
			try {
				while(true)
				{
					fileLine = reader.readLine();
					if(fileLine == null)
						break;
					//splits data along semicolons
					lineData = fileLine.split(delimiter);
					Drink drink = new Drink(lineData[0], Float.parseFloat(lineData[1]), Float.parseFloat(lineData[2]), 0);
					theListOfDrinks.add(drink);
				}
				reader.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			return theListOfDrinks;
		}
		else
			reader.close();
			return null;
	}
}
