package com.gc.dgmodel.staticproxy;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class Proxy implements Subject {
        //要代理哪个实现类
        private Subject subject = null;

        //通过构造函数传递代理者
        public Proxy(Subject subject) {
            this.subject = subject;
        }

        //实现接口中定义的方法
        public void request() {
            this.before();
            this.subject.request();
            this.after();
        }

        //预处理
        private void before() {
            //do something
            System.out.println("before");
        }

        //善后处理
        private void after() {
            //do something
            System.out.println("after");
        }
    }
