package in.mvpstarter.sample.ui.base;


import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Every presenter in the app must either implement this interface and extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface IBaseMvpPresenter<V extends IBaseMvpView> {

    void attachView(V mvpView);

    void detachView();

    void setArguments(Object... params);

    void saveInstanceState(Bundle outState);

    void restoreInstanceState(@NonNull Bundle savedInstanceState);
}
