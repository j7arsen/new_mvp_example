package in.mvpstarter.sample.ui.base.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by j7ars on 12.07.2017.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    protected final View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.mItemView = itemView;
    }

}
