package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a JTable with sample data
        String[] columnNames = {"Name", "Age", "Email"};
        Object[][] data = {
                {"John", 30, "john@example.com"},
                {"Jane", 25, "jane@example.com"},
                {"Bob", 40, "bob@example.com"},
                {"Alice", 35, "alice@example.com"}
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        // create a button and add an ActionListener to it
        JButton button = new JButton("View Details");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String name = table.getValueAt(selectedRow, 0).toString();
                    int age = Integer.parseInt(table.getValueAt(selectedRow, 1).toString());
                    String email = table.getValueAt(selectedRow, 2).toString();
                    System.out.println("Name: " + name + ", Age: " + age + ", Email: " + email);
                }
            }
        });

        // add the table and the button to the frame
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}