package org.example.FileExports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Behavior.FanEntitiyBehavior;
import org.example.Models.Behavior.ProductBoughtBehavior;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.ProductBought;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class ExportFileFan {
    private static final Logger logger = LogManager.getLogger(ExportFileFan.class);
    public static void exportWithoutFileChooser(String path){
        Random random = new Random();
        Path path1 = Paths.get(path, Integer.toString(random.nextInt(10000)) + "_Fans.txt");
        File file = new File(path1.toString());
        logger.info("Export file " + path1);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<FanEntity> fans =null;
        try {
            fans = FanEntitiyBehavior.singelton().getFans();
        } catch (Exception e) {

        }
        write(fans,path1.toString());
    }
    public static void export(){
        String path = FileManagement.getPath();
        exportWithoutFileChooser(path);
    }
    private static void write(ArrayList<FanEntity> fans,String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (FanEntity fan: fans) {
                writer.println(fan);
            }
        } catch (IOException e) {
        }
    }
}
