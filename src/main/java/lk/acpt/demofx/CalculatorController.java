package lk.acpt.demofx;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {
    String operation;

    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;

    @FXML
    private Label lblAnswer;


    @FXML
    void addition(ActionEvent event) {
        operation="add";
    }

    @FXML
    void devide(ActionEvent event) {
        operation = "devi";
    }

    @FXML
    void getAnswer(ActionEvent event) {
        int num1 = Integer.parseInt(txtNum1.getText());
        int num2 = Integer.parseInt(txtNum2.getText());

        switch (operation){
            case "add":
                lblAnswer.setText(String.valueOf(num1+num2));
                break;
            case "sub":
                lblAnswer.setText(String.valueOf(num1-num2));
                break;
            case "mul":
                lblAnswer.setText(String.valueOf(num1*num2));
                break;
            case "devi":
                lblAnswer.setText(String.valueOf(num1/num2));
                break;
        }
    }

    @FXML
    void multiplication(ActionEvent event) {
        operation="mul";
    }

    @FXML
    void substraction(ActionEvent event) {
        operation="sub";
    }

}
