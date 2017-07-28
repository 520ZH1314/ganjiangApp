package moye.ganjiang.com.ganjiang.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 * 验证手机号是否注册
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface RegistOrLoginUrl {
}
