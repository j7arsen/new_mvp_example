package in.mvpstarter.sample.ui.base.event;

/**
 * Created by j7ars on 13.07.2017.
 */

public class EventFailRequest extends Event {

    private Throwable mThrowable;

    public EventFailRequest(int mActionCode, Throwable mThrowable) {
        super(mActionCode);
        this.mThrowable = mThrowable;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }

    public void setThrowable(Throwable mThrowable) {
        this.mThrowable = mThrowable;
    }

    @Override
    public EventType getEventType() {
        return EventType.FAIL_REQUEST;
    }
}
