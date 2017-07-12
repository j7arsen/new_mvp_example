package in.mvpstarter.sample.injection.component;

import dagger.Subcomponent;
import in.mvpstarter.sample.injection.scope.PerFragment;
import in.mvpstarter.sample.injection.module.FragmentModule;
import in.mvpstarter.sample.injection.module.PresenterModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = {FragmentModule.class, PresenterModule.class})
public interface FragmentComponent {

}