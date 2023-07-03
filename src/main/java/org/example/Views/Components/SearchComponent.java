package org.example.Views.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchComponent {
    //<editor-fold defaultstate="collapsed" desc="search">
    private JPanel panel = new JPanel(new FlowLayout());
    JTextField searchText = new JTextField(10);
    JButton searchButton = new JButton("Search");
    //</editor-fold>

    public SearchComponent(){
        JPanel searchTextPanel = new JPanel();
        searchText.setSize(new Dimension(50, 15));
        searchTextPanel.add(searchText);
        panel.add(searchTextPanel);

        JPanel searchButtonPanel = new JPanel();
        searchButton.setSize(new Dimension(30, 30));
        searchButtonPanel.add(searchButton);
        searchButtonPanel.add(searchButton);
        panel.add(searchButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void addActionListerSearch(ActionListener actionListener){
        searchButton.addActionListener(actionListener);
    }

    public JTextField getSearch() {
        return searchText;
    }

    public void setSearch(String search) {
        this.searchText.setText(search);
    }

}
