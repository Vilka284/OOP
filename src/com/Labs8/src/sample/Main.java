package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Book.Book;
import sample.Book.BookInfo;
import sample.Controlers.Controller;

import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Book> list = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resurs/sample.fxml"));
        primaryStage.setTitle("Бібліотека");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        Controller.primarystage = primaryStage;

    }


    public static void main(String[] args) {
        launch(args);
    }
    public void setList(ArrayList<Book> list){
        this.list = list;
    }
    public ArrayList<Book> getList(){
        return list;
    }

}
