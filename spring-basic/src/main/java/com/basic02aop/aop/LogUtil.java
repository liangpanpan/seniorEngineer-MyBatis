package com.basic02aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面： 执行切入操作的类，在例子中，就是该类。
 * 切点：在被通知的类上，连接点谈的是一个飘渺的大范围，而切点是一个具体的位置，用于缩小切面所通知的连接点的范围。<br></br>
 * 前面说过，通知定义的是切面的"要做什么"和"在何时做"，是不是没有去哪里做，而切点就定义了"去何处做"。<br>
 * 切点的定义会匹配通知所要织入的一个或多个连接点。我们通常使用明确的类和方法名称，或者是使用<br>
 * 正则表达式定义所匹配的类和方法名称来指定切点。说白了，切点就是让通知找到"发泄的地方"。<br>
 * 连接点：即被通知的类中的方法都可能成为切点，所以这些都是连接点，定义成切点之后，这个连接点就变成了切点，<br>
 * 通知的类可能是一个类，也有可能是一个包底下的所有类，所以连接点可以成千上万来记，是一个虚概念，可以把连接点看成是切点的集合。
 * 通知：切面类有自己要完成的工作，切面类的工作就称为通知。通知定义了切面是做什么以及何时使用。也就是切面内的方法。
 *
 *
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/15       create this file
 * </pre>
 */
@Aspect
@Component
public class LogUtil {

    /**
     * 切点表达式:
     * ..两个点表明多个，*代表一个
     * 表达式代表切入com..service包下的所有类的所有方法，方法参数不限，返回类型不限。
     * 其中访问修饰符可以不写，不能用*，，第一个*代表返回类型不限，第二个*表示所有类，第三个*表示所有方法，..两个点表示方法里的参数不限。
     */
    private final String POINT_CUT = "execution(* com..service.*.*(..))";

    /**
     * 命名切点
     * public 切点可访问性修饰符
     * 与类可访问性修饰符的功能是相同的，它可以决定定义的切点可以在哪些类中可使用。
     * pointCut 切点名称
     * void   返回类型
     * <p>
     * 因为命名切点仅利用方法名及访问修饰符的信息，
     * 一般定义方法的返回类型为 void ，并且方法体为空
     */
    @Pointcut(POINT_CUT)
    public void pointCut() {
    }

    // @Before(value = "execution(* basic02aop..service.*.*(..))")
    @Before(value = "pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("@Before：切点方法之前执行.....");
    }

    @After(value = "pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("@After：切点方法之后执行.....");
    }

    /**
     * 切点方法返回后执行
     * 如果第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning：限定了只有目标方法返回值与通知方法参数类型匹配时才能执行后置返回通知，否则不执行，
     * 参数为Object类型将匹配任何目标返回值
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void doAfter(JoinPoint joinPoint, Object result) {
        System.out.println("@AfterReturning：切点方法返回后执行.....");
        System.out.println("返回值：" + result);
    }


    /**
     * 切点方法抛异常执行
     * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     * throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("@afterThrowing：切点方法抛异常执行.....");
    }

}
