package com.guxingyuan.jdbc.enumeration;

import java.text.MessageFormat;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/8/23       create this file
 * </pre>
 */
public enum ErrorCodeEnum {
    SUCCESS("0", "成功"),
    /**
     * flow通用异常
     */
    RESULT_BACK_SERVER_ERROR("1", "服务器异常"),
    /**
     * web服务器端异常
     */
    RESULT_FRONT_SERVER_ERROR("-1", "服务器端异常"),

    /**
     * 没有访问权限
     */
    RESULT_PERM_ERROR("-7", "没有权限访问响应路径"),
    /**
     * 验证码错误
     */
    RESULT_JCAPTCHA_ERROR("-8", "验证码错误"),
    RESULT_ACCOUNT_LOCKED("-9", "账户被锁定"),


    U0001("U0001", "用户端错误"),
    U0002("U0002", "操作失败：参数值有误！"),
    U0003("U0003", "登录超时，请重新登录！"),
    U0004("U0004", "没有{0}权限"),
    U0005("U0005", "提交数据为空"),
    U0006("U0006", "系统没有授权，不能进行操作"),

    /**
     * U0020-0030是用户信息校验和新增使用
     */
    U0020("U0020", "用户信息不正确"),
    U0021("U0021", "用户账号存在"),
    U0022("U0022", "两次输入密码不一致"),
    U0023("U0023", "邮箱格式不正确"),
    U0024("U0024", "电话格式不正确"),
    U0025("U0025", "原密码输入错误"),
    U0026("U0026", "请求非法,不能修改其他账户密码！"),
    U0027("U0027", "密码格式不正确！"),
    U0028("U0028", "用户状态不正确！"),
    U0029("U0029", "系统内置用户不可删除！"),
    U0030("U0030", "用户姓名格式不正确"),
    U0031("U0031", "账号不可为空"),
    U0032("U0032", "密码不可为空"),
    U0033("U0033", "用户姓名不可为空"),
    U0034("U0034", "邮箱不可为空"),
    U0035("U0035", "用户角色不可为空"),
    U0036("U0036", "用户账号格式不正确"),
    U0037("U0037", "密码长度8到16位，至少包含大写字母、小写字母、数字(不能存在空格)"),


    U0100("U0100", "{0}不可以为空"),
    U0101("U0101", "{0}格式不正确"),
    U0102("U0102", "存在相同的【{0}】信息"),
    U0109("U0109", "{0}"),

    U0110("U0110", "查询页码输入错误"),

    U0200("U0200", "{0}配置为空"),
    U0201("U0201", "SYSLOG添加配置IP重复"),

    /**
     * 已进行SIC级联配置，不允许进行本地指示器策略管理。返回：当前设备已进入级联状态，不可进行本地策略配置操作
     */
    U0300("U0300", "当前设备已进入级联状态，不可进行本地策略配置操作"),
    U0301("U0301", "已存在情报策略"),

    /**
     * 400-410 预分配为授权文件使用
     */
    U0400("U0400", "{0}"),
    U0401("U0401", "授权文件解析失败"),
    U0402("U0402", "授权文件错误！"),
    U0403("U0403", "授权文件处理异常，请稍后再试"),
    U0405("U0405", "授权文件名称不正确"),
    U0406("U0406", "licence认证有误"),
    U0407("U0407", "流量引擎授权失败"),

    U0501("U0501", "{0}不可为空"),

    /**
     * 该错误指代系统处理异常后，统一给前端系统返回错误。非ResponseResultAdvice中不要使用
     */
    S0000("S0000", "系统处理错误"),

    E0000("E0000", "{0}"),
    E0001("E0001", "系统异常"),
    E0002("E0002", "系统执行操作失败"),
    E0003("E0003", "后台更新异常"),
    E0004("E0004", "系统处理数据异常"),
    E0005("E0005", "威胁情报同步中，不允许更新"),
    E0006("E0006", "云端返回异常{0}"),
    E0007("E0007", "网络异常"),
    E0008("E0008", "系统加密异常"),


    E0100("E0100", "防护网络配置不存在"),

    E0200("E0200", "访问后台系统异常"),

    E0300("E0300", "时间设置异常"),

    // 命令使用
    E0400("E0400", "{0}"),
    E0401("E0401", "传输协议转换异常"),

    E0500("E0500", "文件不存在"),
    E0501("E0501", "文件创建失败"),

    E0801("E0800", "未授权"),

    E0901("E0901", "监控信息为空"),
    E0902("E0902", "监控时间与当前时间不匹配"),

    E1000("E1000", "{0}为空"),
    E1001("E1001", "{0}异常"),
    E1002("E1002", "开始{0}失败"),

    E1100("E1100", "文件不存在"),

    E2000("E2000", "系统繁忙，请稍后下载"),

    D0000("D0000", "{0}"),
    D0001("D0001", "调用数据库服务出错"),
    D0002("D0002", "DAO层保存失败"),
    D0003("D0003", "数据查询失败"),
    D0004("D0004", "{0}查询为空"),
    D0005("D0005", "{0}数据执行失败"),
    D0006("D0006", "{0}含有特殊字符！"),

    F0001("F0001", "主路部署模式中必须配置网路出口与入口！"),
    F0002("F0002", "旁路部署模式中必须配置一种流量方式！"),
    F0003("F0003", "旁路部署模式中最多配置一个阻断流量方式！"),
    ;


    private String errorCode;
    private String errorMessage;

    ErrorCodeEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 返回可以替换的消息内容
     *
     * @param args
     * @return
     */
    public String getErrorMessage(Object... args) {
        return MessageFormat.format(errorMessage, args);
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * 通过errorCode获取对应的枚举值
     *
     * @param errorCode 错误code
     * @return
     */
    public static ErrorCodeEnum getErrorCodeEnum(String errorCode) {
        for (ErrorCodeEnum errorCodeEnum : ErrorCodeEnum.values()) {
            if (errorCodeEnum.getErrorCode().equals(errorCode)) {
                return errorCodeEnum;
            }
        }
        return null;
    }

}
