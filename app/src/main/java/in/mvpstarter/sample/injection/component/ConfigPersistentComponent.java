package in.mvpstarter.sample.injection.component;

import dagger.Component;
import in.mvpstarter.sample.injection.module.ViewHolderModule;
import in.mvpstarter.sample.injection.module.ViewModule;
import in.mvpstarter.sample.injection.scope.ConfigPersistent;
import in.mvpstarter.sample.injection.module.ActivityModule;
import in.mvpstarter.sample.injection.module.FragmentModule;
import in.mvpstarter.sample.injection.module.ServiceModule;
import in.mvpstarter.sample.ui.base.activity.BaseMvpActivity;
import in.mvpstarter.sample.ui.base.fragment.BaseFragment;

/**
 * A dagger component that will live during the lifecycle of an Activity or Fragment or DialogFragment but it won't
 * be destroy during configuration changes. Check {@link BaseMvpActivity} and {@link BaseFragment} to
 * see how this components survives configuration changes.
 * Use the {@link ConfigPersistent} scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);
    
    ServiceComponent serviceComponent(ServiceModule serviceModule);

    ViewHolderComponent viewHolderComponent(ViewHolderModule viewHolderModule);

    ViewComponent viewComponent(ViewModule viewModule);

}
