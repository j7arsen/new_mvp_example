package in.mvpstarter.sample.injection.component;

import dagger.Subcomponent;
import in.mvpstarter.sample.injection.scope.PerActivity;
import in.mvpstarter.sample.injection.module.ActivityModule;
import in.mvpstarter.sample.injection.module.PresenterModule;
import in.mvpstarter.sample.ui.detail.DetailActivity;
import in.mvpstarter.sample.ui.main.MainActivity;

@PerActivity
@Subcomponent(modules = {ActivityModule.class, PresenterModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);
}
