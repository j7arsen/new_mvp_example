package in.mvpstarter.sample.observable;


import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.ui.base.event.Event;
import in.mvpstarter.sample.ui.base.event.EventFailRequest;
import in.mvpstarter.sample.ui.base.event.EventFinishRequest;
import in.mvpstarter.sample.ui.base.event.EventStartRequest;
import in.mvpstarter.sample.ui.base.event.EventSuccessRequest;

/**
 * Created by arsen on 07.02.17.
 */
@Singleton
public class EventController implements ISubject {

    private ArrayList<IObserver> mObservers;

    @Inject
    public EventController() {
        mObservers = new ArrayList<>();
    }

    @Override
    public void addObserver(IObserver iObserver) {
        if (!mObservers.contains(iObserver)) {
            mObservers.add(iObserver);
        }
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        if (iObserver != null) {
            final int i = mObservers.indexOf(iObserver);
            if (i >= 0) {
                mObservers.remove(iObserver);
            }
        }
    }

    @Override
    public void removeAllObservers() {
        if (mObservers != null) {
            mObservers.clear();
        }
    }

    @Override
    public void notifyStartedWithAction(final int action) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onEvent(new EventStartRequest(action));
        }
    }

    @Override
    public void notifyFinishWithAction(int action) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onEvent(new EventFinishRequest(action));
        }
    }

    @Override
    public void notifySuccess(int action, Pair o) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onEvent(new EventSuccessRequest(action, o));
        }
    }

    @Override
    public void notifyFailed(int action, Throwable e) {
        final int size = mObservers.size();
        for (int i = 0; i < size; i++) {
            mObservers.get(i).onEvent(new EventFailRequest(action, e));
        }
    }

    @Override
    public void notifyEvent(Event event) {
        final int size = mObservers.size();
        for (int i = 0; i < size; i++) {
            mObservers.get(i).onEvent(event);
        }
    }

    @Override
    public boolean containObserver(IObserver iObserver) {
        return mObservers.contains(iObserver);
    }
}
