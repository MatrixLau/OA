package cn.ma.wb.oa.service.impl;

import cn.ma.wb.oa.mapper.InfoMapper;
import cn.ma.wb.oa.service.InfoService;
import cn.ma.wb.oa.vo.ListModel;
import cn.ma.wb.oa.vo.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<ListModel> getMembershipList() {
        return infoMapper.getMembershipList();
    }

    @Override
    public List<MenuModel> getSideBarList() {
        return infoMapper.getSideBarList();
    }

    @Override
    public List<MenuModel> getSideBarItemList() {
        return infoMapper.getSideBarItemList();
    }

    @Override
    public List<ListModel> getClassesList() {
        return infoMapper.getClassesList();
    }
}
