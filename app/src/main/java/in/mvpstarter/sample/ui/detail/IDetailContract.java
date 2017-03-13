package in.mvpstarter.sample.ui.detail;

import in.mvpstarter.sample.data.model.Pokemon;
import in.mvpstarter.sample.data.model.Statistic;
import in.mvpstarter.sample.ui.base.IBaseMvpView;
import in.mvpstarter.sample.ui.base.IBaseMvpPresenter;

/**
 * Created by arsen on 07.02.17.
 */

public interface IDetailContract {

    interface IDetailView extends IBaseMvpView {

        void showPokemon(Pokemon pokemon);

        void showStat(Statistic statistic);

        void showProgress(boolean show);

        void showError(Throwable error);

    }

    interface IDetailPresenter extends IBaseMvpPresenter<IDetailContract.IDetailView> {

        void getPokemon(String name);

    }

}
