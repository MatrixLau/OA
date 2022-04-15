package cn.ma.wb.oa.service.impl;

import cn.ma.wb.oa.mapper.ClassesMapper;
import cn.ma.wb.oa.pojo.Classes;
import cn.ma.wb.oa.service.ClassesService;
import cn.ma.wb.oa.vo.ResponseModel;
import cn.ma.wb.oa.vo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public ResponseModel findByID(Integer class_id) {
        ResponseModel responseModel = new ResponseModel();
        Classes classes = classesMapper.selectById(class_id);
        if (classes == null){
            return responseModel.response(false, ResultCode.CLASS_MISSING);
        }
        return responseModel.response(true, ResultCode.CLASS_FIND_SUCCESS, null, classes);
    }
}
