package in.mvpstarter.sample.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.mvpstarter.sample.rest.IRequestCallback;
import in.mvpstarter.sample.rest.RequestManager;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Singleton
public class DataManager {

    private RequestManager mRequestManager;

    @Inject
    public DataManager(RequestManager manager) {
        this.mRequestManager = manager;
    }

    //request
    public Subscription getUserData(IRequestCallback requestCallback){
        if(mRequestManager != null) {
            return mRequestManager.getUserData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(() -> requestCallback.onStartRequest())
                    .doOnNext(s -> requestCallback.onSuccessResponse(s))
                    .doOnError(t -> requestCallback.onErrorResponse(t))
                    .doOnUnsubscribe(() -> requestCallback.onFinishRequest())
                    .subscribe();
        }
        return null;
    }

}