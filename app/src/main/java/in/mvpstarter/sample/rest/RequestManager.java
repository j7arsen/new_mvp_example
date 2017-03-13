package in.mvpstarter.sample.rest;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.mvpstarter.sample.data.UserData;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by arsen on 07.02.17.
 */
@Singleton
public class RequestManager {

    private Retrofit mRetrofit;

    @Inject
    public RequestManager(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    public Observable<UserData> getUserData(Class<GetUserService> serviceClass) {
        return createService(serviceClass).getUserData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
