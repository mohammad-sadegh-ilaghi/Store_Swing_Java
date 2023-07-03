package org.example.Views.Components;

import javax.swing.*;

public class GetNumberComponent {
    public static int getNumbers(){
        JTextField textField = new JTextField();
        int number = 0;
        Object[] message = {
                "Please enter a value:", textField
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Input", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            // User clicked OK
            String inputValue = textField.getText();
            try {
                number = Integer.parseInt(inputValue);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "input must be number");
            }
        } else {
        }
        return number;
    }
}
