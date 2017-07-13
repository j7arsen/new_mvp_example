package in.mvpstarter.sample.injection.module;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.injection.qualifier.ViewHolderContext;
import in.mvpstarter.sample.injection.scope.PerViewHolder;

/**
 * Created by j7ars on 13.07.2017.
 */
@Module
public class ViewHolderModule {

    private RecyclerView.ViewHolder mViewHolder;
    private View mItemView;

    public ViewHolderModule(RecyclerView.ViewHolder viewHolder, View itemView){
        this.mViewHolder = viewHolder;
        this.mItemView = itemView;
    }

    @Provides
    @PerViewHolder
    RecyclerView.ViewHolder provideViewHolder(){
        return mViewHolder;
    }

    @Provides
    @PerViewHolder
    View provideItemView(){
        return mItemView;
    }

    @Provides
    @PerViewHolder
    @ViewHolderContext
    Context provideContext(){
        return mItemView.getContext();
    }


}
