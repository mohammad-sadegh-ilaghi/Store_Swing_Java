package org.example.Views.FanViews;

import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.ProductBought;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class ListFanTableModel  extends AbstractTableModel {
    ArrayList<FanEntity> fans;
    private String[] columnNames;
    public ListFanTableModel(ArrayList<FanEntity> fans){
        Field[] fields = getAllFields(FanEntity.class);
        // convert the fields to an array of field names
        columnNames = Arrays.stream(fields)
                .map(Field::getName)
                .map(item -> item.replaceAll("(\\p{Lower})(\\p{Upper})", "$1 $2"))
                .toArray(String[]::new);

        this.fans = fans;
    }

    @Override
    public int getRowCount() {
        return fans.size();
    }

    @Override
    public int getColumnCount() {
        return  columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FanEntity air = fans.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = air.getLength();
                break;
            case 1:
                value = air.getType();
                break;
            case 2:
                value = air.isHaveremoteController();
                break;
            case 3:
                value = air.getDimension();
                break;
            case 4:
                value = air.getWindVolume();
                break;
            case 5:
                value = air.getLengthOfCable();
                break;
            case 6:
                value = air.getBrand();
                break;
            case 7:
                value = air.getId();
                break;
            case 8:
                value = air.getDateOfCreated();
                break;
            case 9:
                value = air.getMade();
                break;
            case 10:
                value = air.getNumbers();
                break;
            case 11:
                value = air.getPower();
                break;
            case 12:
                value = air.isNew();
                break;
            case  13:
                value = air.getWarranty();
                break;
            case 14:
                value = air.getEnergyLabel();
                break;
            case  15:
                value = air.getWeight();
                break;
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
