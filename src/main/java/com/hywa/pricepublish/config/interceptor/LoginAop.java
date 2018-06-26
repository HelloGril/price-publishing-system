package com.hywa.pricepublish.config.interceptor;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.CookiesHandle;
import com.hywa.pricepublish.common.utils.StringUtils;
import com.hywa.pricepublish.representation.ResponseBase;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class LoginAop {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 定义拦截规则：拦截标有com.christ.annotation.Login类中注解的所有方法
     */
    @Pointcut("@annotation(com.hywa.pricepublish.config.interceptor.Login)")
    public void loginMethodPointcut() {
    }

    //    @Around("loginMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint point) {
        //正在被通知的方法相关信息
        MethodSignature signature = (MethodSignature) point.getSignature();
        //获取被拦截的方法
        Method method = signature.getMethod();
        String name = method.getName();
        //定义返回参数
        Object result = null;

        //方法参数
        Object[] args = point.getArgs();
        for (Object arg : args) {
            if (arg instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) arg;
                if (!isLogin(request)) {
                    result = "没有登录";
                }

                /**
                 * 权限验证
                 */
                //拿到储存在session中的用户id
//                int id=(int) session.getAttribute("admin_id");
//                //拿到储存在session中的用户类型
//                int type=(int) session.getAttribute("admin_type");
//
//                //0:超级管理员，1:管理员
//                //当用户为超级管理员时，拥有所有权限，可以通过权限检查的方法。
//                if(type==0){
//                    return point.proceed();
//                }
//
//                //每次都需要查询数据库  权限验证较为频繁可以引入缓存
//                List<String> permission;
//                if(permissionCache.get(String.valueOf(id)) == null){
//                    //根据用户id获取用户权限
//                    permission=adminService.getAdminPermission(id);
//                    //写入缓存中
//                    permissionCache.put(String.valueOf(id),permission);
//                }else{
//                    //logger.info("用户："+id+",从缓存中验证权限："+className+"_"+methodName);
//                    permission=permissionCache.get(String.valueOf(id));
//                }
//
//                //如果用户权限中包含aop代理下的方法，则该用户权限验证通过
//                if(permission.contains(className+"_"+methodName)){
//                    return point.proceed();
//                }
//
//                //按钮采用post方法，通过ajax调用返回json串，提示无权限
//                if(methodName.endsWith("POST")){
//                    return ResultModel.successModel("无权限使用此功能");
//                }
//                //进入页面采用get方法，若无权限则进行页面跳转
//                return new ModelAndView("redirect:/managecenter/nopermission.html");
            }
        }

        try {
            if (result == null)
                result = point.proceed();
        } catch (Throwable e) {
            ResponseBase<Object> responseBase = new ResponseBase<>();
            responseBase.setRetHead(ConstantPool.FAILURE, "发生异常：" + e.getMessage());
            result = new ResponseEntity<ResponseBase>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        throw new RuntimeException("the method which use @CheckPermission must has a HttpServletRequest as Parameter");

        return result;
    }

    private boolean isLogin(HttpServletRequest request) {
        try {
            //将cookie中的用户信息取出
            //CooikesHandle类是我自己封装的一个处理Cookie的类
            CookiesHandle cookiesHandle = new CookiesHandle(request, null);
            String uuid = cookiesHandle.getCookieByName("uuid").getValue();
            String name = cookiesHandle.getCookieByName("last_login_username").getValue();
            //将redis缓存中的用户信息取出
            String token = stringRedisTemplate.opsForValue().get("token:" + name);
            if (StringUtils.isEmpty(token))
                return false;
            else if (token.equals(uuid))
                return true;
        } catch (Exception e) {
            log.error("aop获取redis缓存中的token失败 Exception: " + e.getMessage());
            return false;
        }
        return false;
    }
}
