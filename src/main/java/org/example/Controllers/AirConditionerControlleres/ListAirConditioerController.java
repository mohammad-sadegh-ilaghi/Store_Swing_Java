package org.example.Controllers.AirConditionerControlleres;

import org.apache.logging.log4j.core.Core;
import org.example.Configure.UserConfigure;
import org.example.Controllers.CoreController;
import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Behavior.ProductBoughtBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.ProductBought;
import org.example.Models.Entities.UserEntity;
import org.example.Views.AirConditionerViews.ListOfAirConditionerView;
import org.example.Views.Components.GetNumberComponent;
import org.example.Views.CoreMiddleWare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class ListAirConditioerController implements CoreController {
    private AirConditionerBehavior model;
    private ListOfAirConditionerView view;
    public ListAirConditioerController() throws IOException {
        model= AirConditionerBehavior.singelton();
        view = new ListOfAirConditionerView(AirConditionerBehavior.singelton().getAirConditioneres());
        inintial();
    }
    public void inintial(){
        ActionListener deleteAction = e -> delete();
        ActionListener editAction = e-> edit();
        view.setDeleteActionListerer(deleteAction);
        view.setEditActionListerer(editAction);
        ActionListener buy = e -> buy();
        view.setBuyActionListener(buy);

        ActionListener search = e-> search();
        view.searchComponent.addActionListerSearch(search);
    }

    public ListAirConditioerController(ArrayList<AirConditionerEntity> airConditionerEntities) throws IOException {
        model= AirConditionerBehavior.singelton();
        view = new ListOfAirConditionerView(airConditionerEntities);
        inintial();
    }
    public void search(){
        String text = view.searchComponent.getSearch().getText();
        ArrayList<AirConditionerEntity> airConditionerEntities = model.getAirConditioneres(text);
        repaint(airConditionerEntities);

    }
    public void buy(){
        UserEntity user = UserConfigure.singlton().getUser();
        BigInteger id = getElement();
        AirConditionerEntity airConditioner = model.getAirConditioner(id);
        if (airConditioner.getNumbers()> 0){
            try {
                int number = 0;

                ProductBought productBought = new ProductBought(user, airConditioner);
                ProductBoughtBehavior productBoughtBehavior = ProductBoughtBehavior.singleton();
                if (productBoughtBehavior.buy(productBought)){
                    number = GetNumberComponent.getNumbers();
                    if (number == 0)
                        return;
                    if (model.buy(airConditioner, number))
                        repaint();
                    else
                        JOptionPane.showMessageDialog(null, "this number of Product is not exist");
                }
                else
                    JOptionPane.showMessageDialog(null, "can not buy this product has some problem!!!");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void repaint(ArrayList<AirConditionerEntity> airConditionerEntities){
        try {
            CoreMiddleWare.singelton().setPanel(new ListAirConditioerController(airConditionerEntities).view.getPanel());
            CoreMiddleWare.singelton().repainAndReValidatePanel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void repaint(){
        try {
            view.setPanel(new ListAirConditioerController().view.getPanel());
            view.getPanel().revalidate();
            view.getPanel().repaint();
            CoreMiddleWare.singelton().repainAndReValidatePanel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void  delete(){
            BigInteger id = getElement();
            int outPut = JOptionPane.showOptionDialog(null, "Are you sure to Delete?", "Confirmation",
                                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                            new Object[]{"Yes", "No"},"Yes");
            if (outPut == 0){
                boolean result = model.remove(id);
                if (result){
                    repaint();
                }
            }


    }
    private BigInteger getElement() {
        JTable table = view.getTable();

        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            BigInteger id = new BigInteger(table.getValueAt(selectedRow, 6).toString());
            return id;

        }
        return new BigInteger("-1");
    }


    public void edit(){
        BigInteger id = getElement();
            try {
                CoreMiddleWare.singelton().setPanel(new CreateEditAirConditionerController(model.getAirConditioner(id)).view.getPanel());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }

}
