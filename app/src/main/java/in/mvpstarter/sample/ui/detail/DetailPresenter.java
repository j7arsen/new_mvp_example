package in.mvpstarter.sample.ui.detail;

import android.util.Log;

import javax.inject.Inject;

import in.mvpstarter.sample.data.DataManager;
import in.mvpstarter.sample.data.model.Pair;
import in.mvpstarter.sample.injection.ConfigPersistent;
import in.mvpstarter.sample.observable.ObservableController;
import in.mvpstarter.sample.rest.GetUserNetRequest;
import in.mvpstarter.sample.ui.base.BasePresenter;
import in.mvpstarter.sample.ui.base.Event;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

@ConfigPersistent
public class DetailPresenter extends BasePresenter<IDetailContract.IDetailView> implements IDetailContract.IDetailPresenter {

    private final DataManager mDataManager;

    private Subscription mSubscription = Subscriptions.empty();

    @Inject
    DetailPresenter(DataManager dataManager, ObservableController observableController) {
        super(observableController);
        mDataManager = dataManager;
    }

    @Override
    public void attachView(IDetailContract.IDetailView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void getPokemon(String name) {
        checkViewAttached();
        getMvpView().showProgress(true);
        mSubscription = new GetUserNetRequest(mDataManager, mObservableController).getUserData();
        addSubscription(mSubscription);
        /*mDataManager.getPokemon(name)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(pokemon -> {
                    // It should be always checked if MvpView (Fragment or Activity) is attached.
                    // Calling showProgress() on a not-attached fragment will throw a NPE
                    // It is possible to ask isAdded() in the fragment, but it's better to ask in the presenter
                    getMvpView().showProgress(false);
                    getMvpView().showPokemon(pokemon);
                    for (Statistic statistic : pokemon.stats) {
                        getMvpView().showStat(statistic);
                    }
                }, throwable -> {
                    getMvpView().showProgress(false);
                    getMvpView().showError(throwable);
                });*/
    }

    @Override
    public void onStartRequest(int action) {
        Log.i("Request", "Request");
    }

    @Override
    public void onSuccess(int actionCode, Pair pair) {
        unsubscribe(mSubscription);
        Log.i("Request", "Request");
    }

    @Override
    public void onFail(int action, Throwable e) {
        unsubscribe(mSubscription);
        Log.i("Request", "Request");
    }

    @Override
    public void onEvent(Event event) {
        Log.i("Request", "Request");
    }
}
