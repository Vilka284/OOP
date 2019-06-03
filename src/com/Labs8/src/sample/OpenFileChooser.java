package sample;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;

public class OpenFileChooser  {
    private Desktop desktop = Desktop.getDesktop();

    public File getFile(){
        Stage primaryStage = new Stage();
        final FileChooser fileChooser = new FileChooser();
        configuringFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(primaryStage);
        return file;
    }

    private void configuringFileChooser(FileChooser fileChooser) {
        fileChooser.setTitle("Select File");

        fileChooser.getExtensionFilters().addAll(//
                new FileChooser.ExtensionFilter("LST", "*.lst"), //
                new FileChooser.ExtensionFilter("XML", "*.xml"));
    }

}
