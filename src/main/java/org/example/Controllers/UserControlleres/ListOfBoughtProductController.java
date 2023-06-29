package org.example.Controllers.UserControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.ProductBoughtBehavior;
import org.example.Views.UserViews.ListOfBoughtProductView;

import javax.swing.*;

public class ListOfBoughtProductController implements CoreController {
    private ListOfBoughtProductView view;
    private ProductBoughtBehavior model;
    public ListOfBoughtProductController(){
        model = ProductBoughtBehavior.singleton();
        view = new ListOfBoughtProductView(model.getCoolSystemes());
    }


    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
}
