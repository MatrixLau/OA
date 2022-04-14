package cn.ma.wb.oa.controller;

import cn.ma.wb.oa.pojo.Ticket;
import cn.ma.wb.oa.service.TicketService;
import cn.ma.wb.oa.vo.ResponseModel;
import cn.ma.wb.oa.vo.TableRenderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

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
    @RequestMapping("/findBySubmitMID")
    public TableRenderModel findBySubmitMID(int submit_m_id){
        ResponseModel responseModel =  ticketService.findTicketBySubmitMID(submit_m_id);
        return new TableRenderModel(0, responseModel.getObject());
    }

    @ResponseBody
    @RequestMapping("/approval")
    public ResponseModel approvalTicket(Ticket ticket){
        return ticketService.approvalTicket(ticket);
    }
}
