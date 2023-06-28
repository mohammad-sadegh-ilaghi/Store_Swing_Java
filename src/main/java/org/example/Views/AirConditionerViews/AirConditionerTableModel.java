package org.example.Views.AirConditionerViews;

import org.example.Models.Entities.AirConditionerEntity;
import java.lang.reflect.Field;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;

public class AirConditionerTableModel extends AbstractTableModel {
    ArrayList<AirConditionerEntity> airConditionerEntities;
    private String[] columnNames;
    public AirConditionerTableModel(ArrayList<AirConditionerEntity> airConditionerEntities){
        Field[] fields = getAllFields(AirConditionerEntity.class);
        // convert the fields to an array of field names
        columnNames = Arrays.stream(fields)
                .map(Field::getName)
                .map(item -> item.replaceAll("(\\p{Lower})(\\p{Upper})", "$1 $2"))
                .toArray(String[]::new);

        this.airConditionerEntities = airConditionerEntities;
    }

    @Override
    public int getRowCount() {
        return airConditionerEntities.size();
    }

    @Override
    public int getColumnCount() {
        return  columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AirConditionerEntity air = airConditionerEntities.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = air.getTheOutputIsTwoWay();
                break;
            case 1:
                value = air.getCoolingCapacityBTUh();
                break;
            case 2:
                value = air.getCoolingCapacityKw();
                break;
            case 3:
                value = air.getHeatingCapacityBTUh();
                break;
            case 4:
                value = air.getThreeRowCoil();
                break;
            case 5:
                value = air.getBrand();
                break;
            case 6:
                value = air.getId();
                break;
            case 7:
                value = air.getDateOfCreated();
                break;
            case 8:
                value = air.getMade();
                break;
            case 9:
                value = air.getNumbers();
                break;
            case 10:
                value = air.getPower();
                break;
            case 11:
                value = air.isNew();
                break;
            case  12:
                value = air.getWarranty();
                break;
            case 13:
                value = air.getEnergyLabel();
                break;
            case  14:
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
