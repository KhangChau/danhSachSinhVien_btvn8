package july_25th.btvn_8;

import java.util.Random;
import java.util.Scanner;

public class SinhVien {
	private String ten;
	private String maSv;
	private double diemToan, diemLy, diemHoa, diemTB;
	private String loai;
	
	public SinhVien() {
		this.diemTB = -1d;
		this.loai = "chua xep loai";
	}

	public SinhVien(String ten, String maSv) {
		// TODO Auto-generated constructor stub
		this.ten = ten;
		this.maSv = maSv;
		this.diemTB = -1d;
		this.loai = "chua xep loai";
	}
	public SinhVien(String ten, String maSv, double diemToan, double diemLy, double diemHoa) {
		// TODO Auto-generated constructor stub
		this.ten = ten;
		this.maSv = maSv;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
		this.tinhDTB();
		this.reXepLoai();
	}
	
	
	//nhap ten, maSV, diem TOAN LY HOA
	public void nhapTen() {
		Scanner scan = new Scanner(System.in);
		System.out.print("nhap ten: ");
		this.setTen(scan.nextLine());
	}
	public void nhapMaSv() {
		Scanner scan = new Scanner(System.in);
		System.out.print("nhap maSv: ");
		this.setMaSv(scan.nextLine());
	}
	//kiem tra diem [0,10]
	Boolean kiemTraDiem(double diem) {
		return (diem >= 0d && diem <= 10d)? true : false;
	}
	public void nhapDiemToan() {
		Scanner scan = new Scanner(System.in);
		double diem = 0d;
		
		do {
			System.out.print("nhap diem Toan [0, 10]: ");
			diem = Double.parseDouble(scan.nextLine());
		} 
		while(!this.kiemTraDiem(diem));		
		
		this.setDiemToan(diem);
		
		this.tinhDTB();
		this.reXepLoai();
	}
	public void nhapDiemHoa() {
		Scanner scan = new Scanner(System.in);
		double diem = 0d;
		
		do {
			System.out.print("nhap diem Hoa [0, 10]: ");
			diem = Double.parseDouble(scan.nextLine());
		} 
		while(!this.kiemTraDiem(diem));		
		
		this.setDiemHoa(diem);

		this.tinhDTB();
		this.reXepLoai();
	}
	public void nhapDiemLy() {
		Scanner scan = new Scanner(System.in);
		double diem = 0d;
		
		do {
			System.out.print("nhap diem Ly [0, 10]: ");
			diem = Double.parseDouble(scan.nextLine());
		} 
		while(!this.kiemTraDiem(diem));		
		
		this.setDiemLy(diem);

		this.tinhDTB();
		this.reXepLoai();
	}
	public void nhapThongTin() {
		this.nhapTen();
		this.nhapMaSv();
		this.nhapDiemToan();
		this.nhapDiemHoa();
		this.nhapDiemLy();		
	}
	
	//tinh diem trung binh
	public double dTB() {
		return (diemToan + diemLy + diemHoa) / 3;
	}
	public void tinhDTB() {
		this.diemTB = dTB();
	}
	
	//Xếp loại từng sinh viên theo: >=9 -> Xuất Sắc, 9>Giỏi>=8, 8>Khá>=7, 7>Trung Binh-Kha>=6, 5>=Yếu
	public String xepLoai() {
		if(diemTB >= 9d)
			return "Xuat Sac";
		else if(diemTB >= 8d)
			return "Gioi";
		else if(diemTB >= 7d)
			return "Kha";
		else if(diemTB >= 6d)
			return "Trung Binh-Kha";
		else if(diemTB >= 5d)
			return "Trung Binh";
		else 
			return "Yeu";
	}
	public void reXepLoai() {
		this.loai = xepLoai();
	}
	//in thong tin Sinh Vien
	public void inThongTin(int no) {
		System.out.printf("| %-5d"
				+ "| %-15s"
				+ "| %-15s"
				+ "| %-10.2f"
				+ "| %-10.2f"
				+ "| %-10.2f"
				+ "| %-15.2f"
				+ "| %-15s"
				+ "|\n"
				, no, this.ten, this.maSv, this.diemToan, this.diemLy, this.diemHoa, this.diemTB, this.loai);
	}
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSV) {
		this.maSv = maSV;
	}

	public double getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(double diemToan) {
		this.diemToan = diemToan;
	}

	public double getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(double diemLy) {
		this.diemLy = diemLy;
	}

	public double getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(double diemHoa) {
		this.diemHoa = diemHoa;
	}

	public double getDiemTB() {
		return diemTB;
	}
	public String getXepLoai() {
		return this.loai;
	}
	
	private String stringGenerate(int length) {
		String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" + " ";
		Random random = new Random();
		String s = "";
		for(int i = 0; i < length; i++) {
			s += c.charAt(random.nextInt(c.length()));
		}
		return s;
	}
	private double floatingGenerate(double max, double min) {
		Random random = new Random();
		return random.nextDouble() * (max - min) + min;
	}
	public void autoGenerate() {
		this.setTen(stringGenerate(10));
		this.setMaSv(stringGenerate(10));
		this.setDiemToan(floatingGenerate(10d, 0d));
		this.setDiemHoa(floatingGenerate(10d, 0d));
		this.setDiemLy(floatingGenerate(10d, 0d));
		
		this.tinhDTB();
		this.reXepLoai();
	}
	
	public void sua_ToanLyHoa(double toan, double ly, double hoa) {
		this.setDiemHoa(hoa);
		this.setDiemLy(ly);
		this.setDiemToan(toan);
		
		this.tinhDTB();
		this.reXepLoai();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SinhVien sv = new SinhVien();
//		sv.nhapThongTin();
//		sv.inThongTin();
		for(int i = 0; i < 5; i++) {
			SinhVien sv = new SinhVien();
			sv.autoGenerate();
			sv.inThongTin(i+1);
		}
	}

}
