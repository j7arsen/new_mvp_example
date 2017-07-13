package in.mvpstarter.sample.injection.module;

import dagger.Binds;
import dagger.Module;
import in.mvpstarter.sample.ui.detail.DetailPresenter;
import in.mvpstarter.sample.ui.detail.IDetailContract;
import in.mvpstarter.sample.ui.main.IMainContract;
import in.mvpstarter.sample.ui.main.IPokemonVIewHolderContract;
import in.mvpstarter.sample.ui.main.MainPresenter;
import in.mvpstarter.sample.ui.main.PokemonViewHolderPresenter;

/**
 * Created by j7ars on 12.07.2017.
 */
@Module
public abstract class PresenterModule {

    // Activities
    @Binds
    abstract IMainContract.IMainPresenter bindMainPresenter(MainPresenter mainPresenter);

    @Binds
    abstract IDetailContract.IDetailPresenter bindDetailPresenter(DetailPresenter detailPresenter);
    //Fragments

    //DialogFragments

    //Service

    //ViewHolder
    @Binds
    abstract IPokemonVIewHolderContract.IViewHolderPresenter bindIViewHolderPresenter(PokemonViewHolderPresenter pokemonViewHolderPresenter);


}
