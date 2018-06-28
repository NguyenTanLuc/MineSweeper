//package view;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//
//public class HightScore extends Application implements IView {
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("HighScore.fxml"));
//			Scene scene = new Scene(root, 400, 400);
//			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (Exception e) 
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void start(String[] args) {
//		launch(args);
//	}
//
//	@Override
//	public Button[][] getCell() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public void update(int i, int j, Button[][] cell) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
