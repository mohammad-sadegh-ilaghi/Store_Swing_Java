package org.example.Controllers.AirConditionerControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Views.AirConditionerViews.ListOfAirConditionerView;
import org.example.Views.CoreMiddleWare;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;

public class ListAirConditioerController implements CoreController {
    private AirConditionerBehavior model;
    private ListOfAirConditionerView view;
    public ListAirConditioerController() throws IOException {
        model= AirConditionerBehavior.singelton();
        view = new ListOfAirConditionerView();
        ActionListener deleteAction = e -> delete();
        ActionListener editAction = e-> edit();
        view.setDeleteActionListerer(deleteAction);
        view.setEditActionListerer(editAction);
    }
    private void repaint(){
        try {
            CoreMiddleWare.singelton().setPanel(new ListAirConditioerController().view.getPanel());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void  delete(){
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

    public void edit(){
        JTable table = view.getTable();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            BigInteger id = new BigInteger(table.getValueAt(selectedRow, 6).toString());
            System.out.println(id);
            try {
                CoreMiddleWare.singelton().setPanel(new CreateEditAirConditionerController(model.getAirConditioner(id)).view.getPanel());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
}
