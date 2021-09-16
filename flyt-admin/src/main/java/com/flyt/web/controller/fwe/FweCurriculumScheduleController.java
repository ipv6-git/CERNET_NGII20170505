package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweCurriculumSchedule;
import com.flyt.fwe.service.IFweCurriculumScheduleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程安排 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweCurriculumSchedule")
public class FweCurriculumScheduleController extends BaseController
{
    private String prefix = "fwe/fweCurriculumSchedule";
	
	@Autowired
	private IFweCurriculumScheduleService fweCurriculumScheduleService;
	
	@RequiresPermissions("fwe:fweCurriculumSchedule:view")
	@GetMapping()
	public String fweCurriculumSchedule()
	{
	    return prefix + "/fweCurriculumSchedule";
	}
	
	/**
	 * 查询课程安排列表
	 */
	@RequiresPermissions("fwe:fweCurriculumSchedule:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweCurriculumSchedule fweCurriculumSchedule)
	{
		startPage();
        List<FweCurriculumSchedule> list = fweCurriculumScheduleService.selectFweCurriculumScheduleList(fweCurriculumSchedule);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出课程安排列表
	 */
	@RequiresPermissions("fwe:fweCurriculumSchedule:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweCurriculumSchedule fweCurriculumSchedule)
    {
    	List<FweCurriculumSchedule> list = fweCurriculumScheduleService.selectFweCurriculumScheduleList(fweCurriculumSchedule);
        ExcelUtil<FweCurriculumSchedule> util = new ExcelUtil<FweCurriculumSchedule>(FweCurriculumSchedule.class);
        return util.exportExcel(list, "fweCurriculumSchedule");
    }
	
	/**
	 * 新增课程安排
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存课程安排
	 */
	@RequiresPermissions("fwe:fweCurriculumSchedule:add")
	@Log(title = "课程安排", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweCurriculumSchedule fweCurriculumSchedule)
	{
		fweCurriculumSchedule.setCreateBy(ShiroUtils.getLoginName());
		fweCurriculumSchedule.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCurriculumScheduleService.insertFweCurriculumSchedule(fweCurriculumSchedule));
	}

	/**
	 * 修改课程安排
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweCurriculumSchedule fweCurriculumSchedule = fweCurriculumScheduleService.selectFweCurriculumScheduleById(id);
		mmap.put("fweCurriculumSchedule", fweCurriculumSchedule);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存课程安排
	 */
	@RequiresPermissions("fwe:fweCurriculumSchedule:edit")
	@Log(title = "课程安排", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweCurriculumSchedule fweCurriculumSchedule)
	{
		fweCurriculumSchedule.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCurriculumScheduleService.updateFweCurriculumSchedule(fweCurriculumSchedule));
	}
	
	/**
	 * 删除课程安排
	 */
	@RequiresPermissions("fwe:fweCurriculumSchedule:remove")
	@Log(title = "课程安排", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweCurriculumScheduleService.deleteFweCurriculumScheduleByIds(ids));
	}
	
}
