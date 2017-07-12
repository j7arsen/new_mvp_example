package in.mvpstarter.sample.injection.module;

import android.content.Context;
import android.view.View;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.injection.qualifier.ViewContext;
import in.mvpstarter.sample.injection.scope.PerView;

/**
 * Created by j7ars on 12.07.2017.
 */
@Module
public class ViewModule {

    private final View mView;

    public ViewModule(View view){
        this.mView = view;
    }

    @Provides
    @PerView
    View provideView(){
        return mView;
    }

    @Provides
    @PerView
    @ViewContext
    Context provideContext(){
        return mView.getContext();
    }

}
