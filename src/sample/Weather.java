package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONObject;

public class Weather {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LogInWeather;

    @FXML
    private Button LogInCovid;

    @FXML
    private Button LogInTest;

    @FXML
    private Button LogInCurrency;

    @FXML
    private Button LogInGame;

    @FXML
    private TextField city;

    @FXML
    private Text simple_text;

    @FXML
    private Button start_weather;

    @FXML
    private Text temp_info;

    @FXML
    private Button LogOutProg;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    public void initialize() {
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
        start_weather.setOnAction(event -> {
            String getUserCity = city.getText().trim();
            if (!getUserCity.equals("")) {
                String output = getUrlContent("https://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=f51990e7149906aa689774767bf390da&unit=metric");
                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    double res = Math.floor(obj.getJSONObject("main").getDouble("temp")-273.15f);
                    temp_info.setText("Temperature is : " + res + "°C");
                    System.out.println(res);
                }
            }


        });
    }
    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("error");
        }
        return content.toString();
    }
}
