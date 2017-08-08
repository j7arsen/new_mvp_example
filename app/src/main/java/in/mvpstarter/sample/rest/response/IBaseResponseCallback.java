package in.mvpstarter.sample.rest.response;

import in.mvpstarter.sample.data.model.Pair;

/**
 * Created by arsen on 08.08.17.
 */

public interface IBaseResponseCallback {

    void onSuccess(Pair data);

    void onError(String message);

}
