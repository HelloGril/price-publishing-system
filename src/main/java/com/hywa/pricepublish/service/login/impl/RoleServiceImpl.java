//package com.hywa.pricepublish.service.login.impl;
//
//import com.hywa.pricepublish.common.exception.GlobalException;
//import com.hywa.pricepublish.config.redis.RedisUser;
//import com.hywa.pricepublish.dao.entity.Role;
//import com.hywa.pricepublish.dao.entity.RoleExample;
//import com.hywa.pricepublish.dao.mapper.RoleMapper;
//import com.hywa.pricepublish.dao.mapper.RoleMenuMapper;
//import com.hywa.pricepublish.service.login.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//@Transactional
//public class RoleServiceImpl implements RoleService {
//    @Autowired
//    private RoleMapper roleMapper;
//    @Autowired
//    private RedisUser redisUser;
//    @Autowired
//    private RoleMenuMapper roleMenuMapper;
//
//    @Override
//    public List<String> findRoleByUid(String id) {
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public int save(Role role) {
//        filling(role, 1);
//        final int addnum = roleMapper.insert(role);
//        if (addnum != 1) throw new GlobalException("数据库角色新建失败");
//        return 1;
//    }
//
//    @Override
//    public Role get(String roleId) {
//        try {
//            return roleMapper.selectByPrimaryKey(roleId);
//        } catch (Exception e) {
//            throw new GlobalException("可能是一对多的关系型映射错误");
//        }
//    }
//
//    @Override
//    public int update(Role role) {
//        return roleMapper.updateByPrimaryKeySelective(role);
//    }
//
//    @Override
//    @Transactional
//    public int saveMenu(List<String> menuList, String roleId, int addOrUpdate) {
//        final int menuSize = menuList.size();
//        if (addOrUpdate == 0) {
//            final int addmenu = roleMenuMapper.insertList(menuList, roleId);
//            if (addmenu != menuSize) throw new GlobalException("数据库新增角色授权时失败");
//        } else {
//            final int menuNum = roleMenuMapper.selectCountByRoleId(roleId);//查询出现在这个角色有的菜单项目数
//            final int deletemenu = roleMenuMapper.deleteByPrimaryKey(roleId);
//            if (menuNum != deletemenu) throw new GlobalException("数据库编辑角色删除原来授权时失败");
//            final int addmenu = roleMenuMapper.insertList(menuList, roleId);
//            if (addmenu != menuSize) throw new GlobalException("数据库编辑角色增加授权时失败");
//        }
//        return 1;
//    }
//
//    @Override
//    public int delete(String id) {
//        final int num = roleMapper.deleteByPrimaryKey(id);//逻辑删除掉这个角色
//        if (num != 1) throw new GlobalException("数据库删除角色时失败");
//        final int menuNum = roleMenuMapper.selectCountByRoleId(id);//查询出现在这个角色有的菜单项目数
//        final int deletemenu = roleMenuMapper.deleteByPrimaryKey(id);//讲这个角色对应的菜单权限全部去除掉
//        if (menuNum != deletemenu) throw new GlobalException("数据库编辑角色删除原来授权时失败");
//        return 1;
//    }
//
//    @Override
//    public List<Role> select() {
//        return roleMapper.selectByExample(new RoleExample());
//    }
//
//    /**
//     * 给对数据库操作更改时对数据进行维护
//     */
//    private Role filling(Role role, int addOrUpdate) {
//        final Date date = new Date();
//        if (addOrUpdate == 1) {
//            role.setCreateTime(date);
//            role.setCreateUser(redisUser.getUserUtil().getId());
//        } else {
//            role.setUpdateTime(date);
//            role.setUpdateUser(redisUser.getUserUtil().getId());
//        }
//        return role;
//    }
//
//}
