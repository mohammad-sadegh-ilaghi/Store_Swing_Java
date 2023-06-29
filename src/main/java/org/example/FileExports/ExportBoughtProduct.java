package org.example.FileExports;

import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Behavior.ProductBoughtBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.ProductBought;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class ExportBoughtProduct {
    public static void exportWithoutFileChooser(String path){

        Random random = new Random();
        Path path1 = Paths.get(path, Integer.toString(random.nextInt(10000)) + "_BoughtProduct.txt");
        File file = new File(path1.toString());
        try {
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<ProductBought> boughtProduct =null;
        try {
            boughtProduct = ProductBoughtBehavior.singleton().getCoolSystemes();
        } catch (Exception e) {

        }
        write(boughtProduct,path1.toString());
    }
    public static void export(){
        String path= FileManagement.getPath();
        exportWithoutFileChooser(path);
    }
    private static void write(ArrayList<ProductBought> productBoughts,String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (ProductBought pr: productBoughts) {
                writer.println(pr);
            }
        } catch (IOException e) {
        }
    }
}
