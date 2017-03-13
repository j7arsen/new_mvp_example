package in.mvpstarter.sample.ui.base;

import android.util.Log;

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
public abstract class BasePresenter<T extends MvpView> implements IObserver{

    protected T mMvpView;
    protected final CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    protected ObservableController mObservableController;

    public BasePresenter(ObservableController observableController){
        this.mObservableController = observableController;
    }

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
    }

    @Override
    public void onSuccess(int actionCode, Pair pair) {
        Log.i("Success Request", "Success Request");
    }

    @Override
    public void onFail(int action, Throwable e) {
        Log.i("Fail Request", "Fail Request");
    }

    @Override
    public void onEvent(Event event) {
        Log.i("Event", "Event");
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

