package in.mvpstarter.sample.rest.response;

import in.mvpstarter.sample.data.model.Pair;

/**
 * Created by arsen on 08.08.17.
 */

public interface IBaseResponseCallback {

    void onSuccess(int actionCode, Pair data);

    void onError(int actionCode, String message);

}
