package yy.hao.com.testphonemvp.dagger2;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by QingMei on 2017/6/15.
 * desc:
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
