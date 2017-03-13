package in.mvpstarter.sample.injection.module;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.app.Constants;
import in.mvpstarter.sample.data.DataManager;
import in.mvpstarter.sample.injection.ApplicationContext;
import in.mvpstarter.sample.observable.ObservableController;
import in.mvpstarter.sample.rest.RequestManager;
import in.mvpstarter.sample.rest.Urls;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
    ObservableController provideObservableController(){
        return ObservableController.getInstance();
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
