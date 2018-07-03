package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import controller.Observer;
import controller.Subject;
import javafx.scene.control.Button;

public class Model implements IModel, Subject {
	private List<Observer> listOp = new ArrayList<>();

	CreatMine creatMine;
	OpenCell open;

	public Model() {
		creatMine = new CreatMine(SizeBoard.LVL_EASY);
		open = new OpenCell(creatMine);
	}

	@Override
	public CreatMine getCreatMine() {
		return creatMine;
	}

	@Override
	public OpenCell getOpen() {
		return open;
	}

	@Override
	public int[][] getMine() {
		// TODO Auto-generated method stub
		return creatMine.getMine();
	}

	@Override
	public boolean[][] getCheck() {
		// TODO Auto-generated method stub
		return open.getCheck();
	}

	@Override
	public void spreadCell(IModel mine, Queue<Point> a) {
		open.spreadCell(mine, a);
	}

	@Override
	public void openCell(int i, int j, Queue<Point> queue) {
		open.openCell(i, j, queue);
		// TODO Auto-generated method stub

	}

	@Override
	public boolean check(int i, int j) {
		return open.check(i, j);
	}

	@Override
	public boolean isLose() {
		// TODO Auto-generated method stub
		return open.isLose();
	}

	@Override
	public boolean isWin() {
		// TODO Auto-generated method stub
		return open.isWin();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return creatMine.getSize();
	}

	@Override
	public int getSize2() {
		// TODO Auto-generated method stub
		return creatMine.getSize2();
	}

	@Override
	public int getBoom() {
		// TODO Auto-generated method stub
		return creatMine.getBoom();
	}

	@Override
	public void setSize(int hight) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLevel(SizeBoard sizeBoard) {
		creatMine = new CreatMine(sizeBoard);
		open = new OpenCell(creatMine);

	}

	@Override
	public void removeOb(Observer ob) {
		listOp.remove(ob);

	}

	@Override
	public void addOb(Observer ob) {
		listOp.add(ob);
	}

	@Override
	public void notifyy(int i, int j, Button[][] cell) {
		for (Observer observer : listOp) {
			observer.update(i, j, cell);
		}
	}

	@Override
	public void notifyAllCell(Button[][] cell) {
		for (Observer observer : listOp) {
			observer.update(cell);
		}
	}

}
