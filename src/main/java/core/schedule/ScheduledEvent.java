package core.schedule;

import core.execute.MyExecutable;

import java.time.LocalDateTime;

/**
 * @author mashirocl@gmail.com
 * @since 2023/04/20 15:25
 */
public abstract class ScheduledEvent implements Schedulable, MyExecutable {
     public LocalDateTime scheduledTime;

     public LocalDateTime getScheduledTime(){
         return scheduledTime;
     }

     public boolean isOverScheduledTime(){
         return LocalDateTime.now().isAfter(scheduledTime);
     }

     @Override
    public void schedule(LocalDateTime dateTime) {
        this.scheduledTime = dateTime;
    }
}
