package com.zbq.websocket.config;

public class Result<T> {
    /** 错误码. */
    private String errorCode;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;

    /** 分页查询时数据的总条数*/
    private Long total;
    /**
     * @return String
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode String
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return String
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg String
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return T
     */
    public T getData() {
        return data;
    }

    /**
     * @param data t
     */
    public void setData(T data) {
        this.data = data;
    }


    /**
     * @return int
     */
    public Long getTotal(){
        return total;
    }

    /**
     * @param total int
     */
    public void setTotal(Long total){
        this.total = total;
    }
}
