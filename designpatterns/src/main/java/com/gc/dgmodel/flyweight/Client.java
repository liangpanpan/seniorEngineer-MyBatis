package com.gc.dgmodel.flyweight;

/**
 * 享元模式（Flyweight Pattern）是池技术的重要实现方式，
 * 其定义如下：Use sharing to support large numbers of fine-grained objects efficiently.
 * （使用共享对象可有效地支持大量的细粒度的对象。）
 * 享元模式的定义为我们提出了两个要求：细粒度的对象和共享对象。我们知道分配太多的对象到应用程序中将有损程序的性能，同时还容易造成内存溢出，
 * 那怎么避免呢？
 * 就是享元模式提到的共享技术。我们先来了解一下对象的内部状态和外部状态。
 * 要求细粒度对象，那么不可避免地使得对象数量多且性质相近，那我们就将这些对象的信息分为两个部分：内部状态（intrinsic）与外部状态（extrinsic）。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class Client {
}
