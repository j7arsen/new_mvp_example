package in.mvpstarter.sample.rest;

import in.mvpstarter.sample.data.DataManager;
import in.mvpstarter.sample.observable.ISubject;

/**
 * Created by j7ars on 11.02.2017.
 */

public class GetUserNetRequest  {

    public GetUserNetRequest(DataManager manager, ISubject observable){
       // super(manager, observable);
    }

    /*public Subscription getUserData(){
        mObservable.notifyStartedWithAction(Action.GET_ACTION);
        return mDataManager.getUserData(GetUserService.class, Action.GET_ACTION, this);
    }*/

}
