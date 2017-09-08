package sample;

import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;


/**
 * Created by Ash on 28.08.2017.
 */
public class CustomTabPane extends TabPane {
    private Tab logTab = new Tab("Log");
    private Tab studentsTab=new Tab("Students");
    private Tab histoTab=new Tab("Histogram");

    private CustomBarChart chart;

    private ObservableList<Student> studentsList;
    private CustomTableView studentsTable;



    CustomTabPane(Double height, ObservableList<Student> stList){
        GUILogger logger= new GUILogger();
        this.studentsList = stList;
        this.chart = new CustomBarChart();

        this.studentsList.addListener((ListChangeListener<Student>)e->{
            while(e.next()){
                if(e.wasAdded()){
                    for (Student st :
                            e.getAddedSubList()) {
                        logger.log("NEW", st);
                        chart.updateAdded(st.getGrade());
                    }
                }

                if(e.wasRemoved()){
                    for (Student st :
                            e.getRemoved()) {
                        logger.log("REMOVED", st);
                        chart.updateRemoved(st.getGrade());
                    }
                }
            }
        });

        this.setHeight(height-30.0);

        this.studentsTable = new CustomTableView(this.studentsList);

        this.chart.updateChart(this.studentsList);

        this.studentsTab.setContent(studentsTable);
        this.logTab.setContent(logger);
        this.histoTab.setContent(chart);
        this.getTabs().addAll(studentsTab, logTab, histoTab);
    }



    public void removeStudent(){
        if(!this.studentsList.isEmpty())
            this.studentsList.remove(this.studentsList.size()-1);
    }

    public void addStudent(Student st){
        this.studentsList.add(st);
    }

}
