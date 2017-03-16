package in.mvpstarter.sample.ui.base;

import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.observable.IRequestCallback;
import in.mvpstarter.sample.observable.ISubject;

/**
 * Created by j7ars on 11.02.2017.
 */

public class BaseOperationController implements IRequestCallback{

    private ISubject mObservable;
    private int mActionCode;

    public BaseOperationController(ISubject subject, int actionCode){
        this.mObservable = subject;
        this.mActionCode = actionCode;
        mObservable.notifyStartedWithAction(mActionCode);
    }

    @Override
    public void onErrorResponse(Throwable e) {
        mObservable.notifyFailed(mActionCode, e);
    }

    @Override
    public void onSuccessResponse(Pair successData) {
        mObservable.notifySuccess(mActionCode, successData);
    }
}
