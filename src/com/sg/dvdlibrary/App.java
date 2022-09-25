package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.ClassDVDLibraryController;
import com.sg.dvdlibrary.dao.classDVDLibraryDao;
import com.sg.dvdlibrary.dao.classDVDLibraryFileImpl;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.ClassDVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

public class App {
	
	public static void main(String[] args) {
		 UserIO myIo = new UserIOConsoleImpl();
		 ClassDVDLibraryView myView = new ClassDVDLibraryView(myIo);
		 classDVDLibraryFileImpl myDao = new classDVDLibraryFileImpl();
		 ClassDVDLibraryController controller = new ClassDVDLibraryController(myDao, myView);
	     controller.run();
	}

}
