package in.mvpstarter.sample.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import in.mvpstarter.sample.data.DataManager;
import in.mvpstarter.sample.injection.qualifier.ApplicationContext;
import in.mvpstarter.sample.injection.module.ApplicationModule;
import in.mvpstarter.sample.injection.module.NetModule;
import in.mvpstarter.sample.observable.ObservableController;

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    ObservableController observableController();

}
