package in.mvpstarter.sample.ui.base;

import in.mvpstarter.sample.observable.ISubject;
import in.mvpstarter.sample.rest.IRequestCallback;
import retrofit2.Response;

/**
 * Created by j7ars on 11.02.2017.
 */

public class BaseRequestController implements IRequestCallback{

    private ISubject mObservable;
    private int mActionCode;

    public BaseRequestController(ISubject subject, int actionCode){
        this.mObservable = subject;
        this.mActionCode = actionCode;
    }

    @Override
    public void onStartRequest() {
        mObservable.notifyStartedWithAction(mActionCode);
    }

    @Override
    public void onFinishRequest() {
        mObservable.notifyFinishWithAction(mActionCode);
    }

    @Override
    public void onErrorResponse(Throwable e) {
        mObservable.notifyFailed(mActionCode, e);
    }

    @Override
    public void onSuccessResponse(Response response) {
        mObservable.notifySuccess(mActionCode, response);
    }
}
