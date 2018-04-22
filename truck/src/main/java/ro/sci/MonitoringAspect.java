package ro.sci;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitoringAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(MonitoringAspect.class);
    //&& @annotation(auditable)
    //&& @annotation(monitoring)
    @Around(value = "execution(* ro.sci.controller.*.*(..)) ")
    public Object audit(final ProceedingJoinPoint call) throws Throwable {

        long start = System.currentTimeMillis();
        try {
            return call.proceed();
        }finally {

            LOGGER.info(call.getSignature().getName()
                    +": " + (System.currentTimeMillis() - start) + " ms");
        }

    }



}
