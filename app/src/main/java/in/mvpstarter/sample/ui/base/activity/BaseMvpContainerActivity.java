package in.mvpstarter.sample.ui.base.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.mvpstarter.sample.R;

/**
 * Created by j7ars on 12.07.2017.
 */

public abstract class BaseMvpContainerActivity extends BaseMvpActivity {

    @BindView(R.id.navigation_bar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }

    protected abstract void openFragment();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
