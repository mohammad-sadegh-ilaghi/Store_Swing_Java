package org.example.Views;

import javax.swing.*;
import java.awt.*;

public abstract class AboutMenuBarView {
    private static JPanel panel = new JPanel(new GridBagLayout());
    private static JLabel about = new JLabel("about ...");
    public static JPanel getPanel(){
        about.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(about,gbc);
        return panel;
    }
    public static void main(String[] args){
    }
}
