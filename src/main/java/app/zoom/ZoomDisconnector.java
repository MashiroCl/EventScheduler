package app.zoom;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author mashirocl@gmail.com
 * @since 2023/04/20 15:33
 */
public class ZoomDisconnector extends Zoom{

    public ZoomDisconnector(String name, LocalDateTime time){
        this.name = name;
        schedule(time);
    }


    @Override
    public void execute() {
        String os = System.getProperty("os.name");
        switch (os){
            case "Mac OS X": closeZoomMACOSX(); break;
            case "Windows": closeZoomWINDOWS(); break;
            default:
                throw new RuntimeException("Error: Unrecognized operating system: " + os);
        }
    }

    private void closeZoomMACOSX(){
        try {
            // Execute AppleScript command to quit Zoom app
            ProcessBuilder pb = new ProcessBuilder("osascript", "-e", "tell application \"zoom.us\" to quit");
            pb.start();
            System.out.println("Zoom app closed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeZoomWINDOWS(){
        try{
            // Find the Zoom process and destroy it
            ProcessBuilder pb = new ProcessBuilder("taskkill", "/f", "/im", "Zoom.exe");
            pb.start();
            System.out.println("Zoom app closed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
