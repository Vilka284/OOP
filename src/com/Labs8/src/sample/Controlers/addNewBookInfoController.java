package sample.Controlers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import sample.Book.BookInfo;

public class addNewBookInfoController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField GenreField;

    @FXML
    private TextField PublicationField;

    @FXML
    private TextField AuthorsField;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        addButton.setOnAction(event -> {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setGenre(GenreField.getText());
            bookInfo.setPublication(PublicationField.getText());
            bookInfo.setAuthors(AuthorsField.getText());
            AddNewBookController.setBookInfo(bookInfo);

            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        });
        backButton.setOnAction(event -> {
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        });
    }
}
