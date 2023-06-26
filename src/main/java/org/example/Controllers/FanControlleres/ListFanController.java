package org.example.Controllers.FanControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.FanEntitiyBehavior;
import org.example.Views.FanViews.ListFanView;

import javax.swing.*;
import java.io.IOException;

public class ListFanController implements CoreController {
    private FanEntitiyBehavior model;
    private ListFanView view;
    public ListFanController() throws IOException {
        model =FanEntitiyBehavior.singelton();
        view = new ListFanView();
    }
    @Override
    public JPanel getPanel() {
        return null;
    }
}
