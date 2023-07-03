package org.example.Views.UserViews;

import org.example.Configure.UserConfigure;
import org.example.Controllers.UserControlleres.ProductBoughtModelTable;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.ProductBought;
import org.example.Rules.RulesUser;
import org.example.Views.Components.SearchComponent;
import org.example.Views.FanViews.ListFanTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListOfBoughtProductView {
    JPanel panel;

    public SearchComponent searchComponent = new SearchComponent();

    ProductBoughtModelTable fanTableModel = null;

    ArrayList<ProductBought> productBoughts = null;

    JTable table;
    public ListOfBoughtProductView(ArrayList<ProductBought> productBoughts){
        panel = new JPanel(new BorderLayout());
        this.productBoughts = productBoughts;
        fanTableModel = new ProductBoughtModelTable(productBoughts);
        table = new JTable(fanTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        panel.add(searchComponent.getPanel(), BorderLayout.NORTH);

    }
    public void repaint(){
        panel.revalidate();
        panel.repaint();
    }
    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
