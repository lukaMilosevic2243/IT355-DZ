package com.bizdash;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Log {
    
    private final Logger log = Logger.getLogger(""); 
    
    @Before("execution(* com.bizdash.MainController.*(..))")
    public void logBefore(JoinPoint point){
        log.info("Point Start: " + point.getSignature().getName());
    }
    
    @After("execution(* com.bizdash.MainController.*(..))")
    public void logAfter(JoinPoint point){
        log.info("Point End: " + point.getSignature().getName());
    }
    
    
    
}
