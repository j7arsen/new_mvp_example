package in.mvpstarter.sample.injection.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.injection.qualifier.ApplicationContext;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    /*@Provides
    @Singleton
    EventController provideObservableController(){
        return EventController.getInstance();
    }

    @Provides
    @Singleton
    RequestManager provideRequestManager(Retrofit retrofit){
        return RequestManager.getInstance(retrofit);
    }

    @Provides
    @Singleton
    DataManager provideDataManager(RequestManager requestManager){
        return DataManager.getInstance(requestManager);
    }*/


}
