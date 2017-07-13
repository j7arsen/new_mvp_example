package in.mvpstarter.sample.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import in.mvpstarter.sample.data.DataManager;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Base class that implements the IObserver interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public abstract class BasePresenter<T extends IBaseMvpView> implements IBaseMvpPresenter<T>{

    protected T mMvpView;
    protected final CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    @Inject
    protected DataManager mDataManager;


    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
        mCompositeSubscription.clear();
        if (!mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void setArguments(Object... params) {
        return;
    }

    @Override
    public void saveInstanceState(Bundle outState) {
        return;
    }

    @Override
    public void restoreInstanceState(@NonNull Bundle savedInstanceState) {
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

