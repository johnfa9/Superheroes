package com.ga.superhero;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String name;
		String name2;
		String file;
		int win=0;
		int loss=0;
		System.out.println("Enter your name");

		//read input from keyboard
		Scanner keyboard = new Scanner(System.in);
		name=keyboard.nextLine();

		List<Superhero> character = new ArrayList<Superhero>();
		BufferedReader readFile = null;
		String fileName="/Users/johnsfiles/10_1_19/foundational-java/java-basics/exception-handling-lesson/starter-code/Superheroes/input.txt";
		try {
			readFile = new BufferedReader(new FileReader(fileName));
			while (readFile.ready()) {
				Superhero hero = new Superhero();

				String currentLine = readFile.readLine();
				hero.name = currentLine;
				currentLine = readFile.readLine();
				hero.sex = currentLine;
				character.add(hero);
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

		for (Superhero element:character){
			System.out.println("Enter the sex of "+ element.name);
			name2=keyboard.nextLine();
			if (element.sex.equals(name2)) {
				win += 1;
			}
			else
				loss+=1;
		}
		String outcome;
		if (win>=2)
			outcome=name+ " You won";
		else
			outcome=name+ " You lost";

		try {
			FileWriter file2;
			file2=new FileWriter("/Users/johnsfiles/10_1_19/foundational-java/java-basics/exception-handling-lesson/starter-code/Superheroes/output.txt");
			BufferedWriter fileWrite=new BufferedWriter(file2);
			fileWrite.write(outcome);
			fileWrite.close(); //clear the buffer

			}
			catch (IOException e){
				System.out.println(e.getMessage());
			}

}}
