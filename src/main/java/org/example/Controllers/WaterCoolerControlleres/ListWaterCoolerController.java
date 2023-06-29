package org.example.Controllers.WaterCoolerControlleres;

import org.example.Configure.UserConfigure;
import org.example.Controllers.CoreController;
import org.example.Controllers.FanControlleres.CreateEditFanController;
import org.example.Controllers.FanControlleres.ListFanController;
import org.example.Models.Behavior.ProductBoughtBehavior;
import org.example.Models.Behavior.WaterCoolerBehavior;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.ProductBought;
import org.example.Models.Entities.UserEntity;
import org.example.Models.Entities.WaterCoolerEntity;
import org.example.Views.CoreMiddleWare;
import org.example.Views.WaterCoolViews.ListWaterCoolView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class ListWaterCoolerController implements CoreController {
    ListWaterCoolView view;
    WaterCoolerBehavior model;
    public ListWaterCoolerController() throws IOException {
        model = WaterCoolerBehavior.singelton();
        view = new ListWaterCoolView(model.getWatercooleres());
        ActionListener deleteAction = e-> delete();
        ActionListener editAction = e -> edit();
        view.deleteActionListener(deleteAction);
        view.editActionListener(editAction);
        ActionListener actionListener = e -> buy();
        view.setBuyActionListener(actionListener);
    }
    public void buy(){
        UserEntity user = UserConfigure.singlton().getUser();
        BigInteger id = getElement();
        WaterCoolerEntity airConditioner = model.getWatercooler(id);
        if (airConditioner.getNumbers()> 0){
            try {
                ProductBought productBought = new ProductBought(user, airConditioner);
                ProductBoughtBehavior productBoughtBehavior = ProductBoughtBehavior.singleton();
                if (productBoughtBehavior.buy(productBought))
                    model.buy(airConditioner);
                else
                    JOptionPane.showMessageDialog(null, "can not buy this product has some problem!!!");
                repaint();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else
            JOptionPane.showMessageDialog(null, "Product number is zero");
    }
    public BigInteger getElement(){
        JTable table = view.getTable();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            BigInteger id = new BigInteger(table.getValueAt(selectedRow, 6).toString());
            return id;
        }
        return new BigInteger("-1");
    }
    private void repaint(){
        try {
            view.setPanel(new ListWaterCoolerController().view.getPanel());
            CoreMiddleWare.singelton().repainAndReValidatePanel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void edit(){
        BigInteger id = getElement();
        try {
            CoreMiddleWare.singelton().setPanel(new CreateEditWaterCoolerController(model.getWatercooler(id)).getPanel());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(){
        JTable table = view.getTable();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            BigInteger id = new BigInteger(table.getValueAt(selectedRow, 6).toString());
            System.out.println(id);
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
    }

    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
}
