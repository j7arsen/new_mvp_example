package in.mvpstarter.sample.ui.base.service;

import android.content.Intent;
import android.util.LongSparseArray;

import java.util.concurrent.atomic.AtomicLong;

import in.mvpstarter.sample.MvpStarterApplication;
import in.mvpstarter.sample.injection.component.ConfigPersistentComponent;
import in.mvpstarter.sample.injection.component.DaggerConfigPersistentComponent;
import in.mvpstarter.sample.injection.component.ServiceComponent;
import in.mvpstarter.sample.injection.module.ServiceModule;
import timber.log.Timber;

/**
 * Created by j7ars on 12.07.2017.
 */

public abstract class BaseMvpService extends BaseService {

    private static final LongSparseArray<ConfigPersistentComponent> componentsArray =
            new LongSparseArray<>();
    private static final AtomicLong NEXT_ID = new AtomicLong(0);

    private long serviceId;

    @Override
    public void onCreate() {
        super.onCreate();
        serviceId = NEXT_ID.getAndIncrement();
        ConfigPersistentComponent configPersistentComponent;
        if (componentsArray.get(serviceId) == null) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", serviceId);
            configPersistentComponent =
                    DaggerConfigPersistentComponent.builder()
                            .applicationComponent(MvpStarterApplication.get(getApplicationContext()).getComponent())
                            .build();
            componentsArray.put(serviceId, configPersistentComponent);
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", serviceId);
            configPersistentComponent = componentsArray.get(serviceId);
        }
        ServiceComponent serviceComponent =
                configPersistentComponent.serviceComponent(new ServiceModule(this));
        inject(serviceComponent);
        attachView();
    }

    protected abstract void inject(ServiceComponent serviceComponent);

    protected abstract void attachView();

    protected abstract void detachPresenter();

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        componentsArray.remove(serviceId);
        detachPresenter();
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public void onDestroy() {
        componentsArray.remove(serviceId);
        detachPresenter();
        super.onDestroy();
    }

}
