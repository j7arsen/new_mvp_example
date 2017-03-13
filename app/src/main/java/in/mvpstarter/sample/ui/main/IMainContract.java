package in.mvpstarter.sample.ui.main;

import java.util.List;

import in.mvpstarter.sample.ui.base.MvpPresenter;
import in.mvpstarter.sample.ui.base.MvpView;

/**
 * Created by arsen on 07.02.17.
 */

public interface IMainContract {

    interface IMainView extends MvpView {

        void showPokemon(List<String> pokemon);

        void showProgress(boolean show);

        void showError(Throwable error);

    }

    interface IMainPresenter extends MvpPresenter {

        void attachView(IMainContract.IMainView mvpView, String data);

        void getPokemon(int limit);

    }


}
