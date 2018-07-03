package application;

import controller.Controller;
import model.CreatMine;
import model.IModel;
import model.Model;
import model.SizeBoard;
import view.Board;

public class Client {
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Board iView = new Board();
		IModel iModel = new Model();
		System.out.println(iModel.getMine().length);
		Controller controller = new Controller(iView ,iModel);
		controller.startApp(args);

	}
}
