package cn.ma.wb.oa.service;

import cn.ma.wb.oa.pojo.Ticket;
import cn.ma.wb.oa.vo.ResponseModel;

public interface TicketService {

    ResponseModel addTicket(Ticket ticket);

    ResponseModel delTicket(int t_id);

    ResponseModel editTicket(Ticket ticket);

    ResponseModel findTicketByID(int t_id);

    ResponseModel findTicketBySubmitMID(int submit_m_id);

    ResponseModel findTicketByApprovalMID(int approval_m_id);

    ResponseModel approvalTicket(Ticket ticket);

    ResponseModel submitTicket(int t_id);
}
