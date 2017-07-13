package in.mvpstarter.sample.ui.main;

import java.util.List;

import in.mvpstarter.sample.ui.base.IBaseMvpPresenter;
import in.mvpstarter.sample.ui.base.IBaseMvpView;

/**
 * Created by arsen on 07.02.17.
 */

public interface IMainContract {

    interface IMainView extends IBaseMvpView {

        void showPokemon(List<String> pokemon);

        void showProgress(boolean show);

        void showError(Throwable error);

    }

    interface IMainPresenter extends IBaseMvpPresenter<IMainContract.IMainView> {

        void getPokemon(int limit);

    }

}
