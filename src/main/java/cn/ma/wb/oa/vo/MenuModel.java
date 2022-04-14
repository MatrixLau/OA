package cn.ma.wb.oa.vo;

import lombok.Data;

@Data
public class MenuModel {

    private int bar_id;
    private int bar_item_id;

    private String name;
    private String url;
    private String level;


    //barMenu
    MenuModel(int bar_id, String name, String url, String level) {
        this.bar_id = bar_id;
        this.name = name;
        this.url = url;
        this.level = level;
    }

    //barItem
    MenuModel(int bar_id, int bar_item_id, String name, String url, String level) {
        this.bar_id = bar_id;
        this.bar_item_id = bar_item_id;
        this.name = name;
        this.url = url;
        this.level = level;
    }



}
