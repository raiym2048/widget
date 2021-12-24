package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView image1;

    @FXML
    void initialize() {
        assert image1 != null : "fx:id=\"image1\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
