package in.mvpstarter.sample.injection.module;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.injection.qualifier.ActivityContext;

/**
 * Created by j7ars on 12.02.2017.
 */
@Module
public class DialogFragmentModule {

    private DialogFragment mDialogFragment;

    public DialogFragmentModule(DialogFragment dialogFragment) {
        mDialogFragment = dialogFragment;
    }

    @Provides
    DialogFragment providesDialogFragment() {
        return mDialogFragment;
    }

    @Provides
    Activity provideActivity() {
        return mDialogFragment.getActivity();
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mDialogFragment.getActivity();
    }

}
