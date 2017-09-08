package sample;

/**
 * Created by Ash on 03.09.2017.
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.List;


public class RegisterController {

    @FXML TextField fName;
    @FXML TextField fPassword;
    @FXML TextField fAge;
    @FXML TextField fGender;
    @FXML TextField fAddress;

    LoginController lo = null;
    User user = new User();


    List<User> usersList;
    public void setUsersList(List<User> us){
        this.usersList = us;
    }

    @FXML public void doSave(){
        int error=0;
        if(user.getfName().length() == 0) error++;
        if(user.getfAge().length() == 0) error++;
        if(user.getfGender().length() == 0) error++;
        if(user.getfPassword().length() == 0) error++;
        if(user.getfAddress().length() == 0) error++;
        if(error==0) {
            this.usersList.add(user);
            Alert registered=new Alert(Alert.AlertType.INFORMATION);
            registered.setTitle("Success");
            registered.setContentText("Registration went correct");
            registered.showAndWait();
        }
        else{
        Alert notRegistered=new Alert(Alert.AlertType.ERROR);
        notRegistered.setTitle("Error");
        notRegistered.setContentText("Something went wrong");
        notRegistered.showAndWait();}

    }
    @FXML public void doClear(){
        fName.setText("");
        fPassword.setText("");
        fAge.setText("");
        fGender.setText("");
        fAddress.setText("");
    }

    @FXML public void doCancel(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(LoginController lo){
        this.lo = lo;
        user.fNameProperty().bind(fName.textProperty());
        user.fPasswordProperty().bind(fPassword.textProperty());
        user.fAgeProperty().bind(fAge.textProperty());
        user.fGenderProperty().bind(fGender.textProperty());
        user.fAddressProperty().bind(fAddress.textProperty());


    }


}