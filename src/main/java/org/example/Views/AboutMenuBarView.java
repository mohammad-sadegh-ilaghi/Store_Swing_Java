package org.example.Views;

import javax.swing.*;
import java.awt.*;

public abstract class AboutMenuBarView {
    private static JPanel panel = new JPanel(new GridBagLayout());
    private static JLabel about = new JLabel("about ...");
    public static void getPanel(){
        JOptionPane.showMessageDialog(null, "this progarm is for store of cool system.", "about",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args){
    }
}
