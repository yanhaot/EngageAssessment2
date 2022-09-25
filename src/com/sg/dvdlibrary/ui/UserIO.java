package com.sg.dvdlibrary.ui;

public interface UserIO {
	
    void print(String message);
    
    void printDouble(Double message);
    
    String readString(String prompt);
    
    double readDouble(String prompt);
    
    int readInt(String prompt, int min, int max);
}
