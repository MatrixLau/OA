package cn.ma.wb.oa.controller;

import cn.ma.wb.oa.pojo.Member;
import cn.ma.wb.oa.vo.ResponseModel;
import cn.ma.wb.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public HttpSession session;

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/add")
    public ResponseModel addUser(Member member) { return userService.addUser(member); }

    @ResponseBody
    @RequestMapping("/delByID")
    public ResponseModel delUserByID(int m_id) {
        return userService.delUser(m_id);
    }

    @ResponseBody
    @RequestMapping("/edit")
    public ResponseModel editUser(Member member){
        return userService.editUser(member);
    }

    @ResponseBody
    @RequestMapping("/findByID")
    public ResponseModel findUseByID(int m_id){
        return userService.findUserByID(m_id);
    }

    @ResponseBody
    @RequestMapping("/findByUsername")
    public ResponseModel findUseByUsername(String username){
        return userService.findUserByUsername(username);
    }

    @ResponseBody
    @RequestMapping("/findByMethod")
    public ResponseModel findUseByMethod(String method, String keyword){
        return userService.findUserByMethod(method, keyword);
    }

    @ResponseBody
    @RequestMapping("/matchInfo")
    public Member matchInfo(Member member){ return userService.matchInfo(member);}

    @ResponseBody
    @RequestMapping("/login")
    public ResponseModel login(Member member) {
        ResponseModel responseModel = userService.login(member);
        member = (Member) responseModel.getObject();
        session.setAttribute("member", member);
        return responseModel;
    }

    @RequestMapping("/logout")
    public String logout(ModelMap map) {
        map.put("msg", "成功登出系统！");
        session.removeAttribute("member");
        return "msg";
    }
}
