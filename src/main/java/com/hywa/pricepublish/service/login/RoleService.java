package com.hywa.pricepublish.service.login;

import com.hywa.pricepublish.dao.entity.Role;

import java.util.List;

public interface RoleService {
    List<String> findRoleByUid(String id);

    /**
     * 纯粹增加角色，
     */
    int save(Role role);

    /**
     * 除了其角色基本信息，还有这个角色拥有的菜单项
     */
    Role get(String roleId);
    /**
     * 纯粹更改其基本属性
     */
    int update (Role role);

    /**
     *更改用户的权限菜单,0表示走add,1表示走update
     */
    int saveMenu(List<String> menuList,String roleId,int addOrUpdate);
    /*
     * 根据id来执行逻辑删除
     */
    int delete (String id);

    /**
     * 查看所有的角色
     */
    List<Role> select();
}
