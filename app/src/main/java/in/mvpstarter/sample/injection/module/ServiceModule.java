package in.mvpstarter.sample.injection.module;

import android.app.Service;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.injection.scope.PerService;
import in.mvpstarter.sample.injection.qualifier.ServiceContext;

/**
 * Created by j7ars on 12.07.2017.
 */
@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service){
        this.mService = service;
    }

    @Provides
    @PerService
    Service provideService() {
        return mService;
    }

    @Provides
    @PerService
    @ServiceContext
    Context provideContext(){
        return mService.getApplicationContext();
    }

}
