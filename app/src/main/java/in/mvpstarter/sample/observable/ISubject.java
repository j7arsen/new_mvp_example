package in.mvpstarter.sample.observable;

import in.mvpstarter.sample.ui.base.event.Event;
import retrofit2.Response;


/**
 * Created by arsen on 07.02.17.
 */

public interface ISubject {

    void addObserver(IObserver iObserver);

    void removeObserver(IObserver iObserver);

    void removeAllObservers();

    void notifyStartedWithAction(final int action);

    void notifyFinishWithAction(final int action);

    void notifySuccess(int actionCode, final Response response);

    void notifyFailed(int actionCode, Throwable e);

    boolean containObserver(IObserver iObserver);

    void notifyEvent(Event event);

}
