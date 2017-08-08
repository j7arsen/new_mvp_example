package in.mvpstarter.sample.rest;

import retrofit2.Response;

/**
 * Created by arsen on 07.02.17.
 */

public interface IRequestCallback {

    void onStartRequest();

    void onFinishRequest();

    void onErrorResponse(Throwable e);

    void onSuccessResponse(Response response);

}