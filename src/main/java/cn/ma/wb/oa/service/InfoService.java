package cn.ma.wb.oa.service;

import cn.ma.wb.oa.vo.ListModel;
import cn.ma.wb.oa.vo.MenuModel;

import java.util.List;

public interface InfoService {

    List<ListModel> getMembershipList();

    List<MenuModel> getSideBarList();

    List<MenuModel> getSideBarItemList();

    List<ListModel> getClassesList();
}
