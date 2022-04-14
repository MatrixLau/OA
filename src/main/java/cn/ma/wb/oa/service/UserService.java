package cn.ma.wb.oa.service;

import cn.ma.wb.oa.pojo.Member;
import cn.ma.wb.oa.vo.ResponseModel;

public interface UserService {

    ResponseModel addUser(Member member);

    ResponseModel delUser(int m_id);

    ResponseModel editUser(Member member);

    ResponseModel findUserByID(int m_id);

    ResponseModel findUserByUsername(String username);

    Member matchInfo(Member member);

    ResponseModel login(Member member);
}
