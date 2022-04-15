package cn.ma.wb.oa.controller;

import cn.ma.wb.oa.service.NoticeService;
import cn.ma.wb.oa.vo.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @ResponseBody
    @RequestMapping("/findSchoolNotice")
    public ResponseModel findSchoolNotice(){
        return noticeService.findSchoolNotice();
    }
}
