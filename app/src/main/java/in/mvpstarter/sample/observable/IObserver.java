package in.mvpstarter.sample.observable;

import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.ui.base.Event;

/**
 * Created by arsen on 07.02.17.
 */

public interface IObserver {

    void onStartRequest(final int actionCode);

    void onSuccess(final int actionCode, Pair pair);

    void onFail(final int actionCode, Throwable e);

    //It is method for observe event from observable controller
    void onEvent(Event event);

}
