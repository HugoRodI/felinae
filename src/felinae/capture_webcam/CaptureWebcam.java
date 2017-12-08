package felinae.capture_webcam;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
*
* @author HugoRod
* 
*/

public class CaptureWebcam {
	public static void CaptureWebcamImage(String capturedWebcamImagePath, String capturedWebcamImageName, Dimension webcamScreenArea) throws IOException {
		Webcam webcam = Webcam.getDefault();
		
		if (webcam != null) {
            webcam.setViewSize(webcamScreenArea);
            webcam.open();
            
            BufferedImage capturedWebcamImage = webcam.getImage();
            String capturedWebcamImageExtension = "PNG";
            String capturedWebcamImageFileName = capturedWebcamImagePath + capturedWebcamImageName + "." + capturedWebcamImageExtension.toLowerCase();
            File capturedWebcamImageFile = new File(capturedWebcamImageFileName);
            
            ImageIO.write(capturedWebcamImage, capturedWebcamImageExtension, capturedWebcamImageFile);
            
            webcam.close();
        }
	}
}
