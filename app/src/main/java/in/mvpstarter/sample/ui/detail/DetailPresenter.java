package in.mvpstarter.sample.ui.detail;

import javax.inject.Inject;

import in.mvpstarter.sample.app.Action;
import in.mvpstarter.sample.injection.ConfigPersistent;
import in.mvpstarter.sample.rest.GetUserService;
import in.mvpstarter.sample.ui.base.BaseRendererRequest;
import in.mvpstarter.sample.ui.base.BasePresenter;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

@ConfigPersistent
public class DetailPresenter extends BasePresenter<IDetailContract.IDetailView> implements IDetailContract.IDetailPresenter {

    private Subscription mSubscription;

    @Inject
    DetailPresenter() {
        mSubscription = Subscriptions.empty();
    }

    @Override
    public void getPokemon(String name) {
        checkViewAttached();
        mSubscription = mDataManager.getUserData(GetUserService.class, new BaseRendererRequest(mObservableController, Action.GET_ACTION));
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


}
