package in.mvpstarter.sample.ui.main;

import java.util.List;

import in.mvpstarter.sample.ui.base.IBaseMvpPresenter;
import in.mvpstarter.sample.ui.base.IBaseMvpView;

/**
 * Created by j7ars on 13.07.2017.
 */

public interface IPokemonVIewHolderContract {

    interface IViewHolderView extends IBaseMvpView {

      void openDetailPokemon();

    }

    interface IViewHolderPresenter extends IBaseMvpPresenter<IPokemonVIewHolderContract.IViewHolderView> {

        void updateView(PokemonAdapter.PokemonViewHolder holder, String pokemon);

    }

}
