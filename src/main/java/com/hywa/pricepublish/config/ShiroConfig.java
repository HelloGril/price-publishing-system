//package com.hywa.pricepublish.config;
//
//import org.apache.shiro.cache.ehcache.EhCacheManager;
//import org.apache.shiro.codec.Base64;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.data.redis.cache.RedisCacheManager;
//
//import java.util.LinkedHashMap;
//
///***
// * yfw
// * shiro 配置
// *
// */
//@Configuration
//public class ShiroConfig {
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    /**
//     * ShiroFilterFactoryBean 处理拦截资源文件问题。
//     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
//     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
//     * <p>
//     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
//     * 3、部分过滤器可指定参数，如perms，roles
//     */
//    @Bean
//    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        shiroFilterFactoryBean.setLoginUrl("/login");
//
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/css/**", "anon");
//        filterChainDefinitionMap.put("/js/**", "anon");
//        filterChainDefinitionMap.put("/fonts/**", "anon");
//        filterChainDefinitionMap.put("/img/**", "anon");
//        filterChainDefinitionMap.put("/docs/**", "anon");
//        filterChainDefinitionMap.put("/druid/**", "anon");
//        filterChainDefinitionMap.put("/upload/**", "anon");
//        filterChainDefinitionMap.put("/files/**", "anon");
//        filterChainDefinitionMap.put("/logout", "logout");
//        filterChainDefinitionMap.put("/", "anon");
//        filterChainDefinitionMap.put("/blog", "anon");
//        filterChainDefinitionMap.put("/blog/open/**", "anon");
//        filterChainDefinitionMap.put("/ajaxLogin", "anon");
//        //filterChainDefinitionMap.put("/test/findByUserName", "anon");
//        filterChainDefinitionMap.put("/**", "authc");//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
//        daap.setProxyTargetClass(true);
//        return daap;
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
//        aasa.setSecurityManager(securityManager);
//        return aasa;
//    }
//
//    @Bean(name = "ehCacheManager")
//    @DependsOn("lifecycleBeanPostProcessor")
//    public EhCacheManager ehCacheManager(){
//        EhCacheManager ehCacheManager = new EhCacheManager();
//        return ehCacheManager;
//    }
//
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myShiroRealm());
//        securityManager.setCacheManager(ehCacheManager());//用户授权/认证信息Cache, 采用EhCache 缓存
//        return securityManager;
//    }
//
//    //thymeleaf模板引擎和shiro整合时使用
//    /*@Bean(name = "shiroDialect")
//    public ShiroDialect shiroDialect(){
//        return new ShiroDialect();
//    }*/
//
//
//    /**
//     * 身份认证realm; (这个需要自己写，账号密码校验；权限等
//     */
//    @Bean
//    public MyShiroRealm myShiroRealm() {
//        MyShiroRealm myShiroRealm = new MyShiroRealm();
//        return myShiroRealm;
//    }
////
////	/**
////	 * 配置shiro redisManager
////	 * 使用的是shiro-redis开源插件
////	 * @return
////	 */
////	public RedisManager redisManager() {
////		RedisManager redisManager = new RedisManager();
//// 		redisManager.setHost(host);
////		redisManager.setPort(port);
////		redisManager.setExpire(1800);// 配置缓存过期时间
////		redisManager.setTimeout(timeout);
////		// redisManager.setPassword(password);
////		return redisManager;
////	}
//
////	/**
////	 * cacheManager 缓存 redis实现
////	 * 使用的是shiro-redis开源插件
////	 * @return
////	 */
////	public RedisCacheManager cacheManager() {
////		RedisCacheManager redisCacheManager = new RedisCacheManager();
////		redisCacheManager.setRedisManager(redisManager());
////		return redisCacheManager;
////	}
////
////	/**
////	 * RedisSessionDAO shiro sessionDao层的实现 通过redis
////	 * 使用的是shiro-redis开源插件
////	 */
////	@Bean
////	public RedisSessionDAO redisSessionDAO() {
////		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
////		redisSessionDAO.setRedisManager(redisManager());
////		return redisSessionDAO;
////	}
//
////	/**
////	 * Session Manager
////	 * 使用的是shiro-redis开源插件
////	 */
////	@Bean
////	public DefaultWebSessionManager sessionManager() {
////		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
////		sessionManager.setSessionDAO(redisSessionDAO());
////		return sessionManager;
////	}
//
//    /**
//     * cookie对象;
//     */
//    public SimpleCookie rememberMeCookie() {
//        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
//        simpleCookie.setMaxAge(2592000);
//        return simpleCookie;
//    }
//
//    /**
//     * cookie管理对象;记住我功能
//     */
//    public CookieRememberMeManager rememberMeManager() {
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
//        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
//        return cookieRememberMeManager;
//    }
//}
