package in.mvpstarter.sample.ui.main;

import android.util.Log;

import java.util.ArrayList;

import javax.inject.Inject;

import in.mvpstarter.sample.app.Action;
import in.mvpstarter.sample.data.UserData;
import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.injection.ConfigPersistent;
import in.mvpstarter.sample.rest.GetUserService;
import in.mvpstarter.sample.ui.base.BasePresenter;
import in.mvpstarter.sample.ui.base.BaseRendererRequest;
import in.mvpstarter.sample.ui.base.Event;
import in.mvpstarter.sample.ui.detail.TestEvent;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

@ConfigPersistent
public class MainPresenter extends BasePresenter<IMainContract.IMainView> implements IMainContract.IMainPresenter {

    private Subscription mSubscription;

    @Inject
    public MainPresenter() {
        mSubscription = Subscriptions.empty();
    }

    @Override
    public void attachView(IMainContract.IMainView mvpView, Object... params) {
        super.attachViewBase(mvpView);
        if(params.length > 0){
            String par = (String) params[0];
            int par2 = (Integer) params[1];
            Log.i("Params", "Params = " + par + " par222 = " + par2);
        }
    }

    @Override
    public void detachView() {
        super.detachViewBase();
    }

    @Override
    public void getPokemon(int limit) {
        checkViewAttached();
        getMvpView().showProgress(true);
        //old variant
        // mSubscription = mDataManager.getUserData(GetUserService.class).subscribe(s -> mObservableController.notifySuccess(Action.GET_ACTION, new Pair(s)), e -> mObservableController.notifyFailed(Action.GET_ACTION, e));
        //  mSubscription = new GetUserNetRequest(mDataManager, mObservableController).getUserData();
        mSubscription = mDataManager.getUserData(GetUserService.class, new BaseRendererRequest(mObservableController, Action.GET_ACTION));
        addSubscription(mSubscription);
    }

    @Override
    public void onStartRequest(int action) {
        switch (action) {
            case Action.GET_ACTION:
                getMvpView().showProgress(false);
                break;
        }
    }

    @Override
    public void onSuccess(int actionCode, Pair pair) {
        switch (actionCode) {
            case Action.GET_ACTION:
                unsubscribe(mSubscription);
                getMvpView().showProgress(false);
                UserData userData = (UserData) pair.getValue();
                ArrayList<String> pokeStrings = new ArrayList<>();
                pokeStrings.add(userData.getName());
                pokeStrings.add(userData.getLogin());
                pokeStrings.add(userData.getBio());
                getMvpView().showPokemon(pokeStrings);
                break;
        }
    }

    @Override
    public void onFail(int action, Throwable e) {
        switch (action) {
            case Action.GET_ACTION:
                unsubscribe(mSubscription);
                getMvpView().showProgress(false);
                getMvpView().showError(e);
                break;
        }
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof TestEvent){
            Log.i("Event", "Event = " + ((TestEvent) event).getmTestString());
        }
        //Iet is method for observe event from observable controller
    }
}