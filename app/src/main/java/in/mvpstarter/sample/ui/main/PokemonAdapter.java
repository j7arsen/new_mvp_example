package in.mvpstarter.sample.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import in.mvpstarter.sample.R;
import in.mvpstarter.sample.injection.component.ViewHolderComponent;
import in.mvpstarter.sample.ui.base.viewholder.BaseMvpViewHolder;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<String> mPokemon;
    private ClickListener mClickListener;

    @Inject
    public PokemonAdapter() {
        mPokemon = Collections.emptyList();
    }

    public void setPokemon(List<String> pokemon) {
        mPokemon = pokemon;
    }

    public void setClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        String pokemon = mPokemon.get(position);
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return mPokemon.size();
    }

    public interface ClickListener {
        void onPokemonClick(String pokemon);
    }

    public class PokemonViewHolder extends BaseMvpViewHolder implements IPokemonVIewHolderContract.IViewHolderView{

        @BindView(R.id.text_name)
        TextView nameText;

        @Inject
        IPokemonVIewHolderContract.IViewHolderPresenter mPresenter;

        PokemonViewHolder(View itemView) {
            super(itemView);
            setupComponent();
        }

        @Override
        protected void inject(ViewHolderComponent viewHolderComponent) {
            viewHolderComponent.inject(this);
        }

        @Override
        protected void attachView() {
            mPresenter.attachView(this);
        }

        @Override
        public void openDetailPokemon() {
            if (mClickListener != null) {
                mClickListener.onPokemonClick("Test");
            }
        }

        public void bind(String pokemon){
            mPresenter.updateView(this, pokemon);
        }
    }

}
