package in.mvpstarter.sample.injection.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.mvpstarter.sample.app.Constants;
import in.mvpstarter.sample.rest.Urls;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arsen on 10.02.17.
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(Constants.TIMEOUT, TimeUnit.SECONDS);
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Urls.BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

}
