package in.mvpstarter.sample.observable;


import in.mvpstarter.sample.ui.base.event.Event;

/**
 * Created by arsen on 07.02.17.
 */

public interface IObserver {

    void onEvent(Event event);

}
