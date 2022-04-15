package cn.ma.wb.oa.service.impl;

import cn.ma.wb.oa.mapper.NoticeMapper;
import cn.ma.wb.oa.pojo.Notice;
import cn.ma.wb.oa.service.NoticeService;
import cn.ma.wb.oa.vo.ResponseModel;
import cn.ma.wb.oa.vo.ResultCode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public ResponseModel findNotice(String type, Integer class_id) {
        ResponseModel responseModel = new ResponseModel();
        QueryWrapper queryWrapper = new QueryWrapper();
        if (type.equals("school")){
            queryWrapper.eq("type", type);
        }else{
            queryWrapper.eq("type", type);
            queryWrapper.eq("class_id", class_id);
        }
        List<Notice> notices = noticeMapper.selectList(queryWrapper);
        if (notices.size() == 0){
            return responseModel.response(false, ResultCode.NOTICE_MISSING);
        }
        return responseModel.response(true, ResultCode.NOTICE_FIND_SUCCESS, null, notices);
    }
}
