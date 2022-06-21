package javaBasics2;

import java.util.Iterator;
import java.util.Scanner;

public class Arrays {

	// Array - Allocates memory in consecutive locations
	
	/**
	 * 
	 * Declaration: 
	 * ================
	 * dataType[] arrayName;
	 * 
	 * we need to mentioned the SIZE
	 * 
	 * dataType[] arrayName = new dataType[SIZE];
	 * 
	 * 
	 * Index starts from "0" always
	 * 
	 * consider 2000 is base address, then to access value are 2nd index
	 * 
	 * arrayName[2] => internal calculation 
	 * => 2000 + (4 * 2) = 2008
	 * => baseAddress + (size occupied by data type * index)
	 */
	public static void main(String[] args) {
		// new keyword is for memory allocation
		int[] ageList = new int[5];
		
		ageList[0] = 23;
		ageList[1] = 12;
		ageList[2] = 23;
		ageList[3] = 12;
		ageList[4] = 23;
		// ageList[5] = 12; Exception java.lang.ArrayIndexOutOfBoundsException
		
		int[] studentAges = new int[5];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 5 student ages: ");
		for (int i = 0; i < 5; i++) {
			studentAges[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Age of roll no " + (i + 1) + " is " + studentAges[i]);
		}
		
		for (int age : studentAges) {
			System.out.println("Age is " + age);
		}
	}

}
