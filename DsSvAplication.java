package july_25th.btvn_8;

import java.util.Scanner;

public class DsSvAplication {
	
	public DsSvAplication() {
		// TODO Auto-generated constructor stub
	}
	static int StuListHyphenNum = 112;
	
	static void menuChuongTrinh() {
		System.out.print("-".repeat(StuListHyphenNum) + "\n"
				+ "\t\t\t\tMENU HUONG DAN\n"
				+ "-".repeat(StuListHyphenNum) + "\n"
				+ "[0]: in danh sach sinh vien\n"
				+ "[1]: nhap thong tin sinh vien moi vao danh sach\n"
				+ "[2]: tim sinh vien co diem TB cao nhat\n"
				+ "[3]: tim tat ca sinh vien yeu\n"
				+ "[4]: tim sinh vien theo ten\n"
				+ "[5]: tim sinh vien theo ma\n"
				+ "[6]: xoa sinh vien theo ma\n"
				+ "[7]: KET THUC CHUONG TRINH\n"
				+ "[8]: tu dong tao va them 5 sinh vien vao danh sach\n"
				+ "<default>: in lai menu huong dan\n"
				+ "-".repeat(StuListHyphenNum) + "\n");
		System.out.print( "---> moi ban nhap: ");
	}
	
	static void chayChuongTrinh() {
		DanhSachSinhVien ds = new DanhSachSinhVien();
		Scanner scan = new Scanner(System.in);
		
		int input;
		Boolean tiepTuc = true;
		
		do {
			menuChuongTrinh();
			input = Integer.parseInt(scan.nextLine());
			
			switch(input) {
				case 0:
//					"[0]: in danh sach sinh vien\n"
					ds.inDanhSachSinhVien();
					System.out.println("");
					break;
				case 1:
//					+ "[1]: nhap thong tin sinh vien moi vao danh sach\n"
					ds.themSV_nhap();
					System.out.println("");
					break;
				
				case 2:
//					+ "[2]: tim sinh vien co diem TB cao nhat\n"
					ds.timSinhVienDTBcaoNhat();
					System.out.println("");
					break;
				
				case 3:
//					+ "[3]: tim tat ca sinh vien yeu\n"
					ds.timSinhVienYeu();
					System.out.println("");
					break;
				
				case 4:
//					+ "[4]: tim sinh vien theo ten\n"
					ds.timSinhVienTheoTen();
					System.out.println("");
					break;
				
				case 5:
//					+ "[5]: tim sinh vien theo ma\n"
					ds.timSinhVienTheoMa();
					System.out.println("");
					break;
				case 6:
//					+ "[6]: xoa sinh vien theo ma\n"
					ds.xoaSinhVienTheoMa();
					System.out.println("");
					break;				
				case 7:
//					+ "[7]: KET THUC CHUONG TRINH\n"
					tiepTuc = false;
					System.out.println("CHUONG TRINH KET THUC!");
					break;
				case 8:
//					+ "auto generate student list"
					ds.autoGenerateStudentList(5);
					System.out.println("da them xong vao danh sach!");
					break;		
				default:
//					+ "<default>: tiep tuc\n"	
			}
		}
		while (tiepTuc);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chayChuongTrinh();
	}

}
