package sample.Controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.Book.Book;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    private Label NAMELABEL;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        String fn = "";
        String ln = "";
        for (Book p:
                Main.list){
            fn += p.getName()+"\n";
        }
        NAMELABEL.setText(fn);

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
            Main.list.clear();
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
