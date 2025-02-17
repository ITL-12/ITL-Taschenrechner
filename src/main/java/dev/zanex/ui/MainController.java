package dev.zanex.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class MainController {

    @FXML
    private Label calcDisplay;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @FXML
    private void processNumber(javafx.event.ActionEvent event) {
        if (start) {
            calcDisplay.setText("");
            start = false;
        }

        String value = ((Button) event.getSource()).getText();
        calcDisplay.setText(calcDisplay.getText() + value);
    }

    @FXML
    private void processOperator(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty()) {
                return;
            }

            operator = value;
            num1 = Double.parseDouble(calcDisplay.getText());
            calcDisplay.setText(calcDisplay.getText() + " " + operator + " ");
        } else {
            if (operator.isEmpty()) {
                return;
            }

            String[] parts = calcDisplay.getText().split(" ");
            double num2 = Double.parseDouble(parts[2]);
            double output = calculate(num1, num2, operator);

            calcDisplay.setText(decimalFormat.format(output));
            operator = "";
            start = true;
        }
    }

    private double calculate(double num1, double num2, String operator) {
        return switch(operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    yield 0;
                }
                yield num1 / num2;
            }
            default -> 0;
        };
    }
}