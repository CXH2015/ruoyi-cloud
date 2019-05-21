package com.ruoyi.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;

/**
 * 用户 提供者
 * 
 * @author zmr
 * @date 2019-05-20
 */
@RestController
@RequestMapping("user")
public class SysUserController extends BaseController
{
	
	@Autowired
	private ISysUserService sysUserService;
	
	/**
	 * 查询用户
	 */
	@GetMapping("get/{userId}")
	public SysUser get(@PathVariable("userId") Long userId)
	{
		return sysUserService.selectUserById(userId);
		
	}
	/**
	 * 查询用户
	 */
	@GetMapping("find/{username}")
	public SysUser findByUsername(@PathVariable("username") String username)
	{
	    return sysUserService.selectUserByLoginName(username);
	    
	}
	
	/**
	 * 查询用户列表
	 */
	@RequestMapping("list")
	public List<SysUser> list(SysUser sysUser, PageDomain page)
	{
		startPage(page);
        return sysUserService.selectUserList(sysUser);
	}
	
	
	/**
	 * 新增保存用户
	 */
	@PostMapping("save")
	public int addSave(SysUser sysUser)
	{		
		return sysUserService.insertUser(sysUser);
	}

	/**
	 * 修改保存用户
	 */
	@PostMapping("update")
	public int editSave(SysUser sysUser)
	{		
		return sysUserService.updateUser(sysUser);
	}
	
	/**
	 * 删除用户
	 * @throws Exception 
	 */
	@PostMapping("remove")
	public int remove(String ids) throws Exception
	{		
		return sysUserService.deleteUserByIds(ids);
	}
	
}
