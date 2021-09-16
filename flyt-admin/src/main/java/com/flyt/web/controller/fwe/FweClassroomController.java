package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweClassroom;
import com.flyt.fwe.service.IFweClassroomService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教室 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweClassroom")
public class FweClassroomController extends BaseController
{
    private String prefix = "fwe/fweClassroom";
	
	@Autowired
	private IFweClassroomService fweClassroomService;
	
	@RequiresPermissions("fwe:fweClassroom:view")
	@GetMapping()
	public String fweClassroom()
	{
	    return prefix + "/fweClassroom";
	}
	
	/**
	 * 查询教室列表
	 */
	@RequiresPermissions("fwe:fweClassroom:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweClassroom fweClassroom)
	{
		startPage();
        List<FweClassroom> list = fweClassroomService.selectFweClassroomList(fweClassroom);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出教室列表
	 */
	@RequiresPermissions("fwe:fweClassroom:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweClassroom fweClassroom)
    {
    	List<FweClassroom> list = fweClassroomService.selectFweClassroomList(fweClassroom);
        ExcelUtil<FweClassroom> util = new ExcelUtil<FweClassroom>(FweClassroom.class);
        return util.exportExcel(list, "fweClassroom");
    }
	
	/**
	 * 新增教室
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教室
	 */
	@RequiresPermissions("fwe:fweClassroom:add")
	@Log(title = "教室", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweClassroom fweClassroom)
	{
		fweClassroom.setCreateBy(ShiroUtils.getLoginName());
		fweClassroom.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweClassroomService.insertFweClassroom(fweClassroom));
	}

	/**
	 * 修改教室
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweClassroom fweClassroom = fweClassroomService.selectFweClassroomById(id);
		mmap.put("fweClassroom", fweClassroom);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教室
	 */
	@RequiresPermissions("fwe:fweClassroom:edit")
	@Log(title = "教室", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweClassroom fweClassroom)
	{
		fweClassroom.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweClassroomService.updateFweClassroom(fweClassroom));
	}
	
	/**
	 * 删除教室
	 */
	@RequiresPermissions("fwe:fweClassroom:remove")
	@Log(title = "教室", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweClassroomService.deleteFweClassroomByIds(ids));
	}
	
}
