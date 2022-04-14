package cn.ma.wb.oa.controller;

import cn.ma.wb.oa.service.InfoService;
import cn.ma.wb.oa.vo.ListModel;
import cn.ma.wb.oa.vo.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @ResponseBody
    @RequestMapping("/getMembershipList")
    public List<ListModel> getMembershipList(){
        return infoService.getMembershipList();
    }

    @ResponseBody
    @RequestMapping("/getSideBarList")
    public List<MenuModel> getSideBarList(){
        return infoService.getSideBarList();
    }

    @ResponseBody
    @RequestMapping("/getSideBarItemList")
    public List<MenuModel> getSideBarItemList(){
        return infoService.getSideBarItemList();
    }

    @ResponseBody
    @RequestMapping("/getClassesList")
    public List<ListModel> getClassesList(){
        return infoService.getClassesList();
    }

    @ResponseBody
    @RequestMapping("/getFindMemberMethod")
    public List<ListModel> getFindMemberMethod(){ return infoService.getFindMemberMethod(); }
}
