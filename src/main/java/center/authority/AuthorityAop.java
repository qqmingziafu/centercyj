package center.authority;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

@Aspect
public class AuthorityAop {

    private Logger log = Logger.getLogger(AuthorityAop.class);

    @Autowired
    private HttpServletRequest request;

    @Pointcut(value = "@annotation(center.authority.Authority)")
    public void authorrityAOP(){}

    @Around(value= "authorrityAOP()")
    public Object aroundPermission(ProceedingJoinPoint point) {
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable e) {
            log.error("方法执行异常", e);
        }
        return result;
    }
}

