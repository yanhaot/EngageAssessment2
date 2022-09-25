package com.sg.dvdlibrary.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sg.dvdlibrary.dto.Dvd;

public class classDVDLibraryFileImpl implements classDVDLibraryDao{

	public static final String LIBRARY_FILE = "library.txt";
	private Map<String, Dvd> library = new HashMap<>();	
  
	@Override
	public void addDvd(Dvd dvd) {
		load();
	    String title;    
	    title = dvd.getTitle();
	    
	    Dvd newDvd = library.put(title, dvd);
	    save();
	}

	@Override
	public Dvd removeDvd(String name) {
		load();
        Dvd removeDvd = library.remove(name);
        save();
        return removeDvd;
	}

	@Override
	public Dvd getDvd(String name) {
		load();
	    return library.get(name);
	}

	@Override
	public void load() {
		  Scanner scanner;
	      library.clear();
	        
	        // Attempt to open the file
	        try {
	            scanner = new Scanner(
	                new BufferedReader(
	                    new FileReader(LIBRARY_FILE)
	                )
	            );
	        } catch (Exception ex) {
	            System.out.println("Failed to CANNOT OPEN file");
	            return;
	        }
	        
	        // Runs through line by line in the file to unmarshal and maps to the DVD
	        while (scanner.hasNextLine()) {
	            String data;
	            Dvd dvd;
	            
	            data = scanner.nextLine();
	            if (data.equals("")) {
	                break;
	            }
	            
	            dvd = unmarshal(data);
	            
	            library.put(dvd.getTitle(), dvd);
	        }	
	 }

	@Override
	public void save() {
		  Collection<Dvd> dvds;
	        PrintWriter writer = null;
	        
	        // Will try to open the file (File is already created)
	        // File MUST exist first for his to work
	        // library.txt has been created in repository for this assessment
	        try {
	            writer = new PrintWriter(
	                new FileWriter(LIBRARY_FILE)
	            );
	        } catch (Exception ex) {
	            System.out.println("Failed to write to file");
	        }
	        
	        dvds = library.values();
	        for (Dvd value: dvds) {
	            Dvd dvd;
	            String data;
	            
	            dvd = (Dvd) value;
	            data = marshal(dvd);
	            
	            writer.println(data);
	        }
	        writer.close();	
	}

	// Unpacks string into a Dvd object
	// returns an object of Dvd
	private Dvd unmarshal(String data) {
        String[] values;
        Dvd dvd;
        
        values = data.split("::");
            dvd = new Dvd(
            		values[0], 
            		values[1], 
            		values[2],
            		values[3],
            		values[4], 
            		Float.parseFloat(values[5]));
        return dvd;
    }
    
	// Packing all the Dvd object into a String
	// returns a string of Dvd
    private String marshal(Dvd dvd) {
        String data;
        
        data = String.format("%s::%s::%s::%s::%s::%f",
            dvd.getTitle(),
            dvd.getRelease(),
            dvd.getDirector(),
            dvd.getStudio(),
            dvd.getNote(),
            (float) dvd.getRating()
        );
        
        return data;
    }

	@Override
	public List<Dvd> getAllDvd() {
		load();
	    return new ArrayList<Dvd>(library.values());
	}

	@Override
	public Dvd editTitle(String title, String newTitle) {
		load();
		Dvd selectedDvd = library.get(title);
		selectedDvd.setTitle(newTitle);
		save();
		return selectedDvd;
	}

	@Override
	public Dvd editDirector(String title, String newDirectorName) {
		load();
		Dvd selectedDvd = library.get(title);
		selectedDvd.setDirector(newDirectorName);
		save();
		return selectedDvd;
	}

	@Override
	public Dvd editRelease(String title, String newReleaseDate) {
		load();
		Dvd selectedDvd = library.get(title);
		selectedDvd.setDirector(newReleaseDate);
		save();
		return selectedDvd;
	}

	@Override
	public Dvd editStudio(String title, String newStudio) {
		load();
		Dvd selectedDvd = library.get(title);
		selectedDvd.setDirector(newStudio);
		save();
		return selectedDvd;
	}

	@Override
	public Dvd editNote(String title, String newNote) {
		load();
		Dvd selectedDvd = library.get(title);
		selectedDvd.setDirector(newNote);
		save();
		return selectedDvd;
	}

	@Override
	public Dvd editRating(String title, String newRating) {
		load();
		Dvd selectedDvd = library.get(title);
		selectedDvd.setRating(Double.parseDouble(newRating));
		save();
		return selectedDvd;
	}


}
