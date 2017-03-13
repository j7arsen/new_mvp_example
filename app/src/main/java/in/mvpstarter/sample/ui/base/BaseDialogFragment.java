package in.mvpstarter.sample.ui.base;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;

import java.util.concurrent.atomic.AtomicLong;

import in.mvpstarter.sample.MvpStarterApplication;
import in.mvpstarter.sample.injection.component.ConfigPersistentComponent;
import in.mvpstarter.sample.injection.component.DaggerConfigPersistentComponent;
import in.mvpstarter.sample.injection.component.DialogFragmentComponent;
import in.mvpstarter.sample.injection.module.DialogFragmentModule;
import timber.log.Timber;

/**
 * Abstract DialogFragment that every other DialogFragment in this application must implement. It handles
 * creation of Dagger components and makes sure that instances of ConfigPersistentComponent are kept
 * across configuration changes.
 */
public class BaseDialogFragment extends DialogFragment {

    private static final String KEY_DIALOG_FRAGMENT_ID = "KEY_DIALOG_FRAGMENT_ID";
    private static final LongSparseArray<ConfigPersistentComponent> sComponentsArray =
            new LongSparseArray<>();
    private static final AtomicLong NEXT_ID = new AtomicLong(0);

    private DialogFragmentComponent mDialogFragmentComponent;
    private long mDialogFragmentId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the DialogFragmentComponent and reuses cached ConfigPersistentComponent if this is
        // being called after a configuration change.
        mDialogFragmentId = savedInstanceState != null ?
                savedInstanceState.getLong(KEY_DIALOG_FRAGMENT_ID) : NEXT_ID.getAndIncrement();
        ConfigPersistentComponent configPersistentComponent;
        if (sComponentsArray.get(mDialogFragmentId) == null) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", mDialogFragmentId);
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .applicationComponent(MvpStarterApplication.get(
                            getActivity()).getComponent())
                    .build();
            sComponentsArray.put(mDialogFragmentId, configPersistentComponent);
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", mDialogFragmentId);
            configPersistentComponent = sComponentsArray.get(mDialogFragmentId);
        }
        mDialogFragmentComponent = configPersistentComponent.dialogFragmentComponent(new DialogFragmentModule(this));
        mDialogFragmentComponent.inject(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putLong(KEY_DIALOG_FRAGMENT_ID, mDialogFragmentId);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onDestroy() {
        if (!getActivity().isChangingConfigurations()) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", mDialogFragmentId);
            sComponentsArray.remove(mDialogFragmentId);
        }
        super.onDestroy();
    }

    public DialogFragmentComponent dialogFragmentComponent() {
        return mDialogFragmentComponent;
    }

}
