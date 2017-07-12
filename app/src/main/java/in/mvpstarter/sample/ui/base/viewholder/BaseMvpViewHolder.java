package in.mvpstarter.sample.ui.base.viewholder;

import android.view.View;

import in.mvpstarter.sample.MvpStarterApplication;
import in.mvpstarter.sample.injection.component.ConfigPersistentComponent;
import in.mvpstarter.sample.injection.component.DaggerConfigPersistentComponent;
import in.mvpstarter.sample.injection.component.ViewHolderComponent;
import in.mvpstarter.sample.injection.module.ViewHolderModule;
import in.mvpstarter.sample.injection.module.ViewModule;

/**
 * Created by j7ars on 12.07.2017.
 */

public abstract class BaseMvpViewHolder extends BaseViewHolder {

    private ViewHolderComponent mViewHolderComponent;

    protected final View mItemView;

    public BaseMvpViewHolder(View itemView) {
        super(itemView);
        this.mItemView = itemView;
    }

    protected void setupComponent(){
        if(mViewHolderComponent == null){
            ConfigPersistentComponent configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .applicationComponent(MvpStarterApplication.get(
                            mItemView.getContext()).getComponent())
                    .build();
            mViewHolderComponent = configPersistentComponent.viewHolderComponent(new ViewHolderModule(this));
        }
        inject(mViewHolderComponent);
        attachView();
    }

    protected abstract void inject(ViewHolderComponent viewHolderComponent);

    protected abstract void attachView();

}
