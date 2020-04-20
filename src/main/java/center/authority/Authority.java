package center.authority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Class:
 * @Type:annotation
 * @Author:cyj
 * @Date:
 * @Description: 需要鉴权在方法上添加此注释
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authority {
    AuthorityEnum action();
}
