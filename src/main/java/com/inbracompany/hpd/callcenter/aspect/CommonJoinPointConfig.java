package com.inbracompany.hpd.callcenter.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {


	@Pointcut("@annotation(com.inbracompany.hpd.callcenter.annotation.TrackMessageOrg)")
	public void trackMessageOrg(){}
	
	
	@Pointcut("execution(* com.inbracompany.hpd.callcenter.annotation..*.*(..))")
	public void logAllMethods(){}
	
	@Pointcut("execution(* com.inbracompany.hpd.callcenter.annotation.*.*.*(..)) && execution(* com.inbracompany.hpd.callcenter.annotation.*.*.*())")
	public void logAllExceptions(){}

}
