package com.sg.dvdlibrary.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

	@Override
	public String readString(String prompt) {
		System.out.println(prompt);
        Scanner inputReader;
        String input;
        
        inputReader = new Scanner(System.in);
        
        input = inputReader.nextLine();
        return input;
	}

	@Override
	public double readDouble(String prompt) {
		System.out.println(prompt);
        Scanner inputReader;
        Double input;
        
        inputReader = new Scanner(System.in);
        
        input = inputReader.nextDouble();
        return input;
	}
	
	@Override
	public void printDouble(Double message) {
		String formattedString = String.format("%.02f", message);
		System.out.println(formattedString);		
	}

	@Override
	public void print(String message) {
		System.out.println(message);
	}

    @Override
    public int readInt(String prompt, int min, int max) {
        Scanner inputReader;
        int input;
        do {
            inputReader = new Scanner(System.in);
            input = inputReader.nextInt();
        } while (input < min || input > max);

        return input;
    }


}
