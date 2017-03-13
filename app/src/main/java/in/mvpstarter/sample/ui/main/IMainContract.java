package in.mvpstarter.sample.ui.main;

import java.util.List;

import in.mvpstarter.sample.ui.base.MvpView;
import in.mvpstarter.sample.ui.base.Presenter;

/**
 * Created by arsen on 07.02.17.
 */

public interface IMainContract {

    interface IMainView extends MvpView {

        void showPokemon(List<String> pokemon);

        void showProgress(boolean show);

        void showError(Throwable error);

    }

    interface IMainPresenter extends Presenter<IMainView> {

        void getPokemon(int limit);

    }


}
