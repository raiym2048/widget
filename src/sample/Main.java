package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root,750,700));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int [] array = new int[n];
        for(int i = 0;i < n;i++){
            array[i] = -13 + (int)(Math.random() * ((57 - (-13)) + 1));
            if(array[i] > n){
                System.out.println(array[i]);
                count++;
            }
        }
        System.out.println(count);*/
        launch(args);
    }
}
