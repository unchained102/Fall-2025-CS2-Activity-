package edu.westga.cs1302.comic_collection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Entry point for the program
 *
 * @author CS 1302
 * @version Fall 2025
 */
public class Main extends Application {
  public static final String ADD_COMIC_WINDOW_TITLE = "Comic Collection";
  public static final String ADD_COMIC_WINDOW = "view/AddComicWindow.fxml";
  private static final String MAIN_WINDOW_TITLE = "Comic Collection";
  private static final String MAIN_WINDOW = "view/MainWindow.fxml";
  


  /**
   * JavaFX entry point.
   *
   * @precondition none
   * @postcondition none
   *
   * @throws IOException
   */
  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource(Main.MAIN_WINDOW));
    Scene scene = new Scene(parent);
    primaryStage.setTitle(MAIN_WINDOW_TITLE);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Primary Java entry point.
   *
   * @precondition none
   * @postcondition none
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    Main.launch(args);
  }
  
}