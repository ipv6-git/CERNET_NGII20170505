package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweCamera;
import com.flyt.fwe.service.IFweCameraService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 摄像机 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweCamera")
public class FweCameraController extends BaseController
{
    private String prefix = "fwe/fweCamera";
	
	@Autowired
	private IFweCameraService fweCameraService;
	
	@RequiresPermissions("fwe:fweCamera:view")
	@GetMapping()
	public String fweCamera()
	{
	    return prefix + "/fweCamera";
	}
	
	/**
	 * 查询摄像机列表
	 */
	@RequiresPermissions("fwe:fweCamera:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweCamera fweCamera)
	{
		startPage();
        List<FweCamera> list = fweCameraService.selectFweCameraList(fweCamera);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出摄像机列表
	 */
	@RequiresPermissions("fwe:fweCamera:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweCamera fweCamera)
    {
    	List<FweCamera> list = fweCameraService.selectFweCameraList(fweCamera);
        ExcelUtil<FweCamera> util = new ExcelUtil<FweCamera>(FweCamera.class);
        return util.exportExcel(list, "fweCamera");
    }
	
	/**
	 * 新增摄像机
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存摄像机
	 */
	@RequiresPermissions("fwe:fweCamera:add")
	@Log(title = "摄像机", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweCamera fweCamera)
	{
		fweCamera.setCreateBy(ShiroUtils.getLoginName());
		fweCamera.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCameraService.insertFweCamera(fweCamera));
	}

	/**
	 * 修改摄像机
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweCamera fweCamera = fweCameraService.selectFweCameraById(id);
		mmap.put("fweCamera", fweCamera);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存摄像机
	 */
	@RequiresPermissions("fwe:fweCamera:edit")
	@Log(title = "摄像机", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweCamera fweCamera)
	{
		fweCamera.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCameraService.updateFweCamera(fweCamera));
	}
	
	/**
	 * 删除摄像机
	 */
	@RequiresPermissions("fwe:fweCamera:remove")
	@Log(title = "摄像机", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweCameraService.deleteFweCameraByIds(ids));
	}
	
}
