package pl.chemik77.anagram;

import java.util.ArrayList;
import java.util.Scanner;

public class Anagram {
	static int size;
	static char[] arrChar = new char[20];
	static ArrayList<String> list= new ArrayList<>();
	static int count = 0;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter word: ");
		String line = input.nextLine();
		size = line.length();
		
		setarrChar(line);
		perm(size);
		
		display();
		
		input.close();
	}


	private static void perm(int k) {
		if(k == 1)
			return;
		
		for(int i=0; i<k; i++) {
			perm(k-1);
			if(k == 2)
				addToList();
			rotate(k);
		}
	}


	private static void addToList() {
		String word = new String(arrChar);
		if(!list.contains(word))
			list.add(word);
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
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i) + "\n");
		System.out.println("");
	}


	private static void setarrChar(String line) {
		for(int i=0; i<size; i++) {
			arrChar[i] = line.charAt(i);
		}
	}
}
