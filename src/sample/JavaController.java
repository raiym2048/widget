package sample;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaController {
    @FXML
    private Button LogInWeather;

    @FXML
    private Button LogInCovid;

    @FXML
    private Button LogInTest;

    @FXML
    private Button LogInCurrency;

    @FXML
    private Button GoBackButton;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;

    @FXML
    private Text question_text;

    @FXML
    private Button answerBtn;

    String selectedAnswer;

    @FXML
    private Button LogInGame;

    @FXML
    ToggleGroup answer2;

    private final Questions[] questions = new Questions[] {
            new Questions("В каком из вариантов представлен корректный формат вывода информации на экран?", new String[] {"Console.Write()", "console.log()", "print()", "System.out.println()"}),
            new Questions("Какой тип данных отвечает за целые числа?", new String[] {"String", "Float", "Boolean", "Integer"}),
            new Questions("Где правильно присвоено новое значение к многомерному массиву?", new String[] {"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
            new Questions("Какой метод позволяет запустить программу на Java?", new String[] {"Основного метода нет", "С класса, что был написан первым и с методов что есть внутри него", "Любой, его можно задавать в настройках проекта", "С метода main в любом из классов"}),
            new Questions("Каждый файл должен называется...", new String[] {"по имени первой библиотеки в нём", "по имени названия пакета", "как вам захочется", "по имени класса в нём"}),
            new Questions("Сколько параметров может принимать функция?", new String[] {"5", "10", "20", "неограниченное количество"})
    };

    private int nowQuestion = 0;
    private String nowCorrectAnswer;
    int correctAnswers = 0;
    

    @FXML
    public void initialize() {
        // Берем корректный ответ для текущего вопроса
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        // Отслеживание нажатия на кнопку "Ответить"
        answerBtn.setOnAction(e -> {
            // Получаем выбранную кнопку пользователем

            ToggleGroup answers2 = answer2;
            RadioButton selectedRadioButton = (RadioButton) answers2.getSelectedToggle();
            // Код будет выполняться только если пользователь выбрал ответ
            if(selectedRadioButton != null) {

                String toogleGroupValue = selectedRadioButton.getText();

                // Сверяем ответ с корректным

                if(toogleGroupValue.equals(nowCorrectAnswer)) {
                    // Выводим информацию и увеличиваем количество верных ответов
                    System.out.println("Верный ответ");
                    correctAnswers++;
                } else
                    System.out.println("Не верный ответ");

                // Если сейчас был последний вопрос, то скрываем все поля
                if(nowQuestion + 1 == questions.length) {
                    radio_btn_1.setVisible(false); // Скрываем все поля для выбора
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false); // Скрываем кнопку ответа

                    // Показываем текст в конце
                    question_text.setText("Вы ответили корректно на " + correctAnswers + " из " + questions.length + " вопросов!");
                } else { // Если еще есть вопросы...
                    // Увеличиваем номер текущего вопроса
                    nowQuestion++;
                    // Указываем новый текст верного ответа
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    // Меняем текст вопроса в программе
                    question_text.setText(questions[nowQuestion].getQuestion());
                    // Получаем массив ответов
                    String[] answers = questions[nowQuestion].getAnswers();

                    // Преобразовываем в список (так удобнее сортировать элементы)
                    List<String> intList = Arrays.asList(answers);

                    // Сортируем в случайном порядке
                    Collections.shuffle(Collections.singletonList(Collections.singletonList(intList)));

                    // Подставляем ответы в радио кнопки
                    radio_btn_1.setText(intList.get(0));
                    radio_btn_2.setText(intList.get(1));
                    radio_btn_3.setText(intList.get(2));
                    radio_btn_4.setText(intList.get(3));

                    selectedRadioButton.setSelected(false);
                }

            }
        });
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
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        // Отслеживание нажатия на кнопку "Ответить"
        answerBtn.setOnAction(e -> {
            // Получаем выбранную кнопку пользователем

            if (radio_btn_1.isSelected()){
                System.out.println(radio_btn_1.getText().equals(nowCorrectAnswer));
                radio_btn_1.setSelected(false);
            }
            else if (radio_btn_2.isSelected()){
                correctAnswers += radio_btn_2.getText().equals(nowCorrectAnswer)?1:0;

            }
            else if (radio_btn_3.isSelected()){
                correctAnswers += radio_btn_3.getText().equals(nowCorrectAnswer)?1:0;
            }

            else if (radio_btn_4.isSelected()){
                correctAnswers +=radio_btn_4.getText().equals(nowCorrectAnswer)?1:0;
            }
            else System.out.println("Please select");


            String toogleGroupValue = selectedAnswer;

            // Сверяем ответ с корректным



            // Если сейчас был последний вопрос, то скрываем все поля
            if(nowQuestion + 1 == questions.length) {
                radio_btn_1.setVisible(false); // Скрываем все поля для выбора
                radio_btn_2.setVisible(false);
                radio_btn_3.setVisible(false);
                radio_btn_4.setVisible(false);
                answerBtn.setVisible(false); // Скрываем кнопку ответа

                // Показываем текст в конце
                question_text.setText("Вы ответили корректно на " + correctAnswers + " из " + questions.length + " вопросов!");
            } else { // Если еще есть вопросы...
                // Увеличиваем номер текущего вопроса
                nowQuestion++;
                // Указываем новый текст верного ответа
                nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                // Меняем текст вопроса в программе
                question_text.setText(questions[nowQuestion].getQuestion());
                // Получаем массив ответов
                String[] answers = questions[nowQuestion].getAnswers();

                // Преобразовываем в список (так удобнее сортировать элементы)
                List<String> intList = Arrays.asList(answers);

                // Сортируем в случайном порядке
                Collections.shuffle(intList);

                // Подставляем ответы в радио кнопки
                radio_btn_1.setText(intList.get(0));
                radio_btn_2.setText(intList.get(1));
                radio_btn_3.setText(intList.get(2));
                radio_btn_4.setText(intList.get(3));

            }


        });
    }
}
/*package sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class JavaController {


    @FXML
    private Button LogInWeather;

    @FXML
    private Button LogInCovid;

    @FXML
    private Button LogInTest;

    @FXML
    private Button LogInCurrency;

    @FXML
    private Button GoBackButton;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    ToggleGroup answer;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;

    @FXML
    private Text question_text;

    @FXML
    private Button answerBtn;

    String selectedAnswer;

    private final Questions[] questions = new Questions[] {
            new Questions("В каком из вариантов представлен корректный формат вывода информации на экран?", new String[] {"Console.Write()", "console.log()", "print()", "System.out.println()"}),
            new Questions("Какой тип данных отвечает за целые числа?", new String[] {"String", "Float", "Boolean", "Integer"}),
            new Questions("Где правильно присвоено новое значение к многомерному массиву?", new String[] {"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
            new Questions("Какой метод позволяет запустить программу на Java?", new String[] {"Основного метода нет", "С класса, что был написан первым и с методов что есть внутри него", "Любой, его можно задавать в настройках проекта", "С метода main в любом из классов"}),
            new Questions("Каждый файл должен называется...", new String[] {"по имени первой библиотеки в нём", "по имени названия пакета", "как вам захочется", "по имени класса в нём"}),
            new Questions("Сколько параметров может принимать функция?", new String[] {"5", "10", "20", "неограниченное количество"})
    };

    private int nowQuestion = 0;
    private String nowCorrectAnswer;
    int correctAnswers = 0;


    @FXML
    public void initialize() {
        // Берем корректный ответ для текущего вопроса
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        // Отслеживание нажатия на кнопку "Ответить"
        answerBtn.setOnAction(e -> {
            // Получаем выбранную кнопку пользователем

            if (radio_btn_1.isSelected()){
                System.out.println(radio_btn_1.getText().equals(nowCorrectAnswer));
                radio_btn_1.setSelected(false);
            }
            else if (radio_btn_2.isSelected()){
                correctAnswers += radio_btn_2.getText().equals(nowCorrectAnswer)?1:0;

            }
            else if (radio_btn_3.isSelected()){
                correctAnswers += radio_btn_3.getText().equals(nowCorrectAnswer)?1:0;
            }

            else if (radio_btn_4.isSelected()){
                correctAnswers +=radio_btn_4.getText().equals(nowCorrectAnswer)?1:0;
            }
            else System.out.println("Please select");


                String toogleGroupValue = selectedAnswer;

                // Сверяем ответ с корректным



                // Если сейчас был последний вопрос, то скрываем все поля
                if(nowQuestion + 1 == questions.length) {
                    radio_btn_1.setVisible(false); // Скрываем все поля для выбора
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false); // Скрываем кнопку ответа

                    // Показываем текст в конце
                    question_text.setText("Вы ответили корректно на " + correctAnswers + " из " + questions.length + " вопросов!");
                } else { // Если еще есть вопросы...
                    // Увеличиваем номер текущего вопроса
                    nowQuestion++;
                    // Указываем новый текст верного ответа
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    // Меняем текст вопроса в программе
                    question_text.setText(questions[nowQuestion].getQuestion());
                    // Получаем массив ответов
                    String[] answers = questions[nowQuestion].getAnswers();

                    // Преобразовываем в список (так удобнее сортировать элементы)
                    List<String> intList = Arrays.asList(answers);

                    // Сортируем в случайном порядке
                    Collections.shuffle(intList);

                    // Подставляем ответы в радио кнопки
                    radio_btn_1.setText(intList.get(0));
                    radio_btn_2.setText(intList.get(1));
                    radio_btn_3.setText(intList.get(2));
                    radio_btn_4.setText(intList.get(3));

                }


        });
    }

}*/