package in.mvpstarter.sample.ui.base;

import in.mvpstarter.sample.data.DataManager;
import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.observable.IRequestCallback;
import in.mvpstarter.sample.observable.ISubject;

/**
 * Created by j7ars on 11.02.2017.
 */

public abstract class BaseRequest implements IRequestCallback{

    protected DataManager mDataManager;
    protected ISubject mObservable;

    public BaseRequest(DataManager manager, ISubject subject){
        this.mDataManager = manager;
        this.mObservable = subject;
    }

    @Override
    public void onErrorResponse(int action, Throwable e) {
        mObservable.notifyFailed(action, e);
    }

    @Override
    public void onSuccessResponse(int action, Pair successData) {
        mObservable.notifySuccess(action, successData);
    }
}
