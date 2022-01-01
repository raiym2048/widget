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

public class CovidController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text cases_info;

    @FXML
    private Text rec_info;

    @FXML
    private Text death_info;

    @FXML
    private Text cases_info_county;

    @FXML
    private Text rec_info_country;

    @FXML
    private Text death_info_country;

    @FXML
    private  Button search;

    @FXML
    private TextField country;

    @FXML
    private Button refresh;

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
        start();
        refresh.setOnAction(event -> {
            start();});

    }
    private void start () {
        String output = getUrlContent("https://coronavirus-19-api.herokuapp.com/all");
        JSONObject obj = new JSONObject(output);
        int recovered = obj.getInt("recovered");
        rec_info.setText(String.valueOf(recovered));
        int cases = obj.getInt("cases");
        cases_info.setText(String.valueOf(cases));
        int deaths = obj.getInt("deaths");
        death_info.setText(String.valueOf(deaths));

        search.setOnAction(event -> {
            String getUserCountry = country.getText().trim();
            if (!getUserCountry.equals("")) {
                String name = getUrlContent("https://coronavirus-19-api.herokuapp.com/countries/" + getUserCountry);
                if (!name.isEmpty()) {
                    JSONObject county_user = new JSONObject(name);
                    int recovered_user = county_user.getInt("recovered");
                    rec_info_country.setText(String.valueOf(recovered_user));
                    int cases_user = county_user.getInt("cases");
                    cases_info_county.setText(String.valueOf(cases_user));
                    int deaths_user = county_user.getInt("deaths");
                    death_info_country.setText(String.valueOf(deaths_user));
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
