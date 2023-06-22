package com.coderhouse.Clase3.Servicio.REST.externo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.coderhouse.Clase3.Servicio.REST.externo.cotroller.")
}
