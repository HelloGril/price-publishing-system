//package com.hywa.pricepublish.config;
//
//import com.hywa.pricepublish.dao.entity.Permission;
//import com.hywa.pricepublish.dao.entity.Role;
//import com.hywa.pricepublish.dao.entity.User;
//import com.hywa.pricepublish.service.PermissionService;
//import com.hywa.pricepublish.service.RoleService;
//import com.hywa.pricepublish.service.UserService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//    @Autowired
//    private PermissionService permissionService;
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    /**
//     * 认证信息.(身份验证) : Authentication 身份认证/登录，验证用户是不是拥有相应的身份；
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        logger.info("验证当前Subject时获取到token为：" + token.toString());
//        User hasUser = userService.findByName(token.getUsername());
//
//        if (hasUser != null) {
//            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            List<Role> rList = roleService.findRoleByUid(hasUser.getId());//获取用户角色
//            List<Permission> plist = permissionService.findPermissionByUserId(hasUser.getId());//获取用户权限
//            List<String> roleStrList = new ArrayList<>();////用户的角色集合
//            List<String> permissionStrList = new ArrayList<>();//用户的权限集合
//            for (Role role : rList) {
//                roleStrList.add(role.getName());
//            }
//            for (Permission uPermission : plist) {
//                permissionStrList.add(uPermission.getName());
//            }
//            hasUser.setRoleStrList(roleStrList);
//            hasUser.setPermissionStrList(permissionStrList);
////            Session session = SecurityUtils.getSubject().getSession();
////            session.setAttribute("user", hasUser);//成功则放入session
//            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            return new SimpleAuthenticationInfo(hasUser, hasUser.getPassword(), getName());
//        }
//        return null;
//    }
//
//    /**
//     * 授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，
//     * 常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限；
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(
//            PrincipalCollection principals) {
//        logger.info("##################执行Shiro权限认证##################");
//        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
////        String loginName = (String) super.getAvailablePrincipal(principalCollection);
//        User user = (User) principals.getPrimaryPrincipal();
////        //到数据库查是否有此对象
////        User user = null;// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
////        user = userMapper.findByName(loginName);
//        if (user != null) {
//            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            //用户的角色集合
//            info.addRoles(user.getRoleStrList());
//            //用户的权限集合
//            info.addStringPermissions(user.getPermissionStrList());
//
//            return info;
//        }
//        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
//        return null;
//    }
//}
