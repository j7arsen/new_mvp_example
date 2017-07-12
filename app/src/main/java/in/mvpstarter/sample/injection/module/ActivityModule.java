package in.mvpstarter.sample.injection.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.injection.qualifier.ActivityContext;
import in.mvpstarter.sample.injection.scope.PerActivity;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }

}
