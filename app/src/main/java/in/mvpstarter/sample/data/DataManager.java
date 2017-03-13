package in.mvpstarter.sample.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.observable.IRequestCallback;
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
    public Subscription getUserData(Class<GetUserService> serviceClass, int actionCode, IRequestCallback requestCallback){
        if(mRequestManager != null) {
            return mRequestManager.getUserData(serviceClass).subscribe(s -> requestCallback.onSuccessResponse(actionCode, new Pair(s)), t -> requestCallback.onErrorResponse(actionCode, t));
        }
        return null;
    }



}