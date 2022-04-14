package cn.ma.wb.oa.mapper;

import cn.ma.wb.oa.vo.ListModel;
import cn.ma.wb.oa.vo.MenuModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InfoMapper {

    @Select("select * from membership")
    List<ListModel> getMembershipList();

    @Select("select * from sidebarlist")
    List<MenuModel> getSideBarList();

    @Select("select * from sidebaritemlist")
    List<MenuModel> getSideBarItemList();

    @Select("select * from classlist")
    List<ListModel> getClassesList();
}
