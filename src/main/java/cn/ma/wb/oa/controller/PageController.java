package cn.ma.wb.oa.controller;

import cn.ma.wb.oa.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    HttpSession session;

    @RequestMapping("/panel")
    public String panel(ModelMap map){
        Member member = (Member) session.getAttribute("member");
        map.put("member", member);
        return "panel";
    }

    @RequestMapping("/msg")
    public String msg(ModelMap map, String msg) {
        map.put("msg", msg);
        return "msg";
    }

    @RequestMapping("/permissionMsg")
    public String permissionMsg() {
        return "permissionMsg";
    }

    @RequestMapping("/addMember")
    public String addMember() {
        return "addMember";
    }

    @RequestMapping("/addTicket")
    public String addTikcet(ModelMap map) {
        Member member = (Member) session.getAttribute("member");
        map.put("member", member);
        return "addTicket";
    }

    @RequestMapping("/myTicket")
    public String myTicket(ModelMap map) {
        Member member = (Member) session.getAttribute("member");
        map.put("member", member);
        return "myTicket";
    }

    @RequestMapping("/myApprovalTicket")
    public String processTicket(ModelMap map) {
        Member member = (Member) session.getAttribute("member");
        map.put("member", member);
        return "myApprovalTicket";
    }
}
