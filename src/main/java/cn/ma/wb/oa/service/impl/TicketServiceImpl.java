package cn.ma.wb.oa.service.impl;

import cn.ma.wb.oa.mapper.ClassesMapper;
import cn.ma.wb.oa.mapper.TicketMapper;
import cn.ma.wb.oa.mapper.UserMapper;
import cn.ma.wb.oa.pojo.Member;
import cn.ma.wb.oa.pojo.Ticket;
import cn.ma.wb.oa.pojo.Classes;
import cn.ma.wb.oa.service.TicketService;
import cn.ma.wb.oa.vo.ResponseModel;
import cn.ma.wb.oa.vo.ResultCode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public ResponseModel addTicket(Ticket ticket) {
        ResponseModel responseModel = new ResponseModel();
        String submitMembership = ticket.getSubmit_membership();
        String submitMID = ticket.getSubmit_m_id();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        if (submitMembership.compareTo("0") > 0){
            if (submitMembership.compareTo("1") > 0) {
                ticket.setApproval_m_id(submitMID);
            }else {
                queryWrapper.eq("membership", "2");
                Member approvaler = userMapper.selectOne(queryWrapper);
                if (approvaler == null) return responseModel.response(false, ResultCode.USER_MISSING);
                ticket.setApproval_m_id(String.valueOf(approvaler.getM_id()));
            }
        } else {
            Classes classes = classesMapper.selectById(ticket.getSubmit_class());
            if (classes == null) return responseModel.response(false, ResultCode.USER_MISSING);
            ticket.setApproval_m_id(classes.getTeacher_id());
        }
        if (ticketMapper.insert(ticket) <= 0) {
            return responseModel.response(false, ResultCode.TICKET_SUBMIT_FAIL);
        } else {
            return responseModel.response(true, ResultCode.TICKET_SUBMIT_SUCCESS);
        }
    }

    @Override
    public ResponseModel delTicket(int t_id) {
        ResponseModel responseModel = new ResponseModel();
        if (ticketMapper.deleteById(t_id) <= 0) {
            return responseModel.response(false, ResultCode.TICKET_DEL_FAIL);
        }
        return responseModel.response(true, ResultCode.TICKET_DEL_SUCCESS);
    }

    @Override
    public ResponseModel editTicket(Ticket ticket) {
        ResponseModel responseModel = new ResponseModel();
        if (ticketMapper.updateById(ticket) <= 0)  return responseModel.response(false, ResultCode.TICKET_EDIT_FAIL);
        ticket = (Ticket) findTicketByID(ticket.getT_id()).getObject();
        return responseModel.response(true, ResultCode.TICKET_EDIT_SUCCESS, null, ticket);
    }

    @Override
    public ResponseModel findTicketByID(int t_id) {
        ResponseModel responseModel = new ResponseModel();
        Ticket ticket = ticketMapper.selectById(t_id);
        if (ticket == null){
            return responseModel.response(false, ResultCode.TICKET_MISSING);
        }
        return responseModel.response(true, ResultCode.TICKET_FIND_SUCCESS, null, ticket);
    }

    @Override
    public ResponseModel findTicketBySubmitMID(int submit_m_id) {
        ResponseModel responseModel = new ResponseModel();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("submit_m_id", submit_m_id);
        List tickets = ticketMapper.selectList(queryWrapper);
        if (tickets.size() <= 0){
            return responseModel.response(false, ResultCode.TICKET_MISSING);
        }
        return responseModel.response(true, ResultCode.TICKET_FIND_SUCCESS, null, tickets);
    }

    @Override
    public ResponseModel findTicketByApprovalMID(int approval_m_id) {
        ResponseModel responseModel = new ResponseModel();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("approval_m_id", approval_m_id);
        List tickets = ticketMapper.selectList(queryWrapper);
        if (tickets.size() <= 0){
            return responseModel.response(false, ResultCode.TICKET_MISSING);
        }
        return responseModel.response(true, ResultCode.TICKET_FIND_SUCCESS, null, tickets);
    }

    @Override
    public ResponseModel submitTicket(int t_id) {
        ResponseModel responseModel = new ResponseModel();
        Ticket ticket = ticketMapper.selectById(t_id);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("membership", "2");
        Member approvaler = userMapper.selectOne(queryWrapper);
        if (approvaler == null) return responseModel.response(false, ResultCode.USER_MISSING);
        ticket.setApproval_m_id(String.valueOf(approvaler.getM_id()));
        return editTicket(ticket);
    }
}
