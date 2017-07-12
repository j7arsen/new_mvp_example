package in.mvpstarter.sample.injection.component;

import dagger.Subcomponent;
import in.mvpstarter.sample.injection.scope.PerService;
import in.mvpstarter.sample.injection.module.PresenterModule;
import in.mvpstarter.sample.injection.module.ServiceModule;

/**
 * Created by j7ars on 12.07.2017.
 */
@PerService
@Subcomponent(modules = {ServiceModule.class, PresenterModule.class})
public interface ServiceComponent {
}
