package cn.ma.wb.oa.vo;

import lombok.Data;

@Data
public class TableRenderModel {

    private int code;
    private Object data;

    public TableRenderModel(int code, Object data){
        this.code = code;
        this.data = data;
    }
}
