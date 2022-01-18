package com.pp.dgexample.facade;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public interface ILetterProcess {
    //首先要写信的内容
    void writeContext(String context);

    //其次写信封
    void fillEnvelope(String address);

    //把信放到信封里
    void letterInotoEnvelope();

    //然后邮递
    void sendLetter();

}
