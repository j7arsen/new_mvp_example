package in.mvpstarter.sample.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by j7ars on 12.07.2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerView {
}
