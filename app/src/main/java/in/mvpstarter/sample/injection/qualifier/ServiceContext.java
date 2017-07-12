package in.mvpstarter.sample.injection.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by j7ars on 12.07.2017.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceContext {
}
