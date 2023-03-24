package BT1;

import java.util.ArrayList;

public class HoaMain {

	public static void main(String[] args) {
		ArrayList<Hoa> listHoa = new ArrayList<>();
		boolean check = true;
		do {
			int chon = HoaAction.menu();
			switch (chon) {
			case 1:
				HoaAction.inputData(listHoa);
				break;
			case 2:
				HoaAction.display(listHoa, "DANH SÁCH HOA ĐÃ NHẬP");
				break;
			case 3:
				ArrayList<Hoa> listHoaSoLuongLonHon10 = HoaAction.soLuongLonHon10(listHoa);
				HoaAction.display(listHoaSoLuongLonHon10, "DANH SÁCH HOA CÓ SỐ LƯỢNG LỚN HƠN 10");
				break;
			case 4:
				ArrayList<Hoa> listHoaGiaBeHon10000 = HoaAction.GiaBeHon10000(listHoa);
				HoaAction.display(listHoaGiaBeHon10000, "DANH SÁCH HOA CÓ GIÁ BÉ HƠN 10.000");
				break;
			case 5:
				chon = 5;
				System.out.println("Thoát khỏi chương trình!");
				check = false;
				break;
			}
		} while (check);
	}
}
