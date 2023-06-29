package org.example.Controllers.FanControlleres;

import org.example.Configure.UserConfigure;
import org.example.Controllers.AirConditionerControlleres.CreateEditAirConditionerController;
import org.example.Controllers.AirConditionerControlleres.ListAirConditioerController;
import org.example.Controllers.CoreController;
import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Behavior.FanEntitiyBehavior;
import org.example.Models.Behavior.ProductBoughtBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.ProductBought;
import org.example.Models.Entities.UserEntity;
import org.example.Views.CoreMiddleWare;
import org.example.Views.FanViews.ListFanView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;

public class ListFanController implements CoreController {
    private FanEntitiyBehavior model;
    private ListFanView view;
    public ListFanController() throws IOException {
        model =FanEntitiyBehavior.singelton();
        view = new ListFanView(model.getFans());
        ActionListener deleteAction = e-> delete();
        ActionListener editAction = e -> edit();
        view.deleteActionListener(deleteAction);
        view.editActionListener(editAction);
        ActionListener actionListener = e-> buy();
        view.setBuyActionListerner(actionListener);

    }
    public void buy(){
        UserEntity user = UserConfigure.singlton().getUser();
        BigInteger id = getElement();
        FanEntity airConditioner = model.getFan(id);
        if (airConditioner.getNumbers()> 0){
            try {
                ProductBought productBought = new ProductBought(user, airConditioner);
                ProductBoughtBehavior productBoughtBehavior = ProductBoughtBehavior.singleton();
                if (productBoughtBehavior.buy(productBought))
                    model.buy(airConditioner);
                else
                    JOptionPane.showMessageDialog(null, "can not buy this product has some problem!!!");
                repaint();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else
            JOptionPane.showMessageDialog(null, "Product number is zero");
    }
    private void repaint(){
        try {
            view.setPanel(new ListFanController().view.getPanel());
            CoreMiddleWare.singelton().repainAndReValidatePanel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public BigInteger getElement() {
        JTable table = view.getTable();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            BigInteger id = new BigInteger(table.getValueAt(selectedRow, 6).toString());
            return id;
        }
        return new BigInteger("-1");
    }
    public void delete(){
            BigInteger id =  getElement();
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
    public void edit(){
            BigInteger id = getElement();
            try {
                CoreMiddleWare.singelton().setPanel(new CreateEditFanController(model.getFan(id)).getView().getPanel());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
}
