package com.pp.dgexample.composite;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public class Leaf extends Corp {
    //就写一个构造函数，这个是必需的
    public Leaf(String _name, String _position, int _salary) {
        super(_name, _position, _salary);
    }
}
