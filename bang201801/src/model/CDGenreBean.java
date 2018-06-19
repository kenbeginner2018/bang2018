package model;

import java.io.Serializable;

public class CDGenreBean implements Serializable {

	private int cdGenreId;
	private String cdGenreName;
	public int getCdGenreId() {
		return cdGenreId;
	}
	public void setCdGenreId(int cdGenreId) {
		this.cdGenreId = cdGenreId;
	}
	public String getCdGenreName() {
		return cdGenreName;
	}
	public void setCdGenreName(String cdGenreName) {
		this.cdGenreName = cdGenreName;
	}

}
