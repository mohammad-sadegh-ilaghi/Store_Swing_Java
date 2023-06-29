package org.example.Views.FanViews;

import org.example.Configure.UserConfigure;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Rules.RulesUser;
import org.example.Views.AirConditionerViews.AirConditionerTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListFanView {
    JPanel panel;
    ListFanTableModel fanTableModel = null;
    ArrayList<FanEntity> fans = null;
    JButton edit = new JButton("Edit");
    JButton delete = new JButton("Delete");
    JButton buy = new JButton("Buy");

    JTable table;

    public ListFanView(ArrayList<FanEntity> fans){
        panel = new JPanel(new BorderLayout());
        this.fans = fans;
        fanTableModel = new ListFanTableModel(fans);
        table = new JTable(fanTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        if (UserConfigure.singlton().getUser().getUserRule().equals(RulesUser.ADMIN)){
            buttonsPanel.add(delete);
            buttonsPanel.add(edit);
            panel.add(buttonsPanel, BorderLayout.SOUTH);
        }
        else {
            panel.add(buy, BorderLayout.SOUTH);
        }



    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setBuyActionListerner(ActionListener actionListener){
        buy.addActionListener(actionListener);
    }

    public JButton getBuy() {
        return buy;
    }

    public void setBuy(JButton buy) {
        this.buy = buy;
    }

    public void editActionListener(ActionListener edit) {
        this.edit.addActionListener(edit);
    }

    public void deleteActionListener(ActionListener delete) {
        this.delete.addActionListener(delete);
    }

    public JPanel getPanel(){
        return panel;
    }

    public JTable getTable() {
        return table;
    }
}
