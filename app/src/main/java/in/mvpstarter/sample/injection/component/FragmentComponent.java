package in.mvpstarter.sample.injection.component;

import dagger.Subcomponent;
import in.mvpstarter.sample.injection.PerFragment;
import in.mvpstarter.sample.injection.module.FragmentModule;
import in.mvpstarter.sample.ui.base.BaseFragment;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(BaseFragment baseFragment);

}