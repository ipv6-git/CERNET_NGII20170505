package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweCurriculum;
import com.flyt.fwe.service.IFweCurriculumService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 开设课程 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweCurriculum")
public class FweCurriculumController extends BaseController
{
    private String prefix = "fwe/fweCurriculum";
	
	@Autowired
	private IFweCurriculumService fweCurriculumService;
	
	@RequiresPermissions("fwe:fweCurriculum:view")
	@GetMapping()
	public String fweCurriculum()
	{
	    return prefix + "/fweCurriculum";
	}
	
	/**
	 * 查询开设课程列表
	 */
	@RequiresPermissions("fwe:fweCurriculum:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweCurriculum fweCurriculum)
	{
		startPage();
        List<FweCurriculum> list = fweCurriculumService.selectFweCurriculumList(fweCurriculum);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出开设课程列表
	 */
	@RequiresPermissions("fwe:fweCurriculum:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweCurriculum fweCurriculum)
    {
    	List<FweCurriculum> list = fweCurriculumService.selectFweCurriculumList(fweCurriculum);
        ExcelUtil<FweCurriculum> util = new ExcelUtil<FweCurriculum>(FweCurriculum.class);
        return util.exportExcel(list, "fweCurriculum");
    }
	
	/**
	 * 新增开设课程
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存开设课程
	 */
	@RequiresPermissions("fwe:fweCurriculum:add")
	@Log(title = "开设课程", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweCurriculum fweCurriculum)
	{
		fweCurriculum.setCreateBy(ShiroUtils.getLoginName());
		fweCurriculum.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCurriculumService.insertFweCurriculum(fweCurriculum));
	}

	/**
	 * 修改开设课程
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweCurriculum fweCurriculum = fweCurriculumService.selectFweCurriculumById(id);
		mmap.put("fweCurriculum", fweCurriculum);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存开设课程
	 */
	@RequiresPermissions("fwe:fweCurriculum:edit")
	@Log(title = "开设课程", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweCurriculum fweCurriculum)
	{
		fweCurriculum.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCurriculumService.updateFweCurriculum(fweCurriculum));
	}
	
	/**
	 * 删除开设课程
	 */
	@RequiresPermissions("fwe:fweCurriculum:remove")
	@Log(title = "开设课程", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweCurriculumService.deleteFweCurriculumByIds(ids));
	}
	
}
