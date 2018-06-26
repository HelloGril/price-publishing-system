//package com.hywa.pricepublish.controller.role;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.hywa.pricepublish.common.ConstantPool;
//import com.hywa.pricepublish.common.utils.StringUtils;
//import com.hywa.pricepublish.common.exception.GlobalException;
//import com.hywa.pricepublish.dao.entity.Role;
//import com.hywa.pricepublish.representation.ResponseBase;
//import com.hywa.pricepublish.service.login.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * 菜单控制器,CRUD以及根据树形结构的分页查询
// */
//@RestController
//@RequestMapping("role")
//public class RoleController {
//    @Autowired
//    private RoleService roleService;
//
//    /**
//     * 获取单个角色详情用于编辑
//     */
//    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    public ResponseEntity<ResponseBase> get(@RequestParam String roleId) throws GlobalException {
//        Role therole=roleService.get(roleId);
//        if(therole==null)throw new GlobalException("此角色id非法");
//        ResponseBase<Role> roleRepResponseBase = new ResponseBase<>();
//        roleRepResponseBase.setRetBody(therole);
//        roleRepResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
//        return new ResponseEntity<>(roleRepResponseBase, HttpStatus.OK);
//    }
//
//    /**
//     * 新增或者编辑单个角色
//     */
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ResponseEntity<ResponseBase> save(@RequestBody Role role) throws GlobalException {
//        if(StringUtils.isEmpty(role.getId())){
//            final int num=roleService.save(role);
//            if(num!=1)throw new GlobalException("角色数据插入数据库失败");
//        }else{
//            final int num=roleService.update(role);
//            if(num!=1)throw new GlobalException("角色数据插入数据库失败");
//        }
//        ResponseBase<Role> roleRepResponseBase = new ResponseBase<>();
//        roleRepResponseBase.setRetBody(role);
//        roleRepResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
//        return new ResponseEntity<>(roleRepResponseBase, HttpStatus.OK);
//    }
//
//    /**
//     * 逻辑删除单个角色
//     */
//    @RequestMapping(value = "/delte", method = RequestMethod.GET)
//    public ResponseEntity<ResponseBase> delete(@RequestBody String roleId) throws GlobalException {
//        if(!StringUtils.isEmpty(roleId)){
//            final int num=roleService.delete(roleId);
//            if(num!=1)throw new GlobalException("角色数据插入数据库失败");
//        }else throw new GlobalException("输入了非法参数，id为空");
//        ResponseBase<Role> roleRepResponseBase = new ResponseBase<Role>();
//        roleRepResponseBase.setRetBody(null);
//        roleRepResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
//        return new ResponseEntity<>(roleRepResponseBase, HttpStatus.OK);
//    }
//
//    /**
//     * 获取所有的菜单并分页,暂时是所有的角色都查出来然后分页，以后要更改
//     */
//    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
//    public ResponseEntity<ResponseBase> get(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize) throws GlobalException {
//            PageHelper.startPage(pageNum, pageSize);
//            List<Role> roles = roleService.select();
//            PageInfo<Role> roleRepPageInfo = new PageInfo<Role>(roles);
//            ResponseBase<PageInfo<Role>> responseBase = new ResponseBase<>();
//            responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
//            responseBase.setRetBody(roleRepPageInfo);
//            return new ResponseEntity<>(responseBase, HttpStatus.OK);
//    }
//
//}
