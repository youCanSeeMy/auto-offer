package zy.core.model;

/**
 * @program: auto-offer
 * @description: 返回参数
 * @author: 张钰
 * @create: 2020-09-01 15:51
 **/
public class ResponseData {

    public static final int successCode =  200;
    public static final String successMessage = "请求成功";
    public static final int errorCode = 500;
    public static final String errorMessage = "请求失败";

    public int code;

    public String message;

    public Object result;


    public ResponseData() {
    }

    public ResponseData(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static ResponseData success(){return new ResponseData(successCode,successMessage,null);}

    public static ResponseData success(Object result){return new ResponseData(successCode,successMessage,result);}

    public static ResponseData error(){return new ResponseData(errorCode,errorMessage,null);}
}
