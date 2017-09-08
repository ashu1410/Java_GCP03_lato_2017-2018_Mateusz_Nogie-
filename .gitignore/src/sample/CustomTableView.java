package sample;


/**
 * Created by Ash on 28.08.2017.
 */
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class CustomTableView extends AnchorPane {
    private TableView table;
    private TableColumn GradeColumn;
    private TableColumn NameColumn;
    private TableColumn surNameColumn;
    private TableColumn ageColumn;
    ObservableList<Student> studentsList;
    CustomTableView(ObservableList<Student> list){
        this.studentsList = list;
        table = new TableView();
        GradeColumn = new TableColumn("Grade");
        NameColumn = new TableColumn("Name");
        surNameColumn = new TableColumn("Surname");
        ageColumn = new TableColumn("Age");

        GradeColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Grade"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Name"));
        surNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Surname"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Age"));

        GradeColumn.setMinWidth(100);
        NameColumn.setMinWidth(100);
        surNameColumn.setMinWidth(100);
        ageColumn.setMinWidth(100);

        table.getColumns().addAll(GradeColumn, NameColumn, surNameColumn, ageColumn);
        this.setTopAnchor(table, 0.0);
        this.setLeftAnchor(table, 0.0);
        this.setRightAnchor(table, 0.0);

        table.setItems(this.studentsList);

        this.getChildren().addAll(table);

    }
}