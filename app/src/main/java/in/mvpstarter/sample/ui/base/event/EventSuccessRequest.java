package in.mvpstarter.sample.ui.base.event;

import retrofit2.Response;

/**
 * Created by j7ars on 13.07.2017.
 */

public class EventSuccessRequest extends Event {

    private Response mData;

    public EventSuccessRequest(int mActionCode, Response mData) {
        super(mActionCode);
        this.mData = mData;
    }

    public Response getData() {
        return mData;
    }

    public void setData(Response data) {
        mData = data;
    }

    @Override
    public EventType getEventType() {
        return EventType.SUCCESS_REQUEST;
    }
}
