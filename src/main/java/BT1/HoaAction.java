package BT1;

import java.util.ArrayList;
import java.util.Scanner;

import exception.NumberException;

public class HoaAction {
	public static void line() {
		System.out.println("-------------------------");
	}

	static Scanner sc = new Scanner(System.in);

	public static int nhapSoDuong(String msg, String err) {
		int n = 0;
		boolean check = true;
		do {
			try {
				System.out.print(msg);
				n = Integer.parseInt(sc.nextLine());
				if (n <= 0)
					throw new NumberException(err);
				check = false;
			} catch (NumberException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Vui long nhap dung dinh dang so!");
			}
		} while (check);
		return n;
	}

	public static void inputData(ArrayList<Hoa> listHoa) {
		System.out.println("NHẬP DANH SÁCH HOA");
		int n = nhapSoDuong("Nhập số lượng phần tử: ", "Vui lòng nhập số lượng phần tử lớn hơn 0!");
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin phần tử thứ " + (i + 1) + ":");
			int id = nhapSoDuong("Nhập id: ", "Vui lòng nhập id hoa là số dương!");
			System.out.print("Tên hoa: ");
			String name = sc.nextLine();
			int soLuong = nhapSoDuong("Nhập số lượng: ", "Vui lòng nhập số lượng hoa lớn hơn 0!");

			boolean check = true;
			float gia = 0;
			do {
				try {
					System.out.print("Giá bán: ");
					gia = Float.parseFloat(sc.nextLine());
					if (gia <= 0)
						throw new NumberException("Giá phải lớn hơn 0!");
					check = false;
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				} catch (NumberFormatException e) {
					System.out.println("Nhap sai dinh dang so!");
				}
			} while (check);
			Hoa itemHoa = new Hoa(id, name, gia, soLuong);
			listHoa.add(itemHoa);
		}
	}

	public static void display(ArrayList<Hoa> listHoa, String msg) {
		if (listHoa.size() == 0) {
			System.out.println("Danh sách trống!");
		} else {
			System.out.println(msg);
			for (Hoa hoa : listHoa) {
				System.out.println("ID: " + hoa.getId());
				System.out.println("Tên hoa: " + hoa.getTenHoa());
				System.out.println("Số lượng: " + hoa.getSoLuong());
				System.out.println("Giá: " + hoa.getGiaBan());
				line();
			}
		}
	}

	public static ArrayList<Hoa> soLuongLonHon10(ArrayList<Hoa> listHoa) {
		ArrayList<Hoa> result = new ArrayList<>();
		for (Hoa hoa : listHoa) {
			if (hoa.getSoLuong() > 10) {
				result.add(hoa);
			}
		}
		return result;
	}

	public static ArrayList<Hoa> GiaBeHon10000(ArrayList<Hoa> listHoa) {
		ArrayList<Hoa> result = new ArrayList<>();
		for (Hoa hoa : listHoa) {
			if (hoa.getGiaBan() < 10000) {
				result.add(hoa);
			}
		}
		return result;
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
				chon = Integer.parseInt(sc.nextLine());
				if (chon < 1 || chon > 5)
					throw new NumberException("Vui lòng nhập lựa chọn từ 1 đến 5!");
				check = false;
			} catch (NumberFormatException e) {
				System.out.println("Nhap sai dinh dang so!");
			} catch (NumberException e) {
				System.out.println(e.getMessage());
			}
		} while (check);
		return chon;
	}
}
