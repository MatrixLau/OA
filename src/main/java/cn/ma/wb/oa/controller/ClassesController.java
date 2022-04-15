package cn.ma.wb.oa.controller;

import cn.ma.wb.oa.service.ClassesService;
import cn.ma.wb.oa.vo.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/class")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @RequestMapping("/findByID")
    public ResponseModel findByID(Integer class_id){ return classesService.findByID(class_id);}

}
