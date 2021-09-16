package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweTeachingBuilding;
import com.flyt.fwe.service.IFweTeachingBuildingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教学楼 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweTeachingBuilding")
public class FweTeachingBuildingController extends BaseController
{
    private String prefix = "fwe/fweTeachingBuilding";
	
	@Autowired
	private IFweTeachingBuildingService fweTeachingBuildingService;
	
	@RequiresPermissions("fwe:fweTeachingBuilding:view")
	@GetMapping()
	public String fweTeachingBuilding()
	{
	    return prefix + "/fweTeachingBuilding";
	}
	
	/**
	 * 查询教学楼列表
	 */
	@RequiresPermissions("fwe:fweTeachingBuilding:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweTeachingBuilding fweTeachingBuilding)
	{
		startPage();
        List<FweTeachingBuilding> list = fweTeachingBuildingService.selectFweTeachingBuildingList(fweTeachingBuilding);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出教学楼列表
	 */
	@RequiresPermissions("fwe:fweTeachingBuilding:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweTeachingBuilding fweTeachingBuilding)
    {
    	List<FweTeachingBuilding> list = fweTeachingBuildingService.selectFweTeachingBuildingList(fweTeachingBuilding);
        ExcelUtil<FweTeachingBuilding> util = new ExcelUtil<FweTeachingBuilding>(FweTeachingBuilding.class);
        return util.exportExcel(list, "fweTeachingBuilding");
    }
	
	/**
	 * 新增教学楼
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教学楼
	 */
	@RequiresPermissions("fwe:fweTeachingBuilding:add")
	@Log(title = "教学楼", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweTeachingBuilding fweTeachingBuilding)
	{
		fweTeachingBuilding.setCreateBy(ShiroUtils.getLoginName());
		fweTeachingBuilding.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweTeachingBuildingService.insertFweTeachingBuilding(fweTeachingBuilding));
	}

	/**
	 * 修改教学楼
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweTeachingBuilding fweTeachingBuilding = fweTeachingBuildingService.selectFweTeachingBuildingById(id);
		mmap.put("fweTeachingBuilding", fweTeachingBuilding);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教学楼
	 */
	@RequiresPermissions("fwe:fweTeachingBuilding:edit")
	@Log(title = "教学楼", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweTeachingBuilding fweTeachingBuilding)
	{
		fweTeachingBuilding.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweTeachingBuildingService.updateFweTeachingBuilding(fweTeachingBuilding));
	}
	
	/**
	 * 删除教学楼
	 */
	@RequiresPermissions("fwe:fweTeachingBuilding:remove")
	@Log(title = "教学楼", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweTeachingBuildingService.deleteFweTeachingBuildingByIds(ids));
	}
	
}
