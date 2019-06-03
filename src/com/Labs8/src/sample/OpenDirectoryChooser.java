package sample;

import java.io.File;


import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class OpenDirectoryChooser  {

    private void configuringDirectoryChooser(DirectoryChooser directoryChooser) {

        directoryChooser.setTitle("Select Some Directories");

        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }
    public String getDirectory(){
        Stage primaryStage = new Stage();
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        configuringDirectoryChooser(directoryChooser);
        File dir = directoryChooser.showDialog(primaryStage);
        String path = new String();
        if (dir != null) {
            path=dir.getAbsolutePath();
        } else {
            path=null;
        }
        return path;
    }
}
