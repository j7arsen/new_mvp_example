package in.mvpstarter.sample.data.model;

/**
 * Created by arsen on 07.02.17.
 */

public class Pair<T> {

    private T mValue;

    public Pair(T value){
        this.mValue = value;
    }

    public Object getValue() {
        return mValue;
    }

    public void setValue(T value) {
        this.mValue = value;
    }

}
