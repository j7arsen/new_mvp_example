package in.mvpstarter.sample.rest.response;

/**
 * Created by arsen on 08.08.17.
 */

public interface IResponseCallback extends IBaseResponseCallback {

    void unAutorized();

    void onBadRequest();

}
