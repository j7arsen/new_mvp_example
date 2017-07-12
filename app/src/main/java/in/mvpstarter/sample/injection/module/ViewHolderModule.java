package in.mvpstarter.sample.injection.module;

import android.support.v7.widget.RecyclerView;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.injection.scope.PerViewHolder;

/**
 * Created by j7ars on 12.07.2017.
 */
@Module
public class ViewHolderModule {

    private RecyclerView.ViewHolder mViewHolder;

    public ViewHolderModule(RecyclerView.ViewHolder viewHolder){
        this.mViewHolder = viewHolder;
    }

    @Provides
    @PerViewHolder
    RecyclerView.ViewHolder provideViewHolder(){
        return mViewHolder;
    }

}
