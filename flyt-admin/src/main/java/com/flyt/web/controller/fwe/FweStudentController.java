package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweStudent;
import com.flyt.fwe.service.IFweStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweStudent")
public class FweStudentController extends BaseController
{
    private String prefix = "fwe/fweStudent";
	
	@Autowired
	private IFweStudentService fweStudentService;
	
	@RequiresPermissions("fwe:fweStudent:view")
	@GetMapping()
	public String fweStudent()
	{
	    return prefix + "/fweStudent";
	}
	
	/**
	 * 查询学生列表
	 */
	@RequiresPermissions("fwe:fweStudent:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweStudent fweStudent)
	{
		startPage();
        List<FweStudent> list = fweStudentService.selectFweStudentList(fweStudent);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生列表
	 */
	@RequiresPermissions("fwe:fweStudent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweStudent fweStudent)
    {
    	List<FweStudent> list = fweStudentService.selectFweStudentList(fweStudent);
        ExcelUtil<FweStudent> util = new ExcelUtil<FweStudent>(FweStudent.class);
        return util.exportExcel(list, "fweStudent");
    }
	
	/**
	 * 新增学生
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生
	 */
	@RequiresPermissions("fwe:fweStudent:add")
	@Log(title = "学生", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweStudent fweStudent)
	{		
		fweStudent.setCreateBy(ShiroUtils.getLoginName());
		fweStudent.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweStudentService.insertFweStudent(fweStudent));
	}

	/**
	 * 修改学生
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweStudent fweStudent = fweStudentService.selectFweStudentById(id);
		mmap.put("fweStudent", fweStudent);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生
	 */
	@RequiresPermissions("fwe:fweStudent:edit")
	@Log(title = "学生", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweStudent fweStudent)
	{		
		fweStudent.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweStudentService.updateFweStudent(fweStudent));
	}
	
	/**
	 * 删除学生
	 */
	@RequiresPermissions("fwe:fweStudent:remove")
	@Log(title = "学生", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweStudentService.deleteFweStudentByIds(ids));
	}
	
}
