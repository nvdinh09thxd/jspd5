package BT1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.NumberException;

public class HoaAction {
	public static void line() {
		System.out.println("-------------------------");
	}

	static Scanner sc = new Scanner(System.in);

	public static void inputData(List<Hoa> listHoa, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin hoa thứ " + (i + 1) + ":");
			Hoa hoa = new Hoa();
			System.out.print("ID hoa: ");
			hoa.setId(Integer.parseInt(sc.nextLine()));
			System.out.print("Tên hoa: ");
			hoa.setTenHoa(sc.nextLine());
			boolean checkSL = true;
			do {
				try {
					System.out.print("Số lượng: ");
					int soluong = Integer.parseInt(sc.nextLine());
					if (soluong <= 0)
						throw new NumberException("Số lượng phải lớn hơn 0!");
					hoa.setSoLuong(soluong);
					checkSL = false;
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				} catch (NumberFormatException e) {
					System.out.println("Nhap sai dinh dang so!");
				}
			} while (checkSL);
			boolean checkGia = true;
			do {
				try {
					System.out.print("Giá bán: ");
					int gia = Integer.parseInt(sc.nextLine());
					if (gia <= 0)
						throw new NumberException("Giá phải lớn hơn 0!");
					hoa.setGiaBan(gia);
					checkGia = false;
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				} catch (NumberFormatException e) {
					System.out.println("Nhap sai dinh dang so!");
				}
			} while (checkGia);
			line();
			listHoa.add(hoa);
		}
	}

	public static void display(List<Hoa> listHoa) {
		for (Hoa hoa : listHoa) {
			System.out.println("ID: " + hoa.getId());
			System.out.println("Tên hoa: " + hoa.getTenHoa());
			System.out.println("Số lượng: " + hoa.getSoLuong());
			System.out.println("Giá: " + hoa.getGiaBan());
			line();
		}
	}
	
	public static ArrayList<Hoa> soLuong10(ArrayList<Hoa> listHoa) {
		ArrayList<Hoa> listHoa10 = new ArrayList<>();
		for (Hoa hoa : listHoa) {
			if (hoa.getSoLuong() > 10) {
				listHoa10.add(hoa);
			}
		}
		return listHoa10;
	}
	
	public static ArrayList<Hoa> Gia10(ArrayList<Hoa> listHoa) {
		ArrayList<Hoa> listHoa10 = new ArrayList<>();
		for (Hoa hoa : listHoa) {
			if (hoa.getGiaBan() < 10000) {
				listHoa10.add(hoa);
			}
		}
		return listHoa10;
	}

	public static int menu() {
		System.out.println("================== M E N U ====================");
		System.out.println("1. Nhap du lieu");
		System.out.println("2. Xuat du lieu");
		System.out.println("3. Danh sách hoa có số lượng lớn hơn 10");
		System.out.println("4. Danh sách hoa có giá bé hơn 10.000");
		System.out.println("5. Thoát");
		System.out.println("======================================");
		int chon = 0;
		boolean check = true;
		do {
			try {
				System.out.print("Nhap thao tac lua chon: ");
				chon = Integer.valueOf(sc.nextLine());
				check = false;
			} catch (NumberFormatException e) {
				System.out.println("Nhap sai dinh dang so!");
			}
		} while (check);
		return chon;
	}
}
