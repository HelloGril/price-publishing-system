//package com.hywa.pricepublish.config;
//
//import com.hywa.pricepublish.common.MD5Utils;
//import com.hywa.pricepublish.dao.entity.User;
//import com.hywa.pricepublish.service.UserService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class MyShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UserService userService;
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    public MyShiroRealm() {
//        super(new AllowAllCredentialsMatcher());
//        setAuthenticationTokenClass(UsernamePasswordToken.class);
//
//        //FIXME: 暂时禁用Cache
//        setCachingEnabled(false);
//    }
//
//    /**
//     * Shiro的认证过程最终会交由Realm执行，这时会调用Realm的getAuthenticationInfo(token)方法
//     * 该方法主要执行以下操作:
//     * 1、检查提交的进行认证的令牌信息;
//     * 2、根据令牌信息从数据源(通常为数据库)中获取用户信息;
//     * 3、对用户信息进行匹配验证;
//     * 4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例;
//     * 5、验证失败则抛出AuthenticationException异常信息。
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(
//            AuthenticationToken authenticationToken) throws AuthenticationException {
//        String username = (String) authenticationToken.getPrincipal();
//        User user = userService.findByName(username);
//        if (user == null) {
//            throw new UnknownAccountException("账户或密码不正确");
//        }
//
//        Object credentials = authenticationToken.getCredentials();
//        String pwd = new String((char[]) credentials);
//        //密码错误
//        if (!MD5Utils.md5(pwd).equals(user.getPassword())) {
//            throw new IncorrectCredentialsException("账户或密码不正确");
//        }
//
//        //账户注销或删除
//        if (user.getStatus() == 1) {
//            throw new LockedAccountException("账户已注销或被锁定,请联系管理员");
//        }
//        return new SimpleAuthenticationInfo(user, pwd, getName());
//    }
//
//    /**
//     * 授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，
//     * 常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限；
//     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行，
//     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
//     * 在这个方法中主要是使用类：SimpleAuthorizationInfo进行角色的添加和权限的添加。
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        logger.info("##################执行Shiro权限认证##################");
//        User user = (User) principals.getPrimaryPrincipal();
//        Map<String, List<String>> userRolesAndPermissions = userService.findRolesAndPermissionsByUserName(user.getUsername());
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        Set<String> roles = new HashSet<>(userRolesAndPermissions.get("roles"));
//        Set<String> permissions = new HashSet<>(userRolesAndPermissions.get("permissions"));
//        authorizationInfo.setRoles(roles);
//        authorizationInfo.setStringPermissions(permissions);
//        return authorizationInfo;
//    }
//}
