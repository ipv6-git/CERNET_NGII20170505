package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweTeacher;
import com.flyt.fwe.service.IFweTeacherService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教师 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweTeacher")
public class FweTeacherController extends BaseController
{
    private String prefix = "fwe/fweTeacher";
	
	@Autowired
	private IFweTeacherService fweTeacherService;
	
	@RequiresPermissions("fwe:fweTeacher:view")
	@GetMapping()
	public String fweTeacher()
	{
	    return prefix + "/fweTeacher";
	}
	
	/**
	 * 查询教师列表
	 */
	@RequiresPermissions("fwe:fweTeacher:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweTeacher fweTeacher)
	{
		startPage();
        List<FweTeacher> list = fweTeacherService.selectFweTeacherList(fweTeacher);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出教师列表
	 */
	@RequiresPermissions("fwe:fweTeacher:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweTeacher fweTeacher)
    {
    	List<FweTeacher> list = fweTeacherService.selectFweTeacherList(fweTeacher);
        ExcelUtil<FweTeacher> util = new ExcelUtil<FweTeacher>(FweTeacher.class);
        return util.exportExcel(list, "fweTeacher");
    }
	
	/**
	 * 新增教师
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教师
	 */
	@RequiresPermissions("fwe:fweTeacher:add")
	@Log(title = "教师", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweTeacher fweTeacher)
	{
		fweTeacher.setCreateBy(ShiroUtils.getLoginName());
		fweTeacher.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweTeacherService.insertFweTeacher(fweTeacher));
	}

	/**
	 * 修改教师
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweTeacher fweTeacher = fweTeacherService.selectFweTeacherById(id);
		mmap.put("fweTeacher", fweTeacher);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教师
	 */
	@RequiresPermissions("fwe:fweTeacher:edit")
	@Log(title = "教师", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweTeacher fweTeacher)
	{
		fweTeacher.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweTeacherService.updateFweTeacher(fweTeacher));
	}
	
	/**
	 * 删除教师
	 */
	@RequiresPermissions("fwe:fweTeacher:remove")
	@Log(title = "教师", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweTeacherService.deleteFweTeacherByIds(ids));
	}
	
}
