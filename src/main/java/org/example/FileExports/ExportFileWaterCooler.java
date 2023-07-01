package org.example.FileExports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Behavior.FanEntitiyBehavior;
import org.example.Models.Behavior.WaterCoolerBehavior;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.ProductBought;
import org.example.Models.Entities.WaterCoolerEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class ExportFileWaterCooler {
    private static final Logger logger = LogManager.getLogger(ExportFileWaterCooler.class);

    public static void exportWithoutFileChooser(String path){

        Random random = new Random();
        Path path1 = Paths.get(path, Integer.toString(random.nextInt(10000)) + "_WaterCooler.txt");
        File file = new File(path1.toString());
        logger.info("Export file " + path1);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<WaterCoolerEntity> waterCooler =null;
        try {
            waterCooler = WaterCoolerBehavior.singelton().getWatercooleres();
        } catch (Exception e) {

        }
        write(waterCooler,path1.toString());
    }
    public static void export(){
        String path = FileManagement.getPath();
        exportWithoutFileChooser(path);
    }
    private static void write(ArrayList<WaterCoolerEntity> waterCoolerEntities,String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (WaterCoolerEntity waterCooler: waterCoolerEntities) {
                writer.println(waterCooler);
            }
        } catch (IOException e) {
        }
    }
}
