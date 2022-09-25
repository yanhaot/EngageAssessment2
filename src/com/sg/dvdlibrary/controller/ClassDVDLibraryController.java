package com.sg.dvdlibrary.controller;

import java.util.List;

import com.sg.dvdlibrary.dao.classDVDLibraryDao;
import com.sg.dvdlibrary.dao.classDVDLibraryFileImpl;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.ClassDVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

public class ClassDVDLibraryController {
	
	private ClassDVDLibraryView view;
	private classDVDLibraryDao dao;

    private UserIO io = new UserIOConsoleImpl();

    public ClassDVDLibraryController(classDVDLibraryDao dao, ClassDVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        do {
        	 io.print("=== Main Menu ===");
             io.print("1. Add a DVD");
             io.print("2. Remove a DVD");
             io.print("3. View a DVD");
             io.print("4. List all DVD");
             io.print("5. Edit a DVD");
             io.print("6. Exit");

             menuSelection = io.readInt("Please select from the"
                     + " above choices.", 1, 6);

             switch (menuSelection) {
                 case 1:
                 	createDvd();
                     break;
                 case 2:
                 	removeDvd();
                     break;
                 case 3:
                 	viewDvd();
                     break;
                 case 4:
                 	listDvd();
                     break;
                 case 5:
                	 editDvdInfo();
                     break;
                 case 6:
                     keepGoing = false;
                     break;
                 default:
                     unknownCommand();
             }

        } while(keepGoing);
        exitMessage();
    }
    
    public void editDvdInfo() {
	    view.displayEditDvdBanner();
	    String dvdTitle = view.getDvdTitleChoice();
	    Dvd dvd = dao.getDvd(dvdTitle);
	    
        if (dvd != null) {
    	    int choice = view.printMenuAndGetSelection();
        	 switch (choice) {
 	        case 1:
 	        	editTitleOption(dvdTitle);
 	            break;
 	        case 2:
 	        	editReleaseOption(dvdTitle);
 		        break;
 	        case 3:
 	        	editDirectorNameOption(dvdTitle);
 		        break;
 	        case 4:
 	        	editStudioOption(dvdTitle);
 	            break;
 	        case 5:
 	        	editRatingOption(dvdTitle);
 	            break;
 	        case 6:
 	        	editNotesOption(dvdTitle);
 		        break;
 	        default:
                unknownCommand();
 	            break;
 	        }
        } else {
            io.print("No such DVD exist.");
	        io.readString("Please hit enter to continue.");
        }
   }
    
	private void createDvd() {
	    view.displayCreateDvdBanner();
	    Dvd newDvd = view.getNewDvdInfo();
	    dao.addDvd(newDvd);
	    view.displayCreateSuccessBanner();
	}
	
	private void listDvd() {
	    view.displayDisplayAllBanner();
	    List<Dvd> dvdList = dao.getAllDvd();
	    view.displayDvdList(dvdList);
	}
	
	private void viewDvd() {
	    view.displayDisplayDvdBanner();
	    String dvdTitle = view.getDvdTitleChoice();
	    Dvd dvd = dao.getDvd(dvdTitle);
	    view.displayDvd(dvd);
	}
	
	private void removeDvd() {
	    view.displayRemoveDvdBanner();
	    String dvdTitle = view.getDvdTitleChoice();
	    Dvd removedDvd = dao.removeDvd(dvdTitle);
	    view.displayRemoveResult(removedDvd);
	}
	
    private void editTitleOption(String title){
	    String getDvdTitle = io.readString("Please enter new DVD Title:");
        Dvd editedDvd = dao.editTitle(title, getDvdTitle);
	    view.displayEditSuccessBanner();
    }
    
    private void editReleaseOption(String title) {
    	String dvdRelease = io.readString("Please enter new DVD Release Date:");
        Dvd editedDvd = dao.editRelease(title, dvdRelease);
	    view.displayEditSuccessBanner();
    }
    
    private void editDirectorNameOption(String title) {
    	String dvdDirector = io.readString("Please enter new Director Name:");
        Dvd editedDvd = dao.editDirector(title, dvdDirector);
	    view.displayEditSuccessBanner();
    }
    
    private void editStudioOption(String title)  {
    	String dvdStudio = io.readString("Please enter new Studio Name:");
        Dvd editedDvd = dao.editRating(title, dvdStudio);
	    view.displayEditSuccessBanner();
    }
    private void editRatingOption(String title) {
    	String dvdRating = io.readString("Please enter new Rating:");
        Dvd editedDvd = dao.editRating(title, dvdRating);
	    view.displayEditSuccessBanner();
    }
	
    private void editNotesOption(String title) {
    	String dvdNotes = io.readString("Please enter new Notes:");
        Dvd editedDvd = dao.editNote(title, dvdNotes);
	    view.displayEditSuccessBanner();
    }
    
	private void unknownCommand() {
	    view.displayUnknownCommandBanner();
	}

	private void exitMessage() {
        dao.save();
	    view.displayExitBanner();
	}
	
}
