package org.example.FileExports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Behavior.AirConditionerBehavior;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class ExportAllFiles {
    private static final Logger logger = LogManager.getLogger(ExportAllFiles.class);

    public static void export(){
        logger.info("export all files");
        String path = FileManagement.getPath();
        if (path.equals(""))
            return;
        ExportFileFan.exportWithoutFileChooser(path);
        ExportFileAirCondition.exportWithoutFileChooser(path);
        ExportFileWaterCooler.exportWithoutFileChooser(path);
    }
}
