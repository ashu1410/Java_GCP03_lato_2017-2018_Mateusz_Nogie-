package sample;


/**
 * Created by Ash on 29.08.2017.
 */

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.stage.*;

public class AlertBox {
    public static void display (){
        Stage alert=new Stage();
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("About");
        alert.setHeight(150);
        alert.setWidth(230);
        Label label=new Label("Author: Mateusz Nogieć");

        Button closeAlert=new Button("Ok");
        closeAlert.setOnAction(e-> alert.close());

        AnchorPane layout=new AnchorPane();
        layout.getChildren().addAll(label,closeAlert);
        layout.setTopAnchor(closeAlert,70.0);
        layout.setBottomAnchor(closeAlert,10.0);
        layout.setRightAnchor(closeAlert,80.0);
        layout.setBottomAnchor(label,50.0);
        layout.setTopAnchor(label,10.0);
        layout.setRightAnchor(label,30.0);
        Scene scene=new Scene(layout);
        alert.setScene(scene);
        alert.showAndWait();

    }
}
