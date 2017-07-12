package in.mvpstarter.sample.injection.component;

import dagger.Subcomponent;
import in.mvpstarter.sample.injection.module.PresenterModule;
import in.mvpstarter.sample.injection.module.ViewHolderModule;
import in.mvpstarter.sample.injection.scope.PerViewHolder;

/**
 * Created by j7ars on 12.07.2017.
 */
@PerViewHolder
@Subcomponent(modules = {ViewHolderModule.class, PresenterModule.class})
public interface ViewHolderComponent {
}
