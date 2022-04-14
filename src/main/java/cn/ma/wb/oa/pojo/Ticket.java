package cn.ma.wb.oa.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Ticket")
public class Ticket {

    @TableId(value = "t_id", type = IdType.AUTO)
    private int t_id;
    private String submit_m_id;
    private String submit_membership;
    private String title;
    private String detail;

    private boolean approval;
    private String approval_m_id;
    private String approval_advice;

}
