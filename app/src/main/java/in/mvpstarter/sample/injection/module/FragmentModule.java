package in.mvpstarter.sample.injection.module;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.injection.qualifier.FragmentContext;

@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    Fragment providesFragment() {
        return mFragment;
    }

    @Provides
    Activity provideActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @FragmentContext
    Context providesContext() {
        return mFragment.getActivity();
    }

}