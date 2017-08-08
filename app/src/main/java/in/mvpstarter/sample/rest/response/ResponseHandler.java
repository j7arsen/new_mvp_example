package in.mvpstarter.sample.rest.response;

import in.mvpstarter.sample.data.model.Pair;
import retrofit2.Response;

/**
 * Created by arsen on 08.08.17.
 */

public class ResponseHandler<T>{

    protected Response<T> mResponse;

    public ResponseHandler(Response<T> response){
        this.mResponse = response;
    }

    public <V extends IBaseResponseCallback> void handle(V baseResponseCallback){
        if(mResponse != null){
            if(mResponse.isSuccessful()){
                if(baseResponseCallback != null){
                    baseResponseCallback.onSuccess(new Pair(mResponse.body()));
                }
            } else{
                //TODO check code
                if(mResponse.code() == 401){
                    if(baseResponseCallback instanceof IResponseCallback){
                        ((IResponseCallback) baseResponseCallback).onBadRequest();
                    }
                }
            }
        }
    }
}
