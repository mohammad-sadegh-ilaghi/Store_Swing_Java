package org.example.Models.Entities;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class FieldsEntity {
    public static Field[] getAllFields(Class<?> clazz) {
        ArrayList<Field> fields = new ArrayList<Field>();
        Class<?> currentClass = clazz;
        while (currentClass != null) {
            fields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
            currentClass = currentClass.getSuperclass();
        }
        return fields.toArray(new Field[0]);
    }
}
