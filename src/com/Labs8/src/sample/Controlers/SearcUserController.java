package sample.Controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearcUserController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Label;


    @FXML
    private Button addCareerButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button addCharacteristicButton;

    @FXML
    private Button backButton;



    @FXML
    void initialize() {
        if (SearchController.book !=null) {
            Label.setText(SearchController.book.toString());
        }else {
            Label.setText("Не найдено");
        }

        backButton.setOnAction(event -> {
            FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/sample/resurs/sample.fxml"));
            try {
                l.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = l.getRoot();
            Controller.primarystage.setScene(new Scene(root));
            Controller.primarystage.show();
        });




        deleteButton.setOnAction(event -> {
            while (SearchController.book !=null){
                Main.list.remove(SearchController.book);
                break;
            }
            FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/sample/resurs/sample.fxml"));
            try {
                l.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = l.getRoot();
            Controller.primarystage.setScene(new Scene(root));
            Controller.primarystage.show();

        });
    }
}
