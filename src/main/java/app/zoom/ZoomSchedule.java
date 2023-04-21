package app.zoom;

import com.opencsv.CSVReader;
import core.schedule.Schedule;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mashirocl@gmail.com
 * @since 2023/04/20 15:30
 */
public class ZoomSchedule extends Schedule {
    private final String zoomSchedulePath;

    public ZoomSchedule(String zoomSchedulePath) {
        this.zoomSchedulePath = zoomSchedulePath;
    }

    public void loadScheduledZoom(){
        try{
            CSVReader reader = new CSVReader(new FileReader(zoomSchedulePath));
            String [] line;
            while ((line = reader.readNext()) != null) {
                addScheduledEvent(new ZoomConnector(line[0], line[3], parseCSVTime(line[1])));
                addScheduledEvent(new ZoomDisconnector(line[3], parseCSVTime(line[2])));
            }
        }
        catch (Exception e){
            System.out.println("Error: load zoom schedule fail,"+e.getMessage());
        }
    }


    private LocalDateTime parseCSVTime(String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(time, formatter);
    }
}