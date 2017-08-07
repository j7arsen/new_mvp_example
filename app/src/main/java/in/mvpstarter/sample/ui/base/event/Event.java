package in.mvpstarter.sample.ui.base.event;

/**
 * Created by j7ars on 11.02.2017.
 */

public abstract class Event {

    protected int mActionCode;

    public Event(int mActionCode){
        this.mActionCode = mActionCode;
    }

    public int getActionCode() {
        return mActionCode;
    }

    public void setActionCode(int mActionCode) {
        this.mActionCode = mActionCode;
    }

    public abstract EventType getEventType();

}
