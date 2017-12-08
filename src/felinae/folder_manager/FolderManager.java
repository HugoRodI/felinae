package felinae.folder_manager;

import java.io.File;

public class FolderManager {
    private String targetDataFolderPath;
    private String webcamImageFolderPath;
    private String screenImageFolderPath;
    private String keystrokesFolderPath;
    
    public FolderManager() { };
    
    public FolderManager(String pathToTargetDataFolder,
                         String targetDataFolderName, 
                         String webcamImageFolderName, 
                         String screenImageFolderName,
                         String keystrokesFolderName) {
        
        this.targetDataFolderPath = pathToTargetDataFolder + targetDataFolderName;
        this.webcamImageFolderPath = targetDataFolderPath + webcamImageFolderName;
        this.screenImageFolderPath = targetDataFolderPath + screenImageFolderName;
        this.keystrokesFolderPath = targetDataFolderPath + keystrokesFolderName;
    }
    
    public String getKeystrokesFolderPath () {
        return keystrokesFolderPath;
    }
    
    public void createTargetDataFolders() {
        createFolder(targetDataFolderPath);
        createTargetDataSubFolders();
        
    }
    
    private void createTargetDataSubFolders() {
        createFolder(webcamImageFolderPath);
        createFolder(screenImageFolderPath);
        createFolder(keystrokesFolderPath);
    }

    private void createFolder(String folderPath) {
        File folder = new File(folderPath);
        
        folder.mkdir();
    }
}
