package com.sg.dvdlibrary.dao;

import java.util.List;

import com.sg.dvdlibrary.dto.Dvd;

public interface classDVDLibraryDao {

    void addDvd(Dvd dvd);
    
    Dvd removeDvd(String name);
    
    Dvd getDvd(String name);
        
    List<Dvd>getAllDvd();
    
    Dvd editTitle(String title, String newTitle);
    
    Dvd editDirector(String title, String newDirectorName);
    
    Dvd editRelease(String title, String newReleaseDate);
    
    Dvd editStudio(String title, String newStudio);
    
    Dvd editNote(String title, String newNote);
    
    Dvd editRating(String title, String newRating);
        
    void load();
    
    void save();
    
}
