package core.schedule;

import core.execute.MyExecutable;

import java.time.LocalDateTime;

/**
 * @author mashirocl@gmail.com
 * @since 2023/04/20 14:34
 */
public interface Schedulable {
    // execute executable at dateTime
    void schedule(LocalDateTime dateTime);
}
