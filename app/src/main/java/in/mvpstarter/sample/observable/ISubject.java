package in.mvpstarter.sample.observable;

import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.ui.base.Event;

/**
 * Created by arsen on 07.02.17.
 */

public interface ISubject {

    void addObserver(IObserver iObserver);

    void removeObserver(IObserver iObserver);

    void removeAllObservers();

    void notifyStartedWithAction(final int action);

    void notifySuccess(final int action, final Pair o);

    void notifyFailed(final int action, Throwable e);

    boolean containObserver(IObserver iObserver);

    void notifyEvent(Event event);

}
