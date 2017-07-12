package in.mvpstarter.sample.injection.component;

import dagger.Subcomponent;
import in.mvpstarter.sample.injection.module.PresenterModule;
import in.mvpstarter.sample.injection.module.ViewModule;
import in.mvpstarter.sample.injection.scope.PerView;

/**
 * Created by j7ars on 12.07.2017.
 */
@PerView
@Subcomponent(modules = {ViewModule.class, PresenterModule.class})
public interface ViewComponent {
}
