package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweClass;
import com.flyt.fwe.service.IFweClassService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweClass")
public class FweClassController extends BaseController
{
    private String prefix = "fwe/fweClass";
	
	@Autowired
	private IFweClassService fweClassService;
	
	@RequiresPermissions("fwe:fweClass:view")
	@GetMapping()
	public String fweClass()
	{
	    return prefix + "/fweClass";
	}
	
	/**
	 * 查询班级列表
	 */
	@RequiresPermissions("fwe:fweClass:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweClass fweClass)
	{
		startPage();
        List<FweClass> list = fweClassService.selectFweClassList(fweClass);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级列表
	 */
	@RequiresPermissions("fwe:fweClass:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweClass fweClass)
    {
    	List<FweClass> list = fweClassService.selectFweClassList(fweClass);
        ExcelUtil<FweClass> util = new ExcelUtil<FweClass>(FweClass.class);
        return util.exportExcel(list, "fweClass");
    }
	
	/**
	 * 新增班级
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存班级
	 */
	@RequiresPermissions("fwe:fweClass:add")
	@Log(title = "班级", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweClass fweClass)
	{
		fweClass.setCreateBy(ShiroUtils.getLoginName());
		fweClass.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweClassService.insertFweClass(fweClass));
	}

	/**
	 * 修改班级
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweClass fweClass = fweClassService.selectFweClassById(id);
		mmap.put("fweClass", fweClass);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存班级
	 */
	@RequiresPermissions("fwe:fweClass:edit")
	@Log(title = "班级", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweClass fweClass)
	{
		fweClass.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweClassService.updateFweClass(fweClass));
	}
	
	/**
	 * 删除班级
	 */
	@RequiresPermissions("fwe:fweClass:remove")
	@Log(title = "班级", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweClassService.deleteFweClassByIds(ids));
	}
	
}
