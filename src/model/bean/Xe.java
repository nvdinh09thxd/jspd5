package model.bean;

public class Xe {
	private int id;
	private String name;
	private int sort;

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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Xe() {
		
	}

	public Xe(int id, String name, int sort) {
		super();
		this.id = id;
		this.name = name;
		this.sort = sort;
	}

}
