package org.example.Controllers.UserControlleres;

import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.ProductBought;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductBoughtModelTable extends AbstractTableModel {
    ArrayList<ProductBought> productBoughtes;
    private String[] columnNames;
    public ProductBoughtModelTable(ArrayList<ProductBought> productBoughts){
        Field[] fields = getAllFields(FanEntity.class);
        // convert the fields to an array of field names
        columnNames = new String[]{"UserName", "Id_Product", "Numbers"};

        this.productBoughtes = productBoughts;
    }

    @Override
    public int getRowCount() {
        return productBoughtes.size();
    }

    @Override
    public int getColumnCount() {
        return  columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductBought air = productBoughtes.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = air.getUser().getUserName();
                break;
            case 1:
                value = air.getCoolSystem().getId();
                break;
            case 2:
                value = air.getNumbers();
        }
        return value;
    }
    public static Field[] getAllFields(Class<?> clazz) {
        ArrayList<Field> fields = new ArrayList<Field>();
        Class<?> currentClass = clazz;
        while (currentClass != null) {
            fields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
            currentClass = currentClass.getSuperclass();
        }
        return fields.toArray(new Field[0]);
    }
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

}
