package in.mvpstarter.sample.injection.component;

import dagger.Subcomponent;
import in.mvpstarter.sample.injection.scope.PerDialogFragment;
import in.mvpstarter.sample.injection.module.DialogFragmentModule;
import in.mvpstarter.sample.injection.module.PresenterModule;

/**
 * Created by j7ars on 12.07.2017.
 */
@PerDialogFragment
@Subcomponent(modules = {DialogFragmentModule.class, PresenterModule.class})
public interface DialogFragmentComponent {


}
