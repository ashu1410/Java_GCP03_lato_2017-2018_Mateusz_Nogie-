package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;


    public class MainController {

        @FXML

        private TablesController tabsController;
        @FXML
        private TabPane tabs;


        @FXML
        public void initialize(){

        }

        public void addStudent(){
            tabsController.addStudent();
        }
        public void removeStudent(){ tabsController.removeStudent(); }

        @FXML
        private void closeProgram(){
            Platform.exit();
        }

        @FXML
        private void about(){
            AlertBox alert=new AlertBox();
            alert.display();
        }
    }

