package app.zoom;

import core.schedule.ScheduledEvent;

/**
 * @author mashirocl@gmail.com
 * @since 2023/04/20 14:34
 */
public abstract class Zoom extends ScheduledEvent {
    public String name;

    public void setName(String name){
        this.name = name;
    }
}