package in.mvpstarter.sample.ui.base.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import in.mvpstarter.sample.MvpStarterApplication;
import in.mvpstarter.sample.injection.component.ConfigPersistentComponent;
import in.mvpstarter.sample.injection.component.DaggerConfigPersistentComponent;
import in.mvpstarter.sample.injection.component.ViewComponent;
import in.mvpstarter.sample.injection.module.ViewModule;

/**
 * Created by j7ars on 12.07.2017.
 */

public abstract class BaseMvpView extends BaseView{

    private ViewComponent mViewComponent;

    private long viewId;

    public BaseMvpView(Context context) {
        super(context);
    }

    public BaseMvpView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseMvpView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void setupComponent(){
        if(mViewComponent == null){
            ConfigPersistentComponent configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .applicationComponent(MvpStarterApplication.get(
                            this.getContext()).getComponent())
                    .build();
            mViewComponent = configPersistentComponent.viewComponent(new ViewModule(this));
        }
        inject(mViewComponent);
        attachView();
    }

    protected abstract void inject(ViewComponent viewComponent);

    protected abstract void attachView();
}
