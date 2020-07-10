package bean;

public class TheSong {
	private int id;
	private String name;
	private String picture;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public TheSong(int id, String name, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.picture = picture;
	}

	public TheSong() {
		super();
	}

}
