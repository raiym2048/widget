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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONObject;

public class HomeController {
    @FXML
    private Button LogInWeather;

    @FXML
    private Button LogInCurrency;

    @FXML
    private Button LogInGame;

    @FXML
    private Button LogInTest;

    @FXML
    private Button LogInCovid;



    @FXML
    private TextField city;

    @FXML
    private Text simple_text;

    @FXML
    private Button start_weather;

    @FXML
    private Text temp_info;


    public void initialize() {
        start_weather.setOnAction(event -> {
            String getUserCity = city.getText().trim();
            if (!getUserCity.equals("")) {
                String output = getUrlContent("https://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=f51990e7149906aa689774767bf390da&unit=metric");
                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    double res = Math.floor(obj.getJSONObject("main").getDouble("temp")-273.15f);
                    temp_info.setText("Temperature is : " + res + "°C");
                   /* temp_feels.setText("ощущается: " + obj.getJSONObject("main").getDouble("feels_like"));
                    temp_max.setText("максимум: " + obj.getJSONObject("main").getDouble("temp_max"));
                    temp_min.setText("минимум: " + obj.getJSONObject("main").getDouble("temp_min"));
                    pressure.setText("давление: " + obj.getJSONObject("main").getDouble("pressure"));
                    humidity.setText("важность: " + obj.getJSONObject("main").getDouble("humidity"));
                    sea_level.setText("уровень моря: " + obj.getJSONObject("main").getDouble("sea_level"));
                    grnd_level.setText("grnd_level: " + obj.getJSONObject("main").getDouble("grnd_level"));
*/
                }

            }


        });

        //ada
        LogInWeather.setOnAction(event -> {
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Weather.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 600, 700));
            primaryStage.show();
            /*weather.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Weather.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();*/
        });

        LogInCovid.setOnAction(event ->{
            LogInCovid.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Covid.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        LogInTest.setOnAction(event -> {
            LogInTest.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Java.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        LogInCurrency.setOnAction(event -> {
            LogInCurrency.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Currency.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        LogInCovid.setOnAction(event -> {
            LogInCovid.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Covid.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        LogInGame.setOnAction(event -> {
            LogInGame.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Game.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }// currency
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
