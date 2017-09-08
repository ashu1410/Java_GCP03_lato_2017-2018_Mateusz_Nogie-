package sample;

/**
 * Created by Ash on 03.09.2017.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private List<User> usersList = new ArrayList<>();

    private RegisterController registerController;


    @FXML
    TextField txtLogin;
    @FXML
    PasswordField txtPassword;

    @FXML
    Button btnLogin;

    @FXML
    Button register;

    public void addUser(User u){
        this.usersList.add(u);
    }

    @FXML
    private void CheckLogin(ActionEvent e) {
        boolean logged = false;
        for (User user :
                this.usersList) {
            if (txtLogin.getText().compareTo(user.getfName()) == 0 && txtPassword.getText().compareTo(user.getfPassword()) == 0) {
                logged = true;
                Alert loggedAlert = new Alert(Alert.AlertType.INFORMATION);
                loggedAlert.setTitle("Gut gut");
                loggedAlert.setContentText("You logged in");
                loggedAlert.showAndWait();
                break;
            }
        }

        if(logged){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                showStack(ex);
            }
        } else {
            Alert loginAlert = new Alert(Alert.AlertType.ERROR);
            loginAlert.setTitle("Error");
            loginAlert.setContentText("Incorrect login or password.");
            loginAlert.showAndWait();
        }
    }

    @FXML
    private void ShowRegister(ActionEvent e) {

        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "register.fxml"
                    )
            );
            stage.setTitle("Registration");

            stage.setScene(new Scene(loader.load()));
            registerController = loader.getController();
            registerController.initialize(this);
            registerController.setUsersList(usersList);
            stage.show();
        } catch (IOException ex) {
            showStack(ex);
        }
    }


    private void showStack(IOException ex){
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        printWriter.flush();

        String stackTrace = writer.toString();
        System.out.print(stackTrace);
    }

    @FXML
    private void initialize(){
        System.out.print("init");
    }



}