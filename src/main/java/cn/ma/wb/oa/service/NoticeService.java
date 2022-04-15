package cn.ma.wb.oa.service;

import cn.ma.wb.oa.vo.ResponseModel;

public interface NoticeService {

    ResponseModel findNotice(String type, Integer class_id);
}
