package cn.ma.wb.oa.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Ticket")
public class Ticket {

    private int t_id;
    private int submit_m_id;
    private String title;
    private String detail;

    private boolean approval;
    private int approval_m_id;
    private String approval_advice;

}
