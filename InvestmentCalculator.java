package Project5;


import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Brandon Lewis
 *
 */
public class InvestmentCalculator extends Application {
    @Override
    /*
     * (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    public void start(Stage myStage) {

        myStage.setTitle("Excercise16_5");

        GridPane gridPane = new GridPane();

        Scene scene = new Scene(gridPane, 300, 200);

        gridPane.add(new Label("Investment Amount"), 0, 0);
        TextField investmentAmount = new TextField();
        gridPane.add(investmentAmount, 1, 0);
        
        gridPane.add(new Label("Years"), 0, 1);
        TextField years = new TextField();
        gridPane.add(years, 1, 1);
       
        gridPane.add(new Label("Annual Interest Rate"), 0, 2);
        TextField annualInterestRate = new TextField();
        gridPane.add(annualInterestRate, 1, 2);
        
        gridPane.add(new Label("FutureValue"), 0, 3);
        TextField futureValue = new TextField();
        futureValue.setEditable(false);
        gridPane.add(futureValue, 1, 3);
        
        
        Button button = new Button("Calculate");
        gridPane.add(button, 1, 4);
        
        button.setOnAction(e ->{
            Double v1 = Double.valueOf(investmentAmount.getText());
            Integer v2 = Integer.valueOf(years.getText());
            Double v3 = Double.valueOf(annualInterestRate.getText());
            Double total = v1 * Math.pow(1 + (v3/(100*12)), v2 * 12);
            DecimalFormat df = new DecimalFormat("#.##");
            futureValue.setText(df.format(total));
        });

        myStage.setScene(scene);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}