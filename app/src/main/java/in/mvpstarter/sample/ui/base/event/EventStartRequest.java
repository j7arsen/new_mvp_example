package in.mvpstarter.sample.ui.base.event;

/**
 * Created by j7ars on 13.07.2017.
 */

public class EventStartRequest extends Event {

    public EventStartRequest(int mActionCode) {
        super(mActionCode);
    }

    @Override
    public EventType getEventType() {
        return EventType.START_REQUEST;
    }
}
