package model;

import java.io.Serializable;

public class DVDGenreBean implements Serializable {

	private int dvdGenreId;
	private String dvdGenreName;


	public int getDvdGenreId() {
		return dvdGenreId;
	}
	public void setDvdGenreId(int dvdGenreId) {
		this.dvdGenreId = dvdGenreId;
	}
	public String getDvdGenreName() {
		return dvdGenreName;
	}
	public void setDvdGenreName(String dvdGenreName) {
		this.dvdGenreName = dvdGenreName;
	}

}
