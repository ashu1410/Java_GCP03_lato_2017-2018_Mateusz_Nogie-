package sample;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;


/**
 * Created by Ash on 28.08.2017.
 */
public class CustomMenuBar extends MenuBar {
    private Menu aboutMenu = new Menu("About");
    private Menu programMenu = new Menu("Program");
    private MenuItem close= new MenuItem("Close");
    private MenuItem about= new MenuItem("About");
    private AlertBox aboutAlert = new AlertBox();


    CustomMenuBar(){
        about.setOnAction(e -> aboutAlert.display());
        close.setAccelerator(KeyCombination.keyCombination("Ctrl+c"));
        close.setOnAction((e)-> Platform.exit());
        this.programMenu.getItems().addAll(close);
        this.aboutMenu.getItems().addAll(about);
        this.getMenus().addAll(this.programMenu, this.aboutMenu);
    }

}
