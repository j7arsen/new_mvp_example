package in.mvpstarter.sample.ui.main;

import android.view.View;

import javax.inject.Inject;

import in.mvpstarter.sample.injection.scope.ConfigPersistent;
import in.mvpstarter.sample.ui.base.BasePresenter;

/**
 * Created by j7ars on 13.07.2017.
 */
@ConfigPersistent
public class PokemonViewHolderPresenter extends BasePresenter<IPokemonVIewHolderContract.IViewHolderView> implements IPokemonVIewHolderContract.IViewHolderPresenter {

    @Inject
    public PokemonViewHolderPresenter(){

    }

    @Override
    public void updateView(PokemonAdapter.PokemonViewHolder holder, String pokemon) {
        holder.nameText.setText(pokemon);
        holder.nameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMvpView().openDetailPokemon();
            }
        });
    }
}
