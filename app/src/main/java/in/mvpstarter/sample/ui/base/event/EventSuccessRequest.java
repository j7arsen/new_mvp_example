package in.mvpstarter.sample.ui.base.event;

import in.mvpstarter.sample.data.model.Pair;

/**
 * Created by j7ars on 13.07.2017.
 */

public class EventSuccessRequest extends Event {

    private Pair mData;

    public EventSuccessRequest(int mActionCode, Pair mData) {
        super(mActionCode);
        this.mData = mData;
    }

    public Pair getData() {
        return mData;
    }

    public void setData(Pair mData) {
        this.mData = mData;
    }

    @Override
    public EventType getEventType() {
        return EventType.SUCCESS_REQUEST;
    }
}
