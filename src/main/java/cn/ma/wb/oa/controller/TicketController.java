package cn.ma.wb.oa.controller;

import cn.ma.wb.oa.pojo.Member;
import cn.ma.wb.oa.pojo.Ticket;
import cn.ma.wb.oa.service.TicketService;
import cn.ma.wb.oa.vo.ResponseModel;
import cn.ma.wb.oa.vo.TableRenderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private HttpSession session;

    @ResponseBody
    @RequestMapping("/add")
    public ResponseModel addTicket(Ticket ticket){
        return ticketService.addTicket(ticket);
    }

    @ResponseBody
    @RequestMapping("/del")
    public ResponseModel delTicket(int t_id){
        return ticketService.delTicket(t_id);
    }

    @ResponseBody
    @RequestMapping("/edit")
    public ResponseModel editTicket(Ticket ticket){
        return ticketService.editTicket(ticket);
    }

    @ResponseBody
    @RequestMapping("/findByID")
    public ResponseModel findByID(int t_id){ return ticketService.findTicketByID(t_id);}

    @ResponseBody
    @RequestMapping("/findBySubmitMID")
    public TableRenderModel findBySubmitMID(int submit_m_id){
        ResponseModel responseModel =  ticketService.findTicketBySubmitMID(submit_m_id);
        return new TableRenderModel(0, responseModel.getObject());
    }

    @ResponseBody
    @RequestMapping("/findByApprovalMID")
    public TableRenderModel findByApprovalMID(int approval_m_id){
        ResponseModel responseModel =  ticketService.findTicketByApprovalMID(approval_m_id);
        return new TableRenderModel(0, responseModel.getObject());
    }

//    @ResponseBody
//    @RequestMapping("/findByApprovalMID")
//    public ResponseModel findByApprovalMID(int approval_m_id){
//        return ticketService.findTicketByApprovalMID(approval_m_id);
//    }

    @ResponseBody
    @RequestMapping("/submit")
    public ResponseModel submitTicket(int t_id){
        return ticketService.submitTicket(t_id);
    }
}
