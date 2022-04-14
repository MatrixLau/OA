package cn.ma.wb.oa.mapper;

import cn.ma.wb.oa.pojo.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<Member> {

}
