package core.schedule;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author mashirocl@gmail.com
 * @since 2023/04/20 14:43
 */
public class Schedule {
    private final Map<ScheduledEvent,Boolean> scheduledEvents;
    public Schedule() {
        this.scheduledEvents = new HashMap<>();
    }

    public Map<ScheduledEvent,Boolean> getScheduledEvents() {
        return scheduledEvents;
    }

    public void addScheduledEvent(ScheduledEvent scheduledEvent){
        this.scheduledEvents.put(scheduledEvent, Boolean.TRUE);
    }

    //TODO: implementation
    public void removeSchedulableList(Schedulable schedulable){

    }

    public void executeScheduledEvents(){
        for(ScheduledEvent scheduledEvent:scheduledEvents.keySet()){
            if(scheduledEvent.isOverScheduledTime() && scheduledEvents.get(scheduledEvent) == Boolean.TRUE){
                scheduledEvent.execute();
                scheduledEvents.put(scheduledEvent, Boolean.FALSE);
            }
        }
    }
}
