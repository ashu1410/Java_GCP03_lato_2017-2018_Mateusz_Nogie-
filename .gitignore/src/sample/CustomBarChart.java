package sample;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import java.util.HashMap;
import javafx.collections.ObservableList;

/**
 * Created by Ash on 28.08.2017.
 */
public class CustomBarChart extends AnchorPane {
    private CategoryAxis catAxis = new CategoryAxis();
    private NumberAxis numAxis = new NumberAxis();
    private BarChart chart = new BarChart(catAxis, numAxis);
    private HashMap<Double, XYChart.Data<String, Integer>> values;
    private XYChart.Series<String, Integer> series = new XYChart.Series<>();

    CustomBarChart(){
        this.values = new HashMap<Double, XYChart.Data<String, Integer>>();
        this.values.put(2.0, new XYChart.Data<String, Integer>("2.0",0));
        this.values.put(2.5, new XYChart.Data<String, Integer>("2.5",0));
        this.values.put(3.0, new XYChart.Data<String, Integer>("3.0",0));
        this.values.put(3.5, new XYChart.Data<String, Integer>("3.5",0));
        this.values.put(4.0, new XYChart.Data<String, Integer>("4.0",0));
        this.values.put(4.5, new XYChart.Data<String, Integer>("4.5",0));
        this.values.put(5.0, new XYChart.Data<String, Integer>("5.0",0));

        series.setName("Marks");
        series.getData().addAll(
                this.values.get(2.0),
                this.values.get(2.5),
                this.values.get(3.0),
                this.values.get(3.5),
                this.values.get(4.0),
                this.values.get(4.5),
                this.values.get(5.0)
        );

        catAxis.setLabel("Mark");
        numAxis.setLabel("Count");
        numAxis.setLowerBound(0);
        numAxis.setTickUnit(1);
        numAxis.setAutoRanging(false);

        chart.setTitle("Distribution of Marks");
        chart.getData().addAll(series);

        this.getChildren().addAll(chart);
        this.setLeftAnchor(chart, 0.0);
        this.setRightAnchor(chart, 0.0);
    }

    public void updateChart(ObservableList<Student> studentsList){
        numAxis.setUpperBound(studentsList.size()+1);
        for (Student st :
                studentsList) {
            XYChart.Data<String, Integer> col = values.get(st.getGrade());
            Integer s = col.getYValue();
            col.setYValue(++s);
        }
    }

    public void updateAdded(Double mark){
        numAxis.setUpperBound(numAxis.getUpperBound()+1);
        XYChart.Data<String, Integer> col = values.get(mark);
        col.setYValue(col.getYValue()+1);
    }
    public void updateRemoved(Double mark){
        numAxis.setUpperBound(numAxis.getUpperBound()-1);
        XYChart.Data<String, Integer> col = values.get(mark);
        col.setYValue(col.getYValue()-1);
    }


    }

