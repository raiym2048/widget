package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CurrencyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LogInCovid;

    @FXML
    private Button LogInCurrency;

    @FXML
    private Button LogInGame;

    @FXML
    private Button LogInTest;

    @FXML
    private Button LogInWeather;

    @FXML
    void initialize() {
        LogInWeather.setOnAction(event ->{
            try {
                Parent root = FXMLLoader.load(Main.class.getResource("/sample/Weather.fxml"));

                LogInWeather.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        LogInTest.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(Main.class.getResource("/sample/Java.fxml"));

                LogInTest.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        LogInCurrency.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(Main.class.getResource("/sample/Currency.fxml"));

                LogInCurrency.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        LogInCovid.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(Main.class.getResource("/sample/Covid.fxml"));

                LogInCovid.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        LogInGame.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(Main.class.getResource("/sample/Game.fxml"));

                LogInGame.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
