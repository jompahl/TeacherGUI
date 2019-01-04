package application;

import controllers.DetailedStudentsController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Student;
import controllers.*;

import java.util.ArrayList;

public class Main extends Application {

	static AnchorPane root;
	static ArrayList<AnchorPane> grid = new ArrayList<AnchorPane>();
	private static int idxCur = 0;

	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(this.getClass().getResource("/view/Main.fxml"));
			
			grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("/view/FirstMenu.fxml")));
			grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("/view/Students.fxml")));
			grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("/view/Courses.fxml")));
			grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("/view/WrittenExam.fxml")));
			grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("/view/DetailedStudent.fxml")));
			
			root.getChildren().add(grid.get(0));
			Scene scene = new Scene(root,550,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.setTitle("IS-project");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void init_app() {
		for (int i = 0; i < grid.size(); i++) {
			
		}
	}
	public static AnchorPane getPane(int idx) {
		return grid.get(idx);
	}
	public static void setPane(int idx) {
		root.getChildren().remove(grid.get(idxCur));
		root.getChildren().add(grid.get(idx));
		idxCur = idx;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
