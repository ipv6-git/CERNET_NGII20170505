package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweStudentWhiteList;
import com.flyt.fwe.service.IFweStudentWhiteListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 缺课白名单 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweStudentWhiteList")
public class FweStudentWhiteListController extends BaseController
{
    private String prefix = "fwe/fweStudentWhiteList";
	
	@Autowired
	private IFweStudentWhiteListService fweStudentWhiteListService;
	
	@RequiresPermissions("fwe:fweStudentWhiteList:view")
	@GetMapping()
	public String fweStudentWhiteList()
	{
	    return prefix + "/fweStudentWhiteList";
	}
	
	/**
	 * 查询缺课白名单列表
	 */
	@RequiresPermissions("fwe:fweStudentWhiteList:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweStudentWhiteList fweStudentWhiteList)
	{
		startPage();
        List<FweStudentWhiteList> list = fweStudentWhiteListService.selectFweStudentWhiteListList(fweStudentWhiteList);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出缺课白名单列表
	 */
	@RequiresPermissions("fwe:fweStudentWhiteList:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweStudentWhiteList fweStudentWhiteList)
    {
    	List<FweStudentWhiteList> list = fweStudentWhiteListService.selectFweStudentWhiteListList(fweStudentWhiteList);
        ExcelUtil<FweStudentWhiteList> util = new ExcelUtil<FweStudentWhiteList>(FweStudentWhiteList.class);
        return util.exportExcel(list, "fweStudentWhiteList");
    }
	
	/**
	 * 新增缺课白名单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存缺课白名单
	 */
	@RequiresPermissions("fwe:fweStudentWhiteList:add")
	@Log(title = "缺课白名单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweStudentWhiteList fweStudentWhiteList)
	{
		fweStudentWhiteList.setCreateBy(ShiroUtils.getLoginName());
		fweStudentWhiteList.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweStudentWhiteListService.insertFweStudentWhiteList(fweStudentWhiteList));
	}

	/**
	 * 修改缺课白名单
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweStudentWhiteList fweStudentWhiteList = fweStudentWhiteListService.selectFweStudentWhiteListById(id);
		mmap.put("fweStudentWhiteList", fweStudentWhiteList);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存缺课白名单
	 */
	@RequiresPermissions("fwe:fweStudentWhiteList:edit")
	@Log(title = "缺课白名单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweStudentWhiteList fweStudentWhiteList)
	{
		fweStudentWhiteList.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweStudentWhiteListService.updateFweStudentWhiteList(fweStudentWhiteList));
	}
	
	/**
	 * 删除缺课白名单
	 */
	@RequiresPermissions("fwe:fweStudentWhiteList:remove")
	@Log(title = "缺课白名单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweStudentWhiteListService.deleteFweStudentWhiteListByIds(ids));
	}
	
}
