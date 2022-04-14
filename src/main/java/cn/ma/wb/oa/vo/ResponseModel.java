package cn.ma.wb.oa.vo;

import jdk.jfr.BooleanFlag;
import lombok.Data;

@Data
public class ResponseModel {

    private boolean flag;
    private String code;
    private String message;
    private String detail;
    private Object object;

    public ResponseModel response(boolean flag, ResultCode resultCode){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setFlag(flag);
        responseModel.setCode(resultCode.getCode());
        responseModel.setMessage(resultCode.getMessage());
        return responseModel;
    }

    public ResponseModel response(boolean flag, ResultCode resultCode, String detail, Object object){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setFlag(flag);
        responseModel.setCode(resultCode.getCode());
        responseModel.setMessage(resultCode.getMessage());
        responseModel.setDetail(detail);
        responseModel.setObject(object);
        return responseModel;
    }
}
