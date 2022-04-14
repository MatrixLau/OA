package cn.ma.wb.oa.service.impl;

import cn.ma.wb.oa.mapper.UserMapper;
import cn.ma.wb.oa.pojo.ConstElements;
import cn.ma.wb.oa.pojo.Member;
import cn.ma.wb.oa.vo.ResponseModel;
import cn.ma.wb.oa.service.UserService;
import cn.ma.wb.oa.util.SaltUtils;
import cn.ma.wb.oa.vo.ResultCode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseModel addUser(Member member){
        ResponseModel responseModel = new ResponseModel();
        String salt = SaltUtils.getSalt();
        String password = member.getPassword();
        password = SaltUtils.saltEncrypt(password, salt);
        member.setSalt(salt);
        member.setPassword(password);
        if (userMapper.insert(member) <= 0) {
            return responseModel.response(false, ResultCode.ADD_FAIL);
        } else {
            return responseModel.response(true, ResultCode.ADD_SUCCESS);
        }
    }

    @Override
    public ResponseModel delUser(int m_id){
        ResponseModel responseModel = new ResponseModel();
        if (userMapper.deleteById(m_id) <= 0) {
            return responseModel.response(false, ResultCode.DEL_FAIL);
        }
        return responseModel.response(true, ResultCode.DEL_SUCCESS);
    }

    @Override
    public ResponseModel editUser(Member member) {
        ResponseModel responseModel = new ResponseModel();
//            Member ori = (Member) findUserByID(member.getM_id()).getObject();
//            if (ori == null) return responseModel.response(false, ResultCode.ID_MISSING);
        if (userMapper.updateById(member) <= 0)  return responseModel.response(false, ResultCode.EDIT_FAIL);
        member = (Member) findUserByID(member.getM_id()).getObject();
        return responseModel.response(true, ResultCode.EDIT_SUCCESS, null, member);
        }

    @Override
    public ResponseModel findUserByID(int m_id) {
        ResponseModel responseModel = new ResponseModel();
        Member member = userMapper.selectById(m_id);
        if (member == null){
            return responseModel.response(false, ResultCode.ID_MISSING);
        }
        //member = matchInfo(member);
        return responseModel.response(true, ResultCode.FIND_SUCCESS, null, member);
    }

    @Override
    public ResponseModel findUserByUsername(String username) {
        ResponseModel responseModel = new ResponseModel();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        Member member = userMapper.selectOne(queryWrapper);
        if (member == null){
            return responseModel.response(false, ResultCode.USERNAME_MISSING);
        }
        //member = matchInfo(member);
        return responseModel.response(true, ResultCode.FIND_SUCCESS, null, member);
    }

    @Override
    public ResponseModel login(Member member) {
        ResponseModel responseModel = new ResponseModel();
        Member memberConfirm = (Member) findUserByUsername(member.getUsername()).getObject();
        if ( memberConfirm == null ) return responseModel.response(false, ResultCode.USERNAME_MISSING);
        if ( !memberConfirm.getPassword().equals(SaltUtils.saltEncrypt(member.getPassword(),
                memberConfirm.getSalt()))) return responseModel.response(false, ResultCode.PASSWORD_ERROR);
        return responseModel.response(true, ResultCode.LOGIN_SUCCESS, null, memberConfirm);
    }

    public Member matchInfo(Member member){
        Map<String, Integer> map = ConstElements.MEMBERSHIP;
        for(Map.Entry<String, Integer> entry : map.entrySet())
            if (member.getMembership().equals(entry.getValue().toString()))
                member.setMembership(entry.getKey());
        if(member.getMembership().matches("[0-9]"))
            member.setMembership(ConstElements.MEMBERSHIP_UNKNOWN);
        map = ConstElements.SEX;
        for(Map.Entry<String, Integer> entry : map.entrySet())
            if (member.getSex().equals(entry.getValue().toString()))
                member.setSex(entry.getKey());
        if(member.getSex().matches("[0-9]"))
            member.setSex(ConstElements.SEX_UNKNOWN);
        return member;
    }

}
