package cn.ma.wb.oa.vo;

import lombok.Data;

@Data
public class ListModel {

    private int id;
    private String text;
    private String value;

    ListModel(int id, String text, String value) {
        this.id = id;
        this.text = text;
        this.value = value;
    }
}
