package app.zoom;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author mashirocl@gmail.com
 * @since 2023/04/20 15:33
 */
public class ZoomConnector extends Zoom {

    private final String zoomLink;

    public ZoomConnector(String zoomLink) {
        this.zoomLink = zoomLink;
        this.name = "NotSet";
    }
    public ZoomConnector(String zoomLink, String name, LocalDateTime time) {
        this.zoomLink = zoomLink;
        this.name = name;
        schedule(time);
    }

    @Override
    public void execute() {
        try {
            System.out.println(LocalTime.now()+ " Open zoom for " + name);
            Desktop.getDesktop().browse(new URI(zoomLink));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "Zoom connect at "+ scheduledTime + "\t" +zoomLink;
    }


}
