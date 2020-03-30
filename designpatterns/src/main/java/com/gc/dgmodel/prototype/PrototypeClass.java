package com.gc.dgmodel.prototype;

/**
 * @Title 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * @Description
 * @Author ppliang
 * @Date 2020/3/30
 */
public class PrototypeClass implements Cloneable {

    //覆写父类Object方法
    @Override
    public PrototypeClass clone() {
        PrototypeClass prototypeClass = null;
        try {
            prototypeClass = (PrototypeClass) super.clone();
        } catch (CloneNotSupportedException e) {
            //异常处理
        }
        return prototypeClass;
    }
}
