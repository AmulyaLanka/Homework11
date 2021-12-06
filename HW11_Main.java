/*
 * Amulya Lanka
 * Homework 11
 * This program prompts the user to choose an option from the menu displayed and then performs the serialization process
 * 
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class HW11_Main {
	
	// declaring some private attributes, arraylist and IOstreams
	private static String selection, name, phoneNumber, dateOfBirth, emailID;
	private static Scanner input = new Scanner(System.in);
	private static ObjectOutputStream objOut;
	private static ObjectInputStream objIn;
	private static ArrayList<Person> persons = new ArrayList<>();
	

	//main class
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//menu
		Scanner kb = new Scanner(System.in);
		System.out.println( "========MENU=========" );
		System.out.println( "1. Add information to the file" );
		System.out.println( "2. Retrieve information from the file" );
		System.out.println( "3. Delete Information" );
		System.out.println( "4. Exit" );

		int selection = kb.nextInt();
		
		switch(selection) {
		
		case 1:
			addInfo();
			break;
		case 2:
			retrieveInfo();
			break;
		case 3:
			deleteInfo();
			break;
		
		case 4:
			System.out.println("Thank you!");
			break;
		}
		

	}
	
	//write to the file
	public static void writeToFile() throws IOException{
		objOut = new ObjectOutputStream(new FileOutputStream("Person.bin"));
		for (Person people : persons)
		objOut.writeObject(people);	
	}
	
	//read to the file
	public static ArrayList<Person> readFile()  {
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person("Maximus Ray", "888-2323-2333", "2-3-2002", "maxr@gmail.com"));
 
        try
        {
            FileOutputStream fileOut = new FileOutputStream("Person.bin");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(persons);
            objOut.close();
            fileOut.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
		return persons;
		
		
	}
	
	// option 1 menu -- lets the user add info to the binary file
	public static void addInfo() throws IOException {
		Scanner kb = new Scanner(System.in);
		System.out.println( "Enter your name: " );
		String nameOfUser = kb.nextLine();
		
		System.out.println( "Enter your phone number?: " );
		String phoneOfUser = kb.nextLine();
		
		System.out.println( "Enter your Date of Birth: " );
		String DOBofUser = kb.nextLine();
		
		System.out.println( "Enter your email id: " );
		String emailOfuser = kb.nextLine();
		
		// add person to collection
		persons.add(new Person(name, phoneOfUser, DOBofUser, emailOfuser));
		writeToFile();
	}
	
	
	// retrieve the info
	public static void retrieveInfo() throws ClassNotFoundException, IOException {

		if (!persons.isEmpty()) {
			objIn = new ObjectInputStream(new FileInputStream("Person.bin"));
			
			// print
			System.out.println();
			for (int i = 0; i < persons.size(); i++) {
				Person p = (Person) objIn.readObject();
				System.out.println(p);
			}
		}
		else
			System.out.println("No data found. Please try again by selecting option 1 from the menu to add data.");	
    }
	
	
	public static void deleteInfo() throws IOException {
		if (!persons.isEmpty()) {
			System.out.print("Enter name: ");

			// delete the person
			for (Person p : persons) {
				if (p.getPhoneNumber().equals(input.nextLine())) {
					System.out.println("Data deleted" + p);
					persons.remove(p);
				}
			}
						
			writeToFile();
		}
		
		else
			System.out.println("\nError: empty records");
		
		
	}
}
