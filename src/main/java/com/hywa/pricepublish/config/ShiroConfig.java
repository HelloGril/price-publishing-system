//package com.hywa.pricepublish.config;
//
//
//import com.hywa.pricepublish.service.PermissionService;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///***
// * shiro 配置
// */
//@Configuration
//public class ShiroConfig {
//
//    @Autowired
//    private PermissionService permissionService;
//
//    @Bean
//    public ShiroFilterFactoryBean shirFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
////        System.out.println("ShiroConfiguration.shirFilter()");
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //拦截器.
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        // 配置不会被拦截的链接 顺序判断
//        filterChainDefinitionMap.put("/static/**", "anon");
//        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/logout", "logout");
//        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
//        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
////        filterChainDefinitionMap.put("/**", "authc");
//        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("view/index");
//
//        //未授权界面;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    public MyShiroRealm myShiroRealm() {
//        MyShiroRealm myShiroRealm = new MyShiroRealm();
//        return myShiroRealm;
//    }
//
//    @Bean
//    public org.apache.shiro.mgt.SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myShiroRealm());
//        return securityManager;
//    }
//}
