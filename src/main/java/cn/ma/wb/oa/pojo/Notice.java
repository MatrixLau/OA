package cn.ma.wb.oa.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("NoticeList")
public class Notice {

    @TableId(value = "n_id", type = IdType.AUTO)
    private int n_id;
    private String detail;
    private String time;
    private String type;
    private String class_id;

}
