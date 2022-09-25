package com.sg.dvdlibrary.dto;

public class Dvd {
	
    private String title;
    private String release;
    private String director;
    private String studio; 
    private String note;
    private double rating;
    
    public Dvd(String title, String release, String director, String studio, String note, double rating) {
    	this.title = title;
    	this.release = release;
    	this.director = director;
    	this.studio = studio;
    	this.note = note;
    	this.rating = rating;
    }
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Dvd [title=" + title + ", release=" + release + ", director=" + director + ", studio=" + studio
				+ ", note=" + note + ", rating=" + rating + "]";
	}

}
