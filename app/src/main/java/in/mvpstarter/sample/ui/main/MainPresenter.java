package in.mvpstarter.sample.ui.main;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import javax.inject.Inject;

import in.mvpstarter.sample.app.Action;
import in.mvpstarter.sample.data.UserData;
import in.mvpstarter.sample.injection.qualifier.ApplicationContext;
import in.mvpstarter.sample.injection.scope.ConfigPersistent;
import in.mvpstarter.sample.observable.EventController;
import in.mvpstarter.sample.observable.IObserver;
import in.mvpstarter.sample.rest.GetUserService;
import in.mvpstarter.sample.ui.base.BaseRequestController;
import in.mvpstarter.sample.ui.base.BasePresenter;
import in.mvpstarter.sample.ui.base.event.Event;
import in.mvpstarter.sample.ui.base.event.EventFailRequest;
import in.mvpstarter.sample.ui.base.event.EventSuccessRequest;
import in.mvpstarter.sample.ui.detail.TestEvent;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

@ConfigPersistent
public class MainPresenter extends BasePresenter<IMainContract.IMainView> implements IMainContract.IMainPresenter, IObserver {

    private Subscription mSubscription;

    @Inject
    @ApplicationContext
    Context mContext;

    @Inject
    EventController mObservableController;

    @Inject
    public MainPresenter() {
        mSubscription = Subscriptions.empty();
    }

    @Override
    public void attachView(IMainContract.IMainView mvpView) {
        super.attachView(mvpView);
        mObservableController.addObserver(this);
    }

    @Override
    public void detachView() {
        super.detachView();
        mObservableController.removeObserver(this);
    }

    @Override
    public void setArguments(Object... params) {
        if(params.length > 0){
            String par = (String) params[0];
            int par2 = (Integer) params[1];
            Log.i("Params", "Params = " + par + " par222 = " + par2);
        }
    }

    @Override
    public void getPokemon(int limit) {
        checkViewAttached();
        //old variant
        // mSubscription = mDataManager.getUserData(GetUserService.class).subscribe(s -> mObservableController.notifySuccess(Action.GET_ACTION, new Pair(s)), e -> mObservableController.notifyFailed(Action.GET_ACTION, e));
        //  mSubscription = new GetUserNetRequest(mDataManager, mObservableController).getUserData();
        mSubscription = mDataManager.getUserData(GetUserService.class, new BaseRequestController(mObservableController, Action.GET_ACTION));
        addSubscription(mSubscription);
    }

    @Override
    public void onEvent(Event event) {
        switch (event.getEventType()){
            case START_REQUEST:
                if(event.getActionCode() == Action.GET_ACTION){
                    getMvpView().showProgress(true);
                }
                break;
            case SUCCESS_REQUEST:
                if(event.getActionCode() == Action.GET_ACTION){
                    unsubscribe(mSubscription);
                    getMvpView().showProgress(false);
                    UserData userData = (UserData) ((EventSuccessRequest) event).getData().getValue();
                    ArrayList<String> pokeStrings = new ArrayList<>();
                    pokeStrings.add(userData.getName());
                    pokeStrings.add(userData.getLogin());
                    pokeStrings.add(userData.getBio());
                    getMvpView().showPokemon(pokeStrings);
                }
                break;
            case FAIL_REQUEST:
                if(event.getActionCode() == Action.GET_ACTION){
                    unsubscribe(mSubscription);
                    getMvpView().showProgress(false);
                    getMvpView().showError(((EventFailRequest)event).getThrowable());
                }
                break;
            case DEFAULT:
                Log.i("Test event", "Test event = " + ((TestEvent) event).getTestString());
                break;
        }
    }
}