package in.mvpstarter.sample.ui.detail;

import in.mvpstarter.sample.ui.base.event.Event;
import in.mvpstarter.sample.ui.base.event.EventType;

/**
 * Created by arsen on 16.03.17.
 */

public class TestEvent extends Event {

    private String mTestString;

    public TestEvent(String testString){
        this.mTestString = testString;
    }

    public String getTestString() {
        return mTestString;
    }

    @Override
    public EventType getEventType() {
        return EventType.DEFAULT;
    }
}
