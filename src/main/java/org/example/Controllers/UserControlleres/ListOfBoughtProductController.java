package org.example.Controllers.UserControlleres;

import org.example.Controllers.AirConditionerControlleres.ListAirConditioerController;
import org.example.Controllers.CoreController;
import org.example.Models.Behavior.ProductBoughtBehavior;
import org.example.Models.Entities.ProductBought;
import org.example.Views.CoreMiddleWare;
import org.example.Views.UserViews.ListOfBoughtProductView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListOfBoughtProductController implements CoreController {
    private ListOfBoughtProductView view;
    private ProductBoughtBehavior model;
    public ListOfBoughtProductController(){
        model = ProductBoughtBehavior.singleton();
        view = new ListOfBoughtProductView(model.getCoolSystemes());

        ActionListener search = e-> search();
        view.searchComponent.addActionListerSearch(search);
    }
    public ListOfBoughtProductController(ArrayList<ProductBought> productBoughts){
        view = new ListOfBoughtProductView(productBoughts);
        ActionListener search = e-> search();
        view.searchComponent.addActionListerSearch(search);
        view.repaint();
    }
    public void search(){
        String text = view.searchComponent.getSearch().getText();
        ArrayList<ProductBought> productBoughts = model.getProductBought(text);
        CoreMiddleWare.singelton().setPanel(new ListOfBoughtProductController(productBoughts).view.getPanel());
        CoreMiddleWare.singelton().repainAndReValidatePanel();
    }

    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
}
