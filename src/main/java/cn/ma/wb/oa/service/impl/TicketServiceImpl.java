package cn.ma.wb.oa.service.impl;

import cn.ma.wb.oa.mapper.TicketMapper;
import cn.ma.wb.oa.pojo.Ticket;
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

    @Override
    public ResponseModel addTicket(Ticket ticket) {
        ResponseModel responseModel = new ResponseModel();
        if (ticketMapper.insert(ticket) <= 0) {
            return responseModel.response(false, ResultCode.SUBMIT_FAIL);
        } else {
            return responseModel.response(true, ResultCode.SUBMIT_SUCCESS);
        }
    }

    @Override
    public ResponseModel delTicket(int t_id) {
        return null;
    }

    @Override
    public ResponseModel editTicket(Ticket ticket) {
        return null;
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
        //member = matchInfo(member);
        return responseModel.response(true, ResultCode.TICKET_FIND_SUCCESS, null, tickets);
    }

    @Override
    public ResponseModel approvalTicket(Ticket ticket) {
        return null;
    }
}
