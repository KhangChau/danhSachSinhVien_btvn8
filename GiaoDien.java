package july_25th.btvn_8;

public class GiaoDien {
	static int StuListHyphenNum = 112;
	
	protected void line(int numOfHyphen) {
		System.out.println("-".repeat(numOfHyphen));
	}
	protected void tableName(String tName, int numOfTabs) {
		this.line(StuListHyphenNum);
		System.out.println("\t".repeat(numOfTabs) + tName);
		this.line(StuListHyphenNum);
	}
	protected void columnNameStudentList() {
		System.out.printf("| %-5s"
				+ "| %-15s"
				+ "| %-15s"
				+ "| %-10s"
				+ "| %-10s"
				+ "| %-10s"
				+ "| %-15s"
				+ "| %-15s"
				+ "|\n"
				, "no", "ten", "ma so SV", "diem Toan", "diem Ly", "diem Hoa", "diem Trung Binh", "Xep Loai");
		this.line(StuListHyphenNum);
	}
	
	public GiaoDien() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		GiaoDien gd = new GiaoDien();
		gd.line(StuListHyphenNum);
		gd.tableName("DANH SACH SINH VIEN", 4);
	}

}
