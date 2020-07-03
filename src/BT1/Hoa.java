package BT1;

public class Hoa {
	private int id;
	private String tenHoa;
	private float giaBan;
	private int soLuong;

	public Hoa(int id, String tenHoa, float giaBan, int soLuong) {
		super();
		this.id = id;
		this.tenHoa = tenHoa;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenHoa() {
		return tenHoa;
	}

	public void setTenHoa(String tenHoa) {
		this.tenHoa = tenHoa;
	}

	public float getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Hoa() {
		super();
	}
}
