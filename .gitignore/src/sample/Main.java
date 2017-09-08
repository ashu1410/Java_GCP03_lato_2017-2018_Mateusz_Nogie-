package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.collections.ObservableList;
import java.io.File;
import java.net.URL;


public class Main extends Application {

    private ObservableList<Student> studentsList;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.studentsList = FXCollections.observableArrayList(StudentsParser.parse(new URL("http://home.agh.edu.pl/~ggorecki/IS_Java/students.txt")));

        primaryStage.setTitle("Crawler GUI");
        primaryStage.setResizable(true);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);



        AnchorPane menuPane= new AnchorPane();
        menuPane.setMinWidth(primaryStage.getWidth());
        menuPane.setMinHeight(primaryStage.getHeight());
        Scene scene= new Scene(menuPane,primaryStage.getWidth(),primaryStage.getHeight(),Color.WHITE);


        CustomMenuBar menuBar = new CustomMenuBar();
        CustomTabPane tabPane = new CustomTabPane(primaryStage.getHeight()-menuBar.getHeight()- 20, this.studentsList);


        Button addStudentButton=new Button();
        addStudentButton.setText("Add Student");
        addStudentButton.setOnAction(e->tabPane.addStudent(new Student("Mateusz","Nogieć",4,21)));

        Button removeStudentButton=new Button();
        removeStudentButton.setText("Remove Student");
        removeStudentButton.setOnAction(e->tabPane.removeStudent());


        HBox buttons = new HBox();
        buttons.setMinWidth(200);
        buttons.getChildren().addAll(addStudentButton, removeStudentButton);

        menuPane.getChildren().addAll(menuBar,tabPane,buttons);

        menuPane.setTopAnchor(tabPane, 30.0);
        menuPane.setBottomAnchor(tabPane, 30.0);
        menuPane.setLeftAnchor(tabPane, 0.0);
        menuPane.setRightAnchor(tabPane, 0.0);


        menuPane.setTopAnchor(menuBar,0.0);
        menuPane.setLeftAnchor(menuBar, 0.0);
        menuPane.setRightAnchor(menuBar, 0.0);


        menuPane.setBottomAnchor(buttons, 0.0);
        menuPane.setLeftAnchor(buttons, 0.0);
        menuPane.setRightAnchor(buttons, 0.0);


        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
