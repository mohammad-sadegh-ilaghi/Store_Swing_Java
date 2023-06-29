package org.example.Models.Behavior;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.ProductBought;

import java.io.*;
import java.util.ArrayList;

public class ProductBoughtBehavior {
    private static final Logger logger = LogManager.getLogger(FanEntitiyBehavior.class);

    private String filePath= "src/main/java/org/example/Models/Files/productBrought.ser";
    private static ProductBoughtBehavior instance;
    private ArrayList<ProductBought> coolSystemes;
    private ProductBoughtBehavior(){
        coolSystemes = read();
        if (coolSystemes == null)
            coolSystemes = new ArrayList<>();

    }
    public static ProductBoughtBehavior singleton(){
        if (instance == null)
            instance = new ProductBoughtBehavior();
        return instance;
    }
    public boolean buy(ProductBought coolSystem){
        boolean check = coolSystemes.stream().anyMatch(item -> item.equals(coolSystem));
        if (!check){
            coolSystemes.add(coolSystem);
            check = write("user bought new product", coolSystem);
        }
        else {
            for (ProductBought pro: coolSystemes) {
                if (pro.equals(coolSystem)){
                    pro.buy();
                    check=write("user add number of product", pro);
                }
            }
        }
            return check;
    }
    public boolean write(String log, ProductBought pro){
        try(FileOutputStream fileStream = new FileOutputStream(filePath)) {
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            out.writeObject(coolSystemes);
            logger.info(log + pro);
            return  true;
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            try {
                file.createNewFile();
            } catch (IOException ex) {
                logger.fatal(ex.getMessage());
            }
            write(log, pro);
            logger.info("productBrough file created.");
        } catch (Exception e) {
            logger.fatal(e.toString());
        }
        return false;
    }
    public ArrayList<ProductBought> read(){
        try(FileInputStream fansFile = new FileInputStream(filePath)){
            ObjectInputStream in = new ObjectInputStream(fansFile);
            ArrayList<ProductBought> fakefans = (ArrayList<ProductBought>) in.readObject();
            logger.info("fans from file loaded");
            return fakefans;

        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            try {
                file.createNewFile();
            } catch (IOException ex) {
                logger.fatal(ex.getMessage());
            }

            logger.info("ProductBought file created");
            return new ArrayList<>();

        } catch (Exception e) {
            logger.fatal(e);
        }
        return null;
    }

    public ArrayList<ProductBought> getCoolSystemes() {
        return coolSystemes;
    }
}
