package felinae.os_utils;

public class OSValidator {
    private static String osName = System.getProperty("os.name").toLowerCase();
    
    public boolean allowedOS() {
        if (isWindows())
            return true;
        
        return false;
    }

    private boolean isWindows() {
        if (osName.indexOf("unix") >= 0)
            return true;
        
        return true;
    }
}
