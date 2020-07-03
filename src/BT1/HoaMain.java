package BT1;

import java.util.ArrayList;
import java.util.Scanner;

import exception.NumberException;

public class HoaMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Hoa> listHoa = new ArrayList<Hoa>();
		boolean check = true;
		do {
			int chon = HoaAction.menu();
			switch (chon) {
			case 1:
				boolean check1 = true;
				int n = 0;
				do {
					try {
						System.out.print("Nhập số lượng hoa: ");
						n = Integer.parseInt(sc.nextLine());
						if (n <= 0)
							throw new NumberException("Phai nhap so luong hoa lon hon 0!");
						check1 = false;
					} catch (NumberFormatException e) {
						System.out.println("Nhap sai dinh dang so!");
					} catch (NumberException e) {
						System.out.println(e.getMessage());
					}
				} while (check1);
				System.out.println("===================NHẬP DANH SÁCH HOA===================");
				HoaAction.inputData(listHoa, n);
				break;
			case 2:
				if (listHoa.size() == 0) {
					System.out.println("Danh sách trống!");
				} else {
					System.out.println("===================DANH SÁCH HOA===================");
					HoaAction.display(listHoa);
				}
				break;
			case 3:
				ArrayList<Hoa> listHoa10 = HoaAction.soLuong10(listHoa);
				if (listHoa10.size() == 0) {
					System.out.println("Danh sách trống!");
				} else {
					System.out.println("===================DANH SÁCH HOA CÓ SỐ LƯỢNG LỚN HƠN 10===================");
					HoaAction.display(listHoa10);
				}
				break;
			case 4:
				ArrayList<Hoa> listHoaGia10 = HoaAction.Gia10(listHoa);
				if (listHoaGia10.size() == 0) {
					System.out.println("Danh sách trống!");
				} else {
					System.out.println("===================DANH SÁCH HOA CÓ GIÁ BÉ HƠN 10.000===================");
					HoaAction.display(listHoaGia10);
				}
				break;
			case 5:
				chon = 5;
				System.out.println("Thoát khỏi chương trình!");
				check = false;
				break;
			default:
				System.out.println("Nhap sai lua chon, xin moi nhap lai!");
			}
		} while (check);
	}
}
