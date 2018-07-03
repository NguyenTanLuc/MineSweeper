package view;

import controller.Controller;
import controller.Observer;
import extension.Ultis;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Model;
import model.SetTextTime;
import model.SizeBoard;

public class Board extends Application implements Observer, EventHandler<ActionEvent> {
	private AbtractFactory factory;
	private int countClick = 0;
	private Controller controller;
	private BorderPane boder;
	private Text timer;
	private GridPane boardPane;
	private BorderPane pane;
	private SetTextTime time;
	public static int level = 1;
	private MenuItem easy;
	private MenuItem changDisplay;
	private MenuItem listPlayerWin;
	private MenuItem menu;
	private MenuItem normal;
	private MenuItem hard;
	private MenuItem about;
	private BorderPane panelbig;
	private Button btnNewGame;
	private String theme = Ultis.DISPLAY_CLASSIC;

	public Board() {
		controller = new Controller(this, new Model());
		boder = new BorderPane();
		timer = new Text();
		timer.setId("timer");
		time = new SetTextTime(timer);
		factory = new AbtractFactory(new FactoryMethodDialog(), new FactoryMethodIcon());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		panelbig = new BorderPane();
		panelbig.setId("panelbig");
		pane = new BorderPane();
		pane.setId("pane");

		BorderPane panelMatCuoi = new BorderPane();
		panelMatCuoi.setId("panelMatCuoi");
		btnNewGame = new Button();
		btnNewGame.setPrefSize(45, 45);
		panelMatCuoi.setRight(timer);
		panelMatCuoi.setCenter(btnNewGame);

		btnNewGame.setOnAction(this);
		btnNewGame.setId("btnNewGame");


		pane.setTop(time);
		MenuBar menuBar = new MenuBar();

		Menu game = new Menu("Game");
		Menu levl = new Menu("Level");
		Menu help = new Menu("Help");

		easy = new MenuItem("Easy");
		changDisplay = new MenuItem("Change Display");
		menu = new MenuItem("Quit Game");
		listPlayerWin = new MenuItem("Player Win");
		normal = new MenuItem("Normal");
		hard = new MenuItem("Hard");
		about = new MenuItem("About");

		about.setOnAction(this);
		easy.setOnAction(this);
		normal.setOnAction(this);
		hard.setOnAction(this);
		changDisplay.setOnAction(this);
		menu.setOnAction(this);
		listPlayerWin.setOnAction(this);

		game.getItems().addAll(changDisplay, listPlayerWin, menu);
		levl.getItems().addAll(easy, normal, hard);
		help.getItems().add(about);
		menuBar.getMenus().addAll(game, levl, help);

		boardPane = controller.createBoarMine();
		boardPane.setId("boardPane");
		panelbig.setTop(panelMatCuoi);
		panelbig.setCenter(boardPane);
		boder.setTop(menuBar);
		boder.setCenter(panelbig);
		Scene seen = new Scene(boder, 700, 700);
		seen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Mine Sweeper");
		primaryStage.setScene(seen);
		primaryStage.show();

	}

	public void run(String[] args) {
		launch();

	}


	@Override
	public void update(int k, int l, Button[][] cell) {
		controller.openCell(k, l);
		setGraphis(cell);

	}

	@Override
	public void handle(ActionEvent event) {
		if (easy == event.getSource()) {
			level = Ultis.EASY;
			resetGame(SizeBoard.LVL_EASY);

		}
		if (normal == event.getSource()) {
			level = Ultis.NORMAL;
			resetGame(SizeBoard.LVL_NORMAL);

		}
		if (hard == event.getSource()) {
			level = Ultis.HARD;
			resetGame(SizeBoard.LVL_HARD);

		}
		if (about == event.getSource()) {
			factory.creatDiaLog(Ultis.DIALOG_ABOUT);
		}
		if (changDisplay == event.getSource()) {
			if (countClick % 2 == 0) {
				theme = Ultis.DISPLAY_BEAUTIFUL;
			} else {
				theme = Ultis.DISPLAY_CLASSIC;
			}
			countClick++;
			controller.notifyAllCell();
		}
		if (menu == event.getSource()) {
			Platform.exit();
		}
		if (btnNewGame == event.getSource()) {
			SizeBoard sizeBoard = null;
			if (level == Ultis.EASY) {
				sizeBoard = SizeBoard.LVL_EASY;
			} else if (level == Ultis.NORMAL) {
				sizeBoard = SizeBoard.LVL_NORMAL;
			} else if (level == Ultis.HARD) {
				sizeBoard = SizeBoard.LVL_HARD;
			}
			resetGame(sizeBoard);
		}
		if (listPlayerWin == event.getSource()) {
			factory.creatDiaLog("PlayWin");
		}

	}

	@Override
	public void update(Button[][] cell) {
		setGraphis(cell);
	}

	public void resetGame(SizeBoard sizeBoard) {
		controller.setLevel(sizeBoard);
		time.setStop(true);
		time.resettime();
		boardPane = controller.createBoarMine();
		boardPane.setId("boardPane");
		panelbig.setCenter(boardPane);
	}

	public void setGraphis(Button[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[0].length; j++) {
				if (controller.getOpen()[j][i] == true) {
					if (controller.getMine()[j][i] == -1) {

						cell[j][i].setGraphic(new ImageView(factory.createIcon(theme).getMine()));
						if (controller.isLose()) {
							time.setStop(false);
							boardPane.setDisable(true);
							factory.creatDiaLog("DialogLose");

						}
					} else {
						if (controller.getMine()[j][i] == 1) {
							cell[j][i].setGraphic(new ImageView(factory.createIcon(theme).getNumber1()));
							cell[j][i].setBackground(
									new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

						}
						if (controller.getMine()[j][i] == 2) {
							cell[j][i].setGraphic(new ImageView(factory.createIcon(theme).getNumber2()));
							cell[j][i].setBackground(
									new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

						}
						if (controller.getMine()[j][i] == 3) {
							cell[j][i].setGraphic(new ImageView(factory.createIcon(theme).getNumber3()));
							cell[j][i].setBackground(
									new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

						}
						if (controller.getMine()[j][i] == 4) {
							cell[j][i].setGraphic(new ImageView(factory.createIcon(theme).getNumber4()));
							cell[j][i].setBackground(
									new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

						}
						if (controller.getMine()[j][i] == 5) {
							cell[j][i].setGraphic(new ImageView(factory.createIcon(theme).getNumber5()));
						}
						if (controller.getMine()[j][i] == 6) {
							cell[j][i].setGraphic(new ImageView(factory.createIcon(theme).getNumber6()));
							cell[j][i].setBackground(
									new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

						}
						if (controller.getMine()[j][i] == 0) {
							cell[j][i].setGraphic(new ImageView(factory.createIcon(theme).getNumber0()));
							cell[j][i].setBackground(
									new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

						}
						if (controller.isWin()) {
							time.setStop(false);
							factory.creatDiaLog("DialogWin");

						}
					}
				}
			}
		}
	}

	public void setRightClick(int i, int j, Button[][] cell) {
		if (controller.getOpen()[j][i] == false) {
			cell[j][i].setGraphic(new ImageView(factory.createIcon(theme).getFlag()));

		}

	}

}
