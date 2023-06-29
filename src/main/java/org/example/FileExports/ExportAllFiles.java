package org.example.FileExports;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class ExportAllFiles {
    public static void export(){
        String path = FileManagement.getPath();
        ExportFileFan.exportWithoutFileChooser(path);
        ExportFileAirCondition.exportWithoutFileChooser(path);
        ExportFileWaterCooler.exportWithoutFileChooser(path);
    }
}
