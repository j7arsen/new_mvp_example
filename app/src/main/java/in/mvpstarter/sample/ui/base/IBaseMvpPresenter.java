package in.mvpstarter.sample.ui.base;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface IBaseMvpPresenter<V extends IBaseMvpView> {

    void attachView(V mvpView);

    void detachView();
}