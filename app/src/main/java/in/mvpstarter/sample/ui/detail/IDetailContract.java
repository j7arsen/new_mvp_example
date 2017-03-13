package in.mvpstarter.sample.ui.detail;

import in.mvpstarter.sample.data.model.Pokemon;
import in.mvpstarter.sample.data.model.Statistic;
import in.mvpstarter.sample.ui.base.MvpView;
import in.mvpstarter.sample.ui.base.Presenter;

/**
 * Created by arsen on 07.02.17.
 */

public interface IDetailContract {

    interface IDetailView extends MvpView {

        void showPokemon(Pokemon pokemon);

        void showStat(Statistic statistic);

        void showProgress(boolean show);

        void showError(Throwable error);

    }

    interface IDetailPresenter extends Presenter<IDetailContract.IDetailView> {

        void getPokemon(String name);

    }

}
