package pl.chemik77.anagram;

import java.util.Scanner;

public class Anagram {
	static int size;
	static char[] arrChar = new char[100];
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter word: ");
		String line = input.nextLine();
		size = line.length();
		
		setarrChar(line);
		perm(size);
		
		input.close();
	}


	private static void perm(int k) {
		if(k == 1)
			return;
		
		for(int i=0; i<k; i++) {
			perm(k-1);
			if(k == 2)
				display();
			rotate(k);
		}
	}


	private static void rotate(int k) {
		int j;
		int position = size - k;
		char temp = arrChar[position];
		for(j=position+1; j<size; j++) 
			arrChar[j-1] = arrChar[j];
		arrChar[j-1] = temp;
			
	}


	private static void display() {
		for(int i=0; i<size; i++)
			System.out.print(arrChar[i]);
		System.out.println("");
	}


	private static void setarrChar(String line) {
		for(int i=0; i<size; i++) {
			arrChar[i] = line.charAt(i);
		}
	}
}
