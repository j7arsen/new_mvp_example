package in.mvpstarter.sample.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.rest.IRequestCallback;
import in.mvpstarter.sample.rest.GetUserService;
import in.mvpstarter.sample.rest.RequestManager;
import rx.Subscription;

@Singleton
public class DataManager {

    private RequestManager mRequestManager;

    @Inject
    public DataManager(RequestManager manager) {
        this.mRequestManager = manager;
    }

    //request
    public Subscription getUserData(Class<GetUserService> serviceClass, IRequestCallback requestCallback){
        if(mRequestManager != null) {
            return mRequestManager.getUserData(serviceClass)
                    .doOnSubscribe(() -> requestCallback.onStartRequest())
                    .doOnNext(s -> requestCallback.onSuccessResponse(new Pair(s)))
                    .doOnError(t -> requestCallback.onErrorResponse(t))
                    .doOnUnsubscribe(() -> requestCallback.onFinishRequest())
                    .subscribe();
        }
        return null;
    }

}