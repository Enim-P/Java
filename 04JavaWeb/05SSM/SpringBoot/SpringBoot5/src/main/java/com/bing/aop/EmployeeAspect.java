package com.bing.aop;

import com.bing.pojo.Employee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 员工切面类
 */
@Component
@Aspect
public class EmployeeAspect {

    @Around("execution(* com.bing.service.EmployeeService.getEmployees(..))")
    public List<Employee> aroundEmployee(ProceedingJoinPoint joinPoint) throws Throwable {
        List<Employee> ret = (List<Employee>)joinPoint.proceed();
        ret.add(new Employee(3,"周杰伦","男","台湾"));
        ret.add(new Employee(4,"张韶涵","女","台湾"));
        return ret;
    }
}
