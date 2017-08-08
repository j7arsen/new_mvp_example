package in.mvpstarter.sample.rest.response;

import in.mvpstarter.sample.data.model.Pair;
import retrofit2.Response;

/**
 * Created by arsen on 08.08.17.
 */

public class ResponseHandler {

    private static ResponseHandler mInstance;

    private ResponseHandler() {
    }

    public static ResponseHandler newInstance() {
        if (mInstance == null) {
            mInstance = new ResponseHandler();
        }
        return mInstance;
    }

    public <V extends IBaseResponseCallback> void handle(int actionCode, Response response, V baseResponseCallback) {
        if (response != null) {
            if (response.isSuccessful()) {
                if(baseResponseCallback != null){
                    baseResponseCallback.onSuccess(actionCode, new Pair(response.body()));
                }
            } else{
                //TODO check code
                if (response.code() == 401) {
                    if(baseResponseCallback instanceof IResponseCallback){
                        ((IResponseCallback) baseResponseCallback).onBadRequest(actionCode);
                    }
                }
            }
        }
    }
}
