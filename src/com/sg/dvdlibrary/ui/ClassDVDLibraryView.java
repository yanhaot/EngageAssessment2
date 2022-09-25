package com.sg.dvdlibrary.ui;

import java.util.List;

import com.sg.dvdlibrary.dto.Dvd;

public class ClassDVDLibraryView {
	   private UserIO io;
	   
	   public ClassDVDLibraryView(UserIO io) {
		    this.io = io;
		}
	   
	    public int printMenuAndGetSelection() {
            io.print("1. Edit Title");
            io.print("2. Edit Release Date");
            io.print("3. Edit Director Name");
            io.print("4. Edit Studio Name");
            io.print("5. Edit Rating");
            io.print("6. Edit Notes");
            io.print("7. Exit");

	        return io.readInt("Please select from the above choices.", 1, 7);
	    }
	    
	    public Dvd getNewDvdInfo() {
	        String dvdTitle = io.readString("Please enter DVD Title:");
	        String dvdRelease = io.readString("Please enter DVD Release Date:");
	        String dvdDirector = io.readString("Please enter the name of Director:");
	        String dvdStudio = io.readString("Please enter Studio name:");
	        Double dvdRating = io.readDouble("Please enter DVD rating:");
	        String dvdNote = io.readString("Please enter DVD notes:");
	        Dvd currentDvd = new Dvd(dvdTitle,dvdRelease, dvdDirector, dvdStudio, dvdNote, dvdRating);
	        currentDvd.setTitle(dvdTitle);
	        currentDvd.setRelease(dvdRelease);
	        currentDvd.setDirector(dvdDirector);
	        currentDvd.setStudio(dvdStudio);
	        currentDvd.setNote(dvdNote);
	        currentDvd.setRating(dvdRating);
	        return currentDvd;
	    }
	    
	    public void displayDvdList(List<Dvd> library) {
	        for (Dvd currentDvd : library) {
	            String dvdInfo = String.format("#%s : %s, %s, %s, %s, %.2f",
	            		currentDvd.getTitle(),
	            		currentDvd.getRelease(),
	            		currentDvd.getDirector(),
	            		currentDvd.getStudio(),
	            		currentDvd.getNote(),
	            		currentDvd.getRating()
	            		);
	            io.print(dvdInfo);
	        }
	        io.readString("Please hit enter to continue.");
	    }
	    
	    public void displayDvd(Dvd dvd) {
	        if (dvd != null) {
	            io.print(dvd.getTitle());
	            io.print(dvd.getRelease());
	            io.print(dvd.getDirector());
	            io.print(dvd.getStudio());
	            io.print(dvd.getNote());
	            io.printDouble(dvd.getRating());
	            io.print("");
	        } else {
	            io.print("No such DVD exist.");
	        }
	        io.readString("Please hit enter to continue.");
	    }
	    
	    public void displayRemoveResult(Dvd dvdRecord) {
	        if(dvdRecord != null){
	          io.print("DVD successfully removed.");
	        }else{
	          io.print("No such DVD.");
	        }
	        io.readString("Please hit enter to continue.");
	    }
	    
	    public void displayCreateDvdBanner() {
	        io.print("=== Create Dvd ===");
	    }
	    
	    public void displayCreateSuccessBanner() {
	        io.readString("Dvd successfully created. Please hit enter to continue");
	    }
	    
	    public void displayEditDvdBanner() {
	        io.print("=== Edit Dvd ===");
	    }
	    
	    public void displayEditSuccessBanner() {
	        io.readString("Dvd successfully edited. Please hit enter to continue");
	    }
	    
	    public void displayDisplayAllBanner() {
	        io.print("=== Display All DVD ===");
	    }
	    
	    public void displayDisplayDvdBanner () {
	        io.print("=== Display DVD ===");
	    }

	    public String getDvdTitleChoice() {
	        return io.readString("Please enter the DVD Title.");
	    }
	    
	    public void displayRemoveDvdBanner () {
	        io.print("=== Remove Student ===");
	    }
	    
	    public void displayExitBanner() {
	        io.print("Good Bye!!!");
	    }

	    public void displayUnknownCommandBanner() {
	        io.print("Unknown Command!!!");
	    }
}
