package controller;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.IModel;
import model.SizeBoard;
import view.Board;

public class Controller {
	Board view;
	IModel model;

	public Controller(Board view, IModel iModel) {
		this.view = view;
		this.model = iModel;
		this.model.addOb(view);
	}

	public void startApp(String[] args) {
		view.run(args);

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

	public boolean isLose() {
		return model.isLose();
	}

	public boolean isWin() {
		return model.isWin();
	}

	public void setLevel(SizeBoard sizeBoard) {
		model.setLevel(sizeBoard);

	}

	public void openCell(int i, int j) {
		if (!(model.isLose() || model.isWin())) {
			Queue<Point> listzero = new LinkedList<>();
			model.openCell(j, i, listzero);
			model.spreadCell(model, listzero);
			if (getOpen()[j][i] == false) {
				getOpen()[j][i] = true;
			}
		}
		model.check(i, j);
	}

	Button[][] cell;

	public void notifyAllCell() {
		model.notifyAllCell(cell);
	}

	public GridPane createBoarMine() {
		cell = new Button[model.getSize()][model.getSize2()];
		GridPane boardPane = new GridPane();
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[0].length; j++) {
				cell[i][j] = new Button();
				cell[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						for (int j2 = 0; j2 < getMine().length; j2++) {
							for (int j3 = 0; j3 < getMine()[j2].length; j3++) {
								if (event.getSource() == cell[j3][j2]) {
									if (event.getButton().equals(MouseButton.PRIMARY)) {
										model.notifyy(j2, j3, cell);
									}
									if (event.getButton().equals(MouseButton.SECONDARY)) {
										view.setRightClick(j2, j3, cell);
										break;
									}
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

}
