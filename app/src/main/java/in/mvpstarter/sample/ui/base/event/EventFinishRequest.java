package in.mvpstarter.sample.ui.base.event;

/**
 * Created by j7ars on 13.07.2017.
 */

public class EventFinishRequest extends Event {

    public EventFinishRequest(int actionCode){
        super(actionCode);
    }

    @Override
    public EventType getEventType() {
        return EventType.FINISH_REQUEST;
    }
}
