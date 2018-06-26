package com.hywa.pricepublish.service.login.impl;

import com.hywa.pricepublish.common.utils.StringUtils;
import com.hywa.pricepublish.dao.entity.Menu;
import com.hywa.pricepublish.dao.entity.MenuExample;
import com.hywa.pricepublish.dao.mapper.MenuMapper;
import com.hywa.pricepublish.service.login.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuServiceIpml implements MenuService{

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public int save(Menu menu) {
        menu=filling(menu,1);
        return menuMapper.insertSelective(menu);
    }

    @Override
    public Menu get(String menuId) {
        return menuMapper.selectByPrimaryKey(menuId);
    }


    @Override
    public int update(Menu menu) {
        menu=filling(menu,2);
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public int delete(String id){
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Menu> select(String parentId) {
        MenuExample menuExa = new MenuExample();
        if (!StringUtils.isEmpty(parentId)) menuExa.createCriteria().andParentIdEqualTo(parentId);
        return menuMapper.selectByExample(menuExa);

    }

    /**
     * 给对数据库操作更改时对数据进行维护
     */
    private Menu filling(Menu menu,int addOrUpdate){
        final  Date date = new Date();
        if(addOrUpdate==1) menu.setCreateTime(date);
        else menu.setUpdateTime(date);
        return menu;
    }

}
