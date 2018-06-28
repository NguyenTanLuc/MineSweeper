package controller;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.IModel;
import model.SizeBoard;
import view.Board;
import view.IView;

public class Controller  {
	IView view;
	IModel model;

	public Controller(IView view ,IModel iModel) {
		this.view = (Board) view;
		this.model = iModel;
		this.model.addOb(view);
	}

	public void startApp(String[] args) {
		view.start(args);

	}

	public IModel getModel() {
		return model;
	}

	public int[][] getMine() {
		return model.getMine();
	}

	public boolean[][] getOpen() {
		return model.getCheck();
	}

	public Button[][] getCell() {
		return view.getCell();
	}

	public boolean isLose() {
		return model.isLose();
	}

	public boolean isWin() {
		return model.isWin();
	}
	public GridPane createBoardMine() {
		return model.createBoarMine();
	}
	public void setLevel (SizeBoard sizeBoard) {
		model.setLevel(sizeBoard);
		
	}
	

	public void openCell(int i, int j) {
		if(!(model.isLose() || model.isWin())){
			Queue<Point> listzero = new LinkedList<>();
			model.openCell(j, i, listzero);
			model.spreadCell(model, listzero);
			if (getOpen()[j][i] == false) {
				getOpen()[j][i] = true;
			}
		}
		model.check(i, j);
	}
	public void notifyAllCell() {
		model.notifyAllCell();
	}

//	@Override
//	public void update(int i, int j) {
//		setActionButton(i, j);
//		model.check(i, j);
//		System.out.println(model.isLose());
//		System.out.println(model.isWin());
//	}

}
