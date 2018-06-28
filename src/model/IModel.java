package model;

import java.awt.Point;
import java.util.Queue;

import controller.Observer;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public interface IModel {
	int[][] getMine();

	boolean[][] getCheck();
	public boolean isLose();
	public boolean isWin();
	public int getSize();
	public int getSize2();
	public int getBoom();

	void spreadCell(IModel mine, Queue<Point> a);

	void openCell(int i, int j, Queue<Point> queue);
	boolean check(int i , int j);

	void setSize(int hight);
	void addOb(Observer a);

	CreatMine getCreatMine();

	Open getOpen();

	void setLevel(SizeBoard sizeBoard);

	void notifyy(int i, int j, Button[][] cell);

	GridPane createBoarMine();

	void notifyAllCell();

}
