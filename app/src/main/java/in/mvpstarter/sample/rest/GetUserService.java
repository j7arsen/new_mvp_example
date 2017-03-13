package in.mvpstarter.sample.rest;

import in.mvpstarter.sample.data.UserData;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by arsen on 07.02.17.
 */

public interface GetUserService {

    @GET(Urls.GET_USER)
    Observable<UserData> getUserData();

}
