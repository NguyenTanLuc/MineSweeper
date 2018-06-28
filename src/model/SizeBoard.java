package model;

public class SizeBoard {
	public final static SizeBoard  LVL_EASY = new SizeBoard(8, 8, 10); 
	public final static SizeBoard  LVL_NORMAL = new SizeBoard(15,15, 40); 
	public final static SizeBoard  LVL_HARD = new SizeBoard(20, 20, 80); 
	private int wieght;
	private int hight;
	private int boom ;
	public SizeBoard(int wieght, int hight, int boom) {
		this.wieght = wieght;
		this.hight = hight;
		this.boom = boom;
	}
	public int getWieght() {
		return wieght;
	}
	public int getHight() {
		return hight;
	}
	public int getBoom() {
		return boom;
	}
	public void setWieght(int wieght) {
		this.wieght = wieght;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	public void setBoom(int boom) {
		this.boom = boom;
	}
}
