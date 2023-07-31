package july_25th.btvn_8;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class DanhSachSinhVien extends GiaoDien {
	List<SinhVien> ds;
	
	public DanhSachSinhVien() {
		// TODO Auto-generated constructor stub
		ds = new ArrayList<SinhVien>();
	}
	
	public void autoGenerateStudentList(int numOfStudents) {
		for(int i = 0; i < numOfStudents; i++) {
			SinhVien sv = new SinhVien();
			sv.autoGenerate();
			
			this.ds.add(sv);
		}
	}
	//nhap thong tin sinh vien
	public void themSV_nhap() {
		SinhVien sv = new SinhVien();
		sv.nhapThongTin();
		
		this.ds.add(sv);
	}
	
	// in danh sach sinh vien
 	public void inDanhSachSinhVien() {
		this.tableName("DANH SACH TAT CA SINH VIEN", 5);
		this.columnNameStudentList();
		
		for(int i = 0; i < ds.size(); i++) {
			ds.get(i).inThongTin(i + 1);
		}
		
		this.line(StuListHyphenNum);
	}
	
 	//tim sinh vien co diem TB CAO NHAT
 	public void timSinhVienDTBcaoNhat() {
 		SinhVien highestScore = this.ds.get(0);
 		
 		for(SinhVien sv : this.ds) {
 			if (sv.getDiemTB() > highestScore.getDiemTB()) {
 				highestScore = sv;
 			}
 		}
 		this.tableName("SINH VIEN CO DIEM TRUNG BINH CAO NHAT LA", 4);
		this.columnNameStudentList();
		highestScore.inThongTin(1);
		this.line(StuListHyphenNum);
 	}
 	
 	//tim tat ca sinh vien YEU
 	//Xếp loại từng sinh viên theo: >=9 -> Xuất Sắc, 9>Giỏi>=8, 8>Khá>=7, 7>Trung Binh-Kha>=6, 5>=Yếu
	public void timSinhVienYeu() {
		int i = 0;// ko co sinh vien yien
		this.tableName("DANH SACH SINH VIEN YEU", 5);
		this.columnNameStudentList();
		
		for(SinhVien sv : this.ds) {
			if(sv.getXepLoai().equalsIgnoreCase("yeu")) {
				sv.inThongTin(i+1);
				i++;
			}				
		}
		if(i == 0)// ko co sinh vien yeu
			System.out.println("KHONG co sinh vien Yeu!");
		this.line(StuListHyphenNum);
	}
	
	//tim sinh vien theo Ten
	public void timSinhVienTheoTen(String tenSv) {
		int i = 0;// ko co sinh vien co ten tren
		this.tableName("DANH SACH SINH VIEN TEN: " + tenSv, 5);
		this.columnNameStudentList();
		
		for(SinhVien sv : this.ds) {
			if(sv.getTen().equalsIgnoreCase(tenSv)) {
				sv.inThongTin(i+1);
				i++;
			}				
		}
		if(i == 0)// ko co sinh vien co ten tren
			System.out.printf("KHONG co sinh vien ten %s!\n", tenSv);
		this.line(StuListHyphenNum);
	}
	public void timSinhVienTheoTen() {
		Scanner scan = new Scanner(System.in);
		System.out.print("nhap ten sinh vien muon tim: ");
		timSinhVienTheoTen(scan.nextLine());
	}
	
	//tim sinh vien theo Ma so SV
	public void timSinhVienTheoMa(String maSv) {
		int i = 0;// ko co sinh vien co ma so nhu tren
		this.tableName("SINH VIEN CO MA SO: " + maSv, 5);
		this.columnNameStudentList();
		
		for(SinhVien sv : this.ds) {
			if(sv.getMaSv().equals(maSv)) {
				sv.inThongTin(i+1);
				i++;
				return;
			}				
		}
		if(i == 0)// ko co sinh vien co ma so nhu tren
			System.out.printf("KHONG co sinh vien co ma %s!\n", maSv);
		this.line(StuListHyphenNum);
	}
	public void timSinhVienTheoMa() {
		Scanner scan = new Scanner(System.in);
		System.out.print("nhap ma sinh vien muon tim: ");
		timSinhVienTheoMa(scan.nextLine());
	}
	
		//tim sinh vien theo Ma so SV
	public void xoaSinhVienTheoMa(String maSv) {
		int i = 0;// ko co sinh vien co ma so nhu tren
		this.tableName("SINH VIEN CO MA SO: " + maSv + " VUA BI XOA!", 5);
		this.columnNameStudentList();
		for(int j = 0; j < this.ds.size(); j++) {
			SinhVien sv = ds.get(j);
			if(sv.getMaSv().equals(maSv)) {
				sv.inThongTin(i+1);
				ds.remove(j);
				i++;
				return;
			}				
		}
		if(i == 0)// ko co sinh vien co ma so nhu tren
			System.out.printf("KHONG co sinh vien co ma %s!\n", maSv);
		this.line(StuListHyphenNum);
	}
	public void xoaSinhVienTheoMa() {
		Scanner scan = new Scanner(System.in);
		System.out.print("nhap ma sinh vien muon xoa: ");
		xoaSinhVienTheoMa(scan.nextLine());
	}
	
	//phuc vu testcase
	//Xếp loại từng sinh viên theo: >=9 -> Xuất Sắc, 9>Giỏi>=8, 8>Khá>=7, 7>Trung Binh-Kha>=6, 5>=Yếu
	public void themSV_suaToanLyHoa(double toan, double ly, double hoa) {
		SinhVien sv = new SinhVien();
		sv.autoGenerate();
		sv.sua_ToanLyHoa(toan, ly, hoa);
		
		this.ds.add(sv);
	}
	public void themSV_suaTen(String tenSv) {
		SinhVien sv = new SinhVien();
		sv.autoGenerate();
		sv.setTen(tenSv);
		
		this.ds.add(sv);
	}
	public void themSV_suaMaSv(String maSv) {
		SinhVien sv = new SinhVien();
		sv.autoGenerate();
		sv.setMaSv(maSv);
		
		this.ds.add(sv);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DanhSachSinhVien ds = new DanhSachSinhVien();
		ds.autoGenerateStudentList(10);
		
		ds.themSV_suaToanLyHoa(5, 2, 1.4);
		//ds.themSV_suaTen("Khang");
		ds.themSV_suaMaSv("113okDcChua");
		ds.themSV_suaToanLyHoa(0, 3, 1.8);
		//ds.themSV_suaTen("KHANG");
		
		ds.inDanhSachSinhVien();
		ds.timSinhVienYeu();
		ds.timSinhVienDTBcaoNhat();
		ds.timSinhVienTheoTen("Khang");
		ds.timSinhVienTheoMa("113okDcChua");
		ds.xoaSinhVienTheoMa("113okDcChua");
		ds.inDanhSachSinhVien();
	}

}
