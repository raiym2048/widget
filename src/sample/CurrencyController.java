package sample;


import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URLConnection;
import javafx.scene.control.Button;
import org.json.JSONObject;

public class CurrencyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ConvertButton;

    @FXML
    private Text EUR;

    @FXML
    private Text KGZ;

    @FXML
    private TextField KGZconvert;

    @FXML
    private Text RUB;

    @FXML
    private Text USD;

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
        ConvertButton.setOnAction(this::handle);
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

    private static String getUrlContetn(String urlAdress){
        StringBuffer content = new StringBuffer();
        try{
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("it works");
        }
        return content.toString();
    }


    private void handle(ActionEvent event) {

        String output = getUrlContetn("http://api.exchangeratesapi.io/v1/latest?access_key=d2bc9262291f2166afcd7a2e9a12ad9f&format=1");

        if (!output.isEmpty()) {

            Double getCurrency = Double.parseDouble(KGZconvert.getText().trim());
            JSONObject obj = new JSONObject(output);

            double USD1 = obj.getJSONObject("rates").getDouble("USD");
            double RUB1 = obj.getJSONObject("rates").getDouble("RUB");
            double KGS1 = obj.getJSONObject("rates").getDouble("KGS");

            double calculatedUSD = USD1 * getCurrency;
            double calculatedRUB = RUB1 * getCurrency;
            double calculatedKGS = KGS1 * getCurrency;


            USD.setText(String.format("USD: %.2f", calculatedUSD));
            RUB.setText(String.format("RUB: %.2f", calculatedRUB));
            KGZ.setText(String.format("KGS: %.2f", calculatedKGS));



        }
    }
}
