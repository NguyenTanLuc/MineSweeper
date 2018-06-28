package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import controller.Observer;
import controller.Subject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import view.AbtractFactory;
import view.Icon;

public class Model implements IModel, Subject {
	private List<Observer> listOp = new ArrayList<>();
	private LabelTimer time;
	Button[][] cell ;
	
	CreatMine creatMine;
	Open open;

	public Model() {
		creatMine = new CreatMine(SizeBoard.LVL_EASY);
		open = new Open(creatMine);
	}

	@Override
	public CreatMine getCreatMine() {
		return creatMine;
	}

	@Override
	public Open getOpen() {
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
	public GridPane createBoarMine() {
		cell = new Button[getSize()][getSize2()];
		GridPane boardPane = new GridPane();
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[0].length; j++) {
				cell[i][j] = new Button();
				cell[i][j].setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						for (int j2 = 0; j2 < getMine().length; j2++) {
							for (int j3 = 0; j3 < getMine()[j2].length; j3++) {
								if (arg0.getSource() == cell[j3][j2]) {
									notifyy(j2, j3, cell);
									System.out.println("adas");
									break;
								}
							}

						}
					}

				});
				cell[i][j].setPrefSize(65, 65);
				boardPane.add(cell[i][j], i, j);

			}
		}
		return boardPane;

	}

	@Override
	public void setLevel(SizeBoard sizeBoard) {
		creatMine = new CreatMine(sizeBoard);
		open = new Open(creatMine);

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
	public void notifyAllCell() {
		for (Observer observer : listOp) {
			observer.update(cell);
		}
	}

}
