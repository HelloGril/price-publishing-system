package com.hywa.pricepublish.service.login;

import com.hywa.pricepublish.dao.entity.Menu;

import java.util.List;

public interface MenuService {

    /**
     * 增加一个菜单的基本信息
     */
    int save(Menu menu);
    /*
    根据菜单id来查看信息详情
     */
    Menu get(String menuId);
    /*
    编辑菜单的信息
     */
    int update (Menu menu);
    /*
    根据id来执行逻辑删除
     */
    int delete (String id);
    /**
     *多条件查询
     */
    List<Menu> select(String parentId);
}
