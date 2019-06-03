package sample.Controlers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;
import sample.OpenDirectoryChooser;
import sample.OpenFileChooser;
import sample.Save;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addNewBook;

    @FXML
    private Button importList;


    @FXML
    private Button findBook;

    @FXML
    private Button reviewList;

    @FXML
    private Button saveList;



    public static Stage primarystage;


    @FXML
    void initialize() {
        addNewBook.setOnAction(event -> {
            FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/sample/resurs/addBooksMenu.fxml"));
            try {
                l.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = l.getRoot();
            primarystage.setScene(new Scene(root));
            primarystage.show();
        });

        findBook.setOnAction(event -> {
            FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/sample/resurs/searchController.fxml"));
            try {
                l.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = l.getRoot();
            primarystage.setScene(new Scene(root));
            primarystage.show();
        });



        reviewList.setOnAction(event -> {
            FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/sample/resurs/listMenu.fxml"));
            try {
                l.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = l.getRoot();
            primarystage.setScene(new Scene(root));
            primarystage.show();
        });

        saveList.setOnAction(event -> {
            sample.OpenDirectoryChooser directoryChooser = new OpenDirectoryChooser();
            String directory = directoryChooser.getDirectory();
            System.out.println(directory);
            Save save = new Save();
            save.standartWrite(Main.list, directory);
            save.writeToXML(Main.list, directory);
        });

        importList.setOnAction(event -> {
            sample.OpenFileChooser fileChooser = new OpenFileChooser();
            File file = fileChooser.getFile();
            Save save = new Save();
            if (file.getName().toString().contains("xml")){
                Main.list = save.readFromXML(file);
            }else {
                Main.list = save.standartRead(file);
            }
        });
    }
}
