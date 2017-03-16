package in.mvpstarter.sample.ui.base;

import android.util.Log;

import javax.inject.Inject;

import in.mvpstarter.sample.data.DataManager;
import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.observable.IObserver;
import in.mvpstarter.sample.observable.ObservableController;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public abstract class BasePresenter<T extends IBaseMvpView> implements IObserver{

    protected T mMvpView;
    protected final CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    @Inject
    protected DataManager mDataManager;

    @Inject
    protected ObservableController mObservableController;

    public void attachView(T mvpView) {
        mMvpView = mvpView;
        mObservableController.addObserver(this);
    }

    public void detachView() {
        mMvpView = null;
        mObservableController.removeObserver(this);
        if (!mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void onStartRequest(int action) {
        Log.i("Start Request", "Start Request");
        return;
    }

    @Override
    public void onSuccess(int actionCode, Pair pair) {
        Log.i("Success Request", "Success Request");
        return;
    }

    @Override
    public void onFail(int action, Throwable e) {
        Log.i("Fail Request", "Fail Request");
        return;
    }

    @Override
    public void onEvent(Event event) {
        Log.i("Event", "Event");
        return;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public void addSubscription(Subscription subs) {
        mCompositeSubscription.add(subs);
    }

    public void unsubscribe(Subscription subscription){
        if(mCompositeSubscription.hasSubscriptions())
            if(!mCompositeSubscription.isUnsubscribed())
                mCompositeSubscription.remove(subscription);
    }

    private static class MvpViewNotAttachedException extends RuntimeException {
        MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

}

