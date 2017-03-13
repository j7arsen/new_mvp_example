package in.mvpstarter.sample.observable;

import in.mvpstarter.sample.data.model.Pair;

/**
 * Created by arsen on 07.02.17.
 */

public interface IRequestCallback {

    void onErrorResponse(int action, Throwable e);

    void onSuccessResponse(int action, Pair successData);

}