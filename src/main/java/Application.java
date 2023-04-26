import app.zoom.ZoomSchedule;

import java.nio.file.Paths;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author mashirocl@gmail.com
 * @since 2023/04/21 11:55
 */
//TODO fix the resource path, to make jar can use
public class Application {
    public static void main(String [] args){
        welcomePage();
        Timer timer = new Timer();
        timer.schedule(new ZoomTask(args[0]),0,1000);

    }

    public static void welcomePage(){
//        System.out.println("    (\\__/) ");
//        System.out.println("    (='.'=)  Welcome to EventScheduler");
//        System.out.println("    (\")_(\")   Everything is under control\n");

        System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
        System.out.println("|   Welcome to EventScheduler   |");
        System.out.println("|  Everything is under control  |");
        System.out.println("|_______________________________|");
        System.out.println("(\\__/) ||");
        System.out.println("(•ㅅ•) ||");
        System.out.println("/ 　 づ");
    }
}

class ZoomTask extends TimerTask{
    private ZoomSchedule zoomSchedule;
    public ZoomTask(String path){
        try{

//            this.zoomSchedule = new ZoomSchedule(
//                    Paths.get(ZoomTask.class.getResource("lecture.csv").toURI()).toString()
//            );
            this.zoomSchedule = new ZoomSchedule(path);
        }catch (Exception e){
            e.printStackTrace();
        }

        zoomSchedule.loadScheduledZoom();
    }

    public void run(){
        zoomSchedule.executeScheduledEvents();
    }

}
