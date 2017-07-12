package in.mvpstarter.sample.injection.module;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.injection.qualifier.FragmentContext;
import in.mvpstarter.sample.injection.scope.PerFragment;

@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment providesFragment() {
        return mFragment;
    }

    @Provides
    @PerFragment
    Activity provideActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    @FragmentContext
    Context providesContext() {
        return mFragment.getActivity();
    }

}