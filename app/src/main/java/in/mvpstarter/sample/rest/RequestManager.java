package in.mvpstarter.sample.rest;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.mvpstarter.sample.data.UserData;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;

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

    public Observable<Response<UserData>> getUserData() {
        return createService(GetUserService.class).getUserData();
    }


}
