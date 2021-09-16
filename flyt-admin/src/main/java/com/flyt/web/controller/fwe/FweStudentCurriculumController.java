package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweStudentCurriculum;
import com.flyt.fwe.service.IFweStudentCurriculumService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程学生 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweStudentCurriculum")
public class FweStudentCurriculumController extends BaseController
{
    private String prefix = "fwe/fweStudentCurriculum";
	
	@Autowired
	private IFweStudentCurriculumService fweStudentCurriculumService;
	
	@RequiresPermissions("fwe:fweStudentCurriculum:view")
	@GetMapping()
	public String fweStudentCurriculum()
	{
	    return prefix + "/fweStudentCurriculum";
	}
	
	/**
	 * 查询课程学生列表
	 */
	@RequiresPermissions("fwe:fweStudentCurriculum:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweStudentCurriculum fweStudentCurriculum)
	{
		startPage();
        List<FweStudentCurriculum> list = fweStudentCurriculumService.selectFweStudentCurriculumList(fweStudentCurriculum);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出课程学生列表
	 */
	@RequiresPermissions("fwe:fweStudentCurriculum:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweStudentCurriculum fweStudentCurriculum)
    {
    	List<FweStudentCurriculum> list = fweStudentCurriculumService.selectFweStudentCurriculumList(fweStudentCurriculum);
        ExcelUtil<FweStudentCurriculum> util = new ExcelUtil<FweStudentCurriculum>(FweStudentCurriculum.class);
        return util.exportExcel(list, "fweStudentCurriculum");
    }
	
	/**
	 * 新增课程学生
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存课程学生
	 */
	@RequiresPermissions("fwe:fweStudentCurriculum:add")
	@Log(title = "课程学生", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweStudentCurriculum fweStudentCurriculum)
	{
		fweStudentCurriculum.setCreateBy(ShiroUtils.getLoginName());
		fweStudentCurriculum.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweStudentCurriculumService.insertFweStudentCurriculum(fweStudentCurriculum));
	}

	/**
	 * 修改课程学生
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweStudentCurriculum fweStudentCurriculum = fweStudentCurriculumService.selectFweStudentCurriculumById(id);
		mmap.put("fweStudentCurriculum", fweStudentCurriculum);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存课程学生
	 */
	@RequiresPermissions("fwe:fweStudentCurriculum:edit")
	@Log(title = "课程学生", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweStudentCurriculum fweStudentCurriculum)
	{
		fweStudentCurriculum.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweStudentCurriculumService.updateFweStudentCurriculum(fweStudentCurriculum));
	}
	
	/**
	 * 删除课程学生
	 */
	@RequiresPermissions("fwe:fweStudentCurriculum:remove")
	@Log(title = "课程学生", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweStudentCurriculumService.deleteFweStudentCurriculumByIds(ids));
	}
	
}
