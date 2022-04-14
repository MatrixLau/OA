package cn.ma.wb.oa.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Member")
public class Member {

//    @TableField(updateStrategy = FieldStrategy.IGNORED)
    @TableId(value = "m_id", type = IdType.AUTO)
    private int m_id;
    private String name;
    private String sex;
    private String membership;

    private int class_id;

    private String username;
    private String password;
    private String salt;

}
