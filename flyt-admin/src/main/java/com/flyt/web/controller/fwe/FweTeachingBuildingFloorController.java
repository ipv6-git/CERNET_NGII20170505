package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweTeachingBuildingFloor;
import com.flyt.fwe.service.IFweTeachingBuildingFloorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教学楼楼层 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweTeachingBuildingFloor")
public class FweTeachingBuildingFloorController extends BaseController
{
    private String prefix = "fwe/fweTeachingBuildingFloor";
	
	@Autowired
	private IFweTeachingBuildingFloorService fweTeachingBuildingFloorService;
	
	@RequiresPermissions("fwe:fweTeachingBuildingFloor:view")
	@GetMapping()
	public String fweTeachingBuildingFloor()
	{
	    return prefix + "/fweTeachingBuildingFloor";
	}
	
	/**
	 * 查询教学楼楼层列表
	 */
	@RequiresPermissions("fwe:fweTeachingBuildingFloor:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweTeachingBuildingFloor fweTeachingBuildingFloor)
	{
		startPage();
        List<FweTeachingBuildingFloor> list = fweTeachingBuildingFloorService.selectFweTeachingBuildingFloorList(fweTeachingBuildingFloor);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出教学楼楼层列表
	 */
	@RequiresPermissions("fwe:fweTeachingBuildingFloor:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweTeachingBuildingFloor fweTeachingBuildingFloor)
    {
    	List<FweTeachingBuildingFloor> list = fweTeachingBuildingFloorService.selectFweTeachingBuildingFloorList(fweTeachingBuildingFloor);
        ExcelUtil<FweTeachingBuildingFloor> util = new ExcelUtil<FweTeachingBuildingFloor>(FweTeachingBuildingFloor.class);
        return util.exportExcel(list, "fweTeachingBuildingFloor");
    }
	
	/**
	 * 新增教学楼楼层
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教学楼楼层
	 */
	@RequiresPermissions("fwe:fweTeachingBuildingFloor:add")
	@Log(title = "教学楼楼层", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweTeachingBuildingFloor fweTeachingBuildingFloor)
	{
		fweTeachingBuildingFloor.setCreateBy(ShiroUtils.getLoginName());
		fweTeachingBuildingFloor.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweTeachingBuildingFloorService.insertFweTeachingBuildingFloor(fweTeachingBuildingFloor));
	}

	/**
	 * 修改教学楼楼层
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweTeachingBuildingFloor fweTeachingBuildingFloor = fweTeachingBuildingFloorService.selectFweTeachingBuildingFloorById(id);
		mmap.put("fweTeachingBuildingFloor", fweTeachingBuildingFloor);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教学楼楼层
	 */
	@RequiresPermissions("fwe:fweTeachingBuildingFloor:edit")
	@Log(title = "教学楼楼层", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweTeachingBuildingFloor fweTeachingBuildingFloor)
	{
		fweTeachingBuildingFloor.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweTeachingBuildingFloorService.updateFweTeachingBuildingFloor(fweTeachingBuildingFloor));
	}
	
	/**
	 * 删除教学楼楼层
	 */
	@RequiresPermissions("fwe:fweTeachingBuildingFloor:remove")
	@Log(title = "教学楼楼层", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweTeachingBuildingFloorService.deleteFweTeachingBuildingFloorByIds(ids));
	}
	
}
