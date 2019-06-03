package sample.Controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Book.Book;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NameFIELD;

    @FXML
    private Button backButton;

    @FXML
    private Button SearchBUTTON;


    public static Book book = null;

    @FXML
    void initialize() {
        SearchBUTTON.setOnAction(event -> {
            for (Book p:
                    Main.list){
                if (p.getName().equals(NameFIELD.getText())){
                    book = p;
                    break;
                }
            }

            FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/sample/resurs/searchBooksMenu.fxml"));
            try {
                l.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = l.getRoot();
            Controller.primarystage.setScene(new Scene(root));
            Controller.primarystage.show();
        });

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

    }
}
