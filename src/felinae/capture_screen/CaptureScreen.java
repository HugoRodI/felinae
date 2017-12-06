package felinae.capture_screen;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
*
* @author HugoRod
* 
*/

public class CaptureScreen {
    public static void main(String[] args) {
        try {
            String capturedScreenImageExtension = "jpg";
            String capturedScreenImageName = "CapturedScreen";
            String capturedScreenImageFileName = capturedScreenImageName + "." + capturedScreenImageExtension; 
            File capturedScreenImageFile = new File(capturedScreenImageFileName);
            
            Robot robot = new Robot();

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenArea = new Rectangle(screenSize);
			
            BufferedImage capturedScreenImage = robot.createScreenCapture(screenArea);
            ImageIO.write(capturedScreenImage, capturedScreenImageExtension, capturedScreenImageFile);
        } catch (AWTException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
