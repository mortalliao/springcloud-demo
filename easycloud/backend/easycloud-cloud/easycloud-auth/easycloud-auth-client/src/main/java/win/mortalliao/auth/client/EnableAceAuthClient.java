package win.mortalliao.auth.client;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author mortal
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfiguration.class)
@Documented
@Inherited
public @interface EnableAceAuthClient {
}
