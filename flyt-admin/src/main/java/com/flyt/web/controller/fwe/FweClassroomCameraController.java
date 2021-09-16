package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweClassroomCamera;
import com.flyt.fwe.service.IFweClassroomCameraService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教室摄像机 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweClassroomCamera")
public class FweClassroomCameraController extends BaseController
{
    private String prefix = "fwe/fweClassroomCamera";
	
	@Autowired
	private IFweClassroomCameraService fweClassroomCameraService;
	
	@RequiresPermissions("fwe:fweClassroomCamera:view")
	@GetMapping()
	public String fweClassroomCamera()
	{
	    return prefix + "/fweClassroomCamera";
	}
	
	/**
	 * 查询教室摄像机列表
	 */
	@RequiresPermissions("fwe:fweClassroomCamera:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweClassroomCamera fweClassroomCamera)
	{
		startPage();
        List<FweClassroomCamera> list = fweClassroomCameraService.selectFweClassroomCameraList(fweClassroomCamera);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出教室摄像机列表
	 */
	@RequiresPermissions("fwe:fweClassroomCamera:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweClassroomCamera fweClassroomCamera)
    {
    	List<FweClassroomCamera> list = fweClassroomCameraService.selectFweClassroomCameraList(fweClassroomCamera);
        ExcelUtil<FweClassroomCamera> util = new ExcelUtil<FweClassroomCamera>(FweClassroomCamera.class);
        return util.exportExcel(list, "fweClassroomCamera");
    }
	
	/**
	 * 新增教室摄像机
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教室摄像机
	 */
	@RequiresPermissions("fwe:fweClassroomCamera:add")
	@Log(title = "教室摄像机", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweClassroomCamera fweClassroomCamera)
	{
		fweClassroomCamera.setCreateBy(ShiroUtils.getLoginName());
		fweClassroomCamera.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweClassroomCameraService.insertFweClassroomCamera(fweClassroomCamera));
	}

	/**
	 * 修改教室摄像机
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweClassroomCamera fweClassroomCamera = fweClassroomCameraService.selectFweClassroomCameraById(id);
		mmap.put("fweClassroomCamera", fweClassroomCamera);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教室摄像机
	 */
	@RequiresPermissions("fwe:fweClassroomCamera:edit")
	@Log(title = "教室摄像机", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweClassroomCamera fweClassroomCamera)
	{
		fweClassroomCamera.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweClassroomCameraService.updateFweClassroomCamera(fweClassroomCamera));
	}
	
	/**
	 * 删除教室摄像机
	 */
	@RequiresPermissions("fwe:fweClassroomCamera:remove")
	@Log(title = "教室摄像机", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweClassroomCameraService.deleteFweClassroomCameraByIds(ids));
	}
	
}
