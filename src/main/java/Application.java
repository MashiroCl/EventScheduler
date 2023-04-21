import app.zoom.ZoomSchedule;

import java.nio.file.Paths;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author mashirocl@gmail.com
 * @since 2023/04/21 11:55
 */
public class Application {
    public static void main(String [] args){
        Timer timer = new Timer();
        timer.schedule(new ZoomTask(),0,1000);

    }
}

class ZoomTask extends TimerTask{
    private ZoomSchedule zoomSchedule;
    public ZoomTask(){
        try{
            System.out.println(Paths.get(ZoomTask.class.getResource("lecture.csv").toURI()).toString());

            this.zoomSchedule = new ZoomSchedule(
                    Paths.get(ZoomTask.class.getResource("lecture.csv").toURI()).toString()
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        zoomSchedule.loadScheduledZoom();
    }

    public void run(){
        zoomSchedule.executeScheduledEvents();
    }

}
