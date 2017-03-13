package in.mvpstarter.sample.injection.component;

import dagger.Subcomponent;
import in.mvpstarter.sample.injection.PerDialogFragment;
import in.mvpstarter.sample.injection.module.DialogFragmentModule;
import in.mvpstarter.sample.ui.base.BaseDialogFragment;

/**
 * This component inject dependencies to all DialogFragments across the application
 */
@PerDialogFragment
@Subcomponent(modules = DialogFragmentModule.class)
public interface DialogFragmentComponent {

    void inject(BaseDialogFragment baseDialogFragment);
}
