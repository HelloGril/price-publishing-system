package com.hywa.pricepublish.controller.menu;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.utils.StringUtils;
import com.hywa.pricepublish.common.exception.GlobalException;
import com.hywa.pricepublish.dao.entity.Menu;
import com.hywa.pricepublish.representation.MenuRep;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.login.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单控制器,CRUD以及根据树形结构的分页查询
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 获取单个菜单详情用于编辑
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> get(@RequestParam String menuId) throws GlobalException {
        Menu theMenu=menuService.get(menuId);
        if(theMenu==null)throw new GlobalException("此菜单id非法");
        ResponseBase<MenuRep> menuRepResponseBase = new ResponseBase<>();
        MenuRep menuRep=new MenuRep(theMenu);
        menuRepResponseBase.setRetBody(menuRep);
        menuRepResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity<>(menuRepResponseBase, HttpStatus.OK);
    }

    /**
     * 新增或者编辑单个菜单设计
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ResponseBase> save(@RequestBody Menu menu) throws GlobalException {
        if(StringUtils.isEmpty(menu.getId())){
            final int num=menuService.save(menu);
            if(num!=1)throw new GlobalException("菜单数据插入数据库失败");
        }else{
            final int num=menuService.update(menu);
            if(num!=1)throw new GlobalException("菜单数据插入数据库失败");
        }
        ResponseBase<Menu> menuRepResponseBase = new ResponseBase<>();
        menuRepResponseBase.setRetBody(menu);
        menuRepResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity<>(menuRepResponseBase, HttpStatus.OK);
    }

    /**
     * 逻辑删除单个菜单设计
     */
    @RequestMapping(value = "/delte", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> delete(@RequestBody String menuId) throws GlobalException {
        if(!StringUtils.isEmpty(menuId)){
            final int num=menuService.delete(menuId);
            if(num!=1)throw new GlobalException("菜单数据插入数据库失败");
        }else throw new GlobalException("输入了非法参数，id为空");
        ResponseBase<Menu> menuRepResponseBase = new ResponseBase<>();
        menuRepResponseBase.setRetBody(null);
        menuRepResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity<>(menuRepResponseBase, HttpStatus.OK);
    }

    /**
     * 获取所有的菜单并分页
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> get(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize,String parentId) throws GlobalException {
            PageHelper.startPage(pageNum, pageSize);
            List<Menu> menus = menuService.select(parentId);
            PageInfo<Menu> menuRepPageInfo = new PageInfo<Menu>(menus);
            ResponseBase<PageInfo<Menu>> responseBase = new ResponseBase<>();
            responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
            responseBase.setRetBody(menuRepPageInfo);
            return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

}
