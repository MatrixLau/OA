package cn.ma.wb.oa.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ClassList")
public class Classes {

    @TableId(value = "class_id", type = IdType.AUTO)
    private Integer class_id;
    private String name;
    private String teacher_id;
}
