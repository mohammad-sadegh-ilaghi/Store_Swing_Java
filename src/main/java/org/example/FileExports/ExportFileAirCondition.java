package org.example.FileExports;

import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.ProductBought;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class ExportFileAirCondition {
    public static void exportWithoutFileChooser(String path){
        ArrayList<AirConditionerEntity> airConditionerEntities =null;

        Random random = new Random();
        Path path1 = Paths.get(path, Integer.toString(random.nextInt(10000)) + "_AirConditioner.txt");
        File file = new File(path1.toString());
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            airConditionerEntities = AirConditionerBehavior.singelton().getAirConditioneres();
        } catch (IOException e) {

        }
        write(airConditionerEntities,path1.toString());
    }
    public static void export(){
        String path = FileManagement.getPath();

        exportWithoutFileChooser(path);
    }
    private static void write(ArrayList<AirConditionerEntity> airConditionerEntities,String filePath){
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (AirConditionerEntity air: airConditionerEntities) {
                writer.println(air);
            }
        } catch (IOException e) {
        }
    }
}
