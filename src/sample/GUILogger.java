
package sample;


/**
 * Created by Ash on 29.08.2017.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class GUILogger extends ListView {
    private SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");

    private ObservableList<String> logs = FXCollections.observableArrayList();
    GUILogger(){
        this.setItems(this.logs);
    }
    public void log(String status, Student st){
        this.logs.add(date.format(Calendar.getInstance().getTime()) + " [" + status + "] " + st.getName() + "" + st.getSurname() + " "+ st.getGrade() + " " + st.getAge());
    }

}

