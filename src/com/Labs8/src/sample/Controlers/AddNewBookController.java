package sample.Controlers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Book.Book;
import sample.Hellper;
import sample.Main;
import sample.Shake;
import sample.Book.BookInfo;


public class AddNewBookController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addNewBookButton;

    @FXML
    private TextField NameField;

    @FXML
    private TextField ISBNField;

    @FXML
    private Button addBookInfoButton;

    @FXML
    private Button backButton;


    static Book book = new Book();

    @FXML
    void initialize() {
        addNewBookButton.setOnAction(event -> {

            if (NameField.getText().equals("")){
                Shake shake = new Shake(NameField);
                shake.playanim();
            }else {
                book.setName(NameField.getText());
            }
            if (!Hellper.isValidISBN(ISBNField.getText())){
                Shake shake = new Shake(ISBNField);
                shake.playanim();
            }else {
                book.setISBN(ISBNField.getText());
            }

            Main.list.add(book);
            book = null;
            book = new Book();
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

        addBookInfoButton.setOnAction(event -> {
            FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/sample/resurs/addBookInfoMenu.fxml"));
            try {
                l.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = l.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
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
    public static void setBookInfo(BookInfo bookInfo){
        book.setBookInfo(bookInfo);
    }

}
