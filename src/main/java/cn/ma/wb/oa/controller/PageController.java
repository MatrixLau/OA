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

    @RequestMapping("/delMember")
    public String delMember() {
        return "delMember";
    }

    @RequestMapping("/editMember")
    public String editMember() {
        return "editMember";
    }

    @RequestMapping("/findMember")
    public String findMember(ModelMap map) {
        Member member = (Member) session.getAttribute("member");
        map.put("member", member);
        return "findMember";
    }

    @RequestMapping("/notice")
    public String notice(ModelMap map, String type) {
        Member member = (Member) session.getAttribute("member");
        map.put("type", type);
        map.put("member", member);
        return "notice";
    }

    @RequestMapping("/manageNotice")
    public String manageNotice(ModelMap map) {
        Member member = (Member) session.getAttribute("member");
        map.put("member", member);
        return "manageNtice";
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
