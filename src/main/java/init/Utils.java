package init;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class Utils {
    private static final Logger logger = Logger.getLogger(Utils.class.getName());
    protected static String path;
    protected static String filename;
    protected static File file;
    protected static void createNewFile() {
        file = new File(path);
        try {
            if (file.createNewFile()) {
                logger.info(filename + " created: " + file.getName());
            } else {
                deleteFile();
            }
        } catch (IOException e) {
            logger.info("An error occurred. " + e.getMessage());
        }
    }

    protected static void writeln(String str) {
        try {
            FileWriter writer = new FileWriter(Utils.file, true);
            writer.write(str+ "\n");
            writer.close();
        } catch (IOException e) {
            logger.info("An error occurred while creating the file: " + e.getMessage());
        }
    }
    protected static void writeln() {
        try {
            FileWriter writer = new FileWriter(Utils.file, true);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            logger.info("An error occurred while creating the file: " + e.getMessage());
        }
    }
    protected static void write(String str) {
        try {
            FileWriter writer = new FileWriter(Utils.file, true);
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            logger.info("An error occurred while creating the file: " + e.getMessage());
        }
    }

    private static void deleteFile() {
        if (file.exists()) {
            if (file.delete()) {
                logger.info(filename + " deleted: " + file.getName());
            } else {
                logger.info("Failed to delete " + filename);
            }
        } else {
            logger.info(filename + " does not exist.");
        }
    }
}
