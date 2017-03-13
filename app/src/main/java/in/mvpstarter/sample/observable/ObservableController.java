package in.mvpstarter.sample.observable;


import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.ui.base.Event;

/**
 * Created by arsen on 07.02.17.
 */
@Singleton
public class ObservableController implements ISubject {

    private ArrayList<IObserver> mObservers;

    @Inject
    public ObservableController() {
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
            mObservers.get(i).onStartRequest(action);
        }
    }

    @Override
    public void notifySuccess(int action, Pair o) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onSuccess(action, o);
        }
    }

    @Override
    public void notifyFailed(int action, Throwable e) {
        final int size = mObservers.size();
        for (int i = 0; i < size; i++) {
            mObservers.get(i).onFail(action, e);
        }
    }

    @Override
    public void notifyEvent(Event event) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onEvent(event);
        }
    }

    @Override
    public boolean containObserver(IObserver iObserver) {
        return mObservers.contains(iObserver);
    }
}
