package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweCampus;
import com.flyt.fwe.service.IFweCampusService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 校区 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweCampus")
public class FweCampusController extends BaseController
{
    private String prefix = "fwe/fweCampus";
	
	@Autowired
	private IFweCampusService fweCampusService;
	
	@RequiresPermissions("fwe:fweCampus:view")
	@GetMapping()
	public String fweCampus()
	{
	    return prefix + "/fweCampus";
	}
	
	/**
	 * 查询校区列表
	 */
	@RequiresPermissions("fwe:fweCampus:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweCampus fweCampus)
	{
		startPage();
        List<FweCampus> list = fweCampusService.selectFweCampusList(fweCampus);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出校区列表
	 */
	@RequiresPermissions("fwe:fweCampus:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweCampus fweCampus)
    {
    	List<FweCampus> list = fweCampusService.selectFweCampusList(fweCampus);
        ExcelUtil<FweCampus> util = new ExcelUtil<FweCampus>(FweCampus.class);
        return util.exportExcel(list, "fweCampus");
    }
	
	/**
	 * 新增校区
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存校区
	 */
	@RequiresPermissions("fwe:fweCampus:add")
	@Log(title = "校区", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweCampus fweCampus)
	{
		fweCampus.setCreateBy(ShiroUtils.getLoginName());
		fweCampus.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCampusService.insertFweCampus(fweCampus));
	}

	/**
	 * 修改校区
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweCampus fweCampus = fweCampusService.selectFweCampusById(id);
		mmap.put("fweCampus", fweCampus);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存校区
	 */
	@RequiresPermissions("fwe:fweCampus:edit")
	@Log(title = "校区", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweCampus fweCampus)
	{
		fweCampus.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCampusService.updateFweCampus(fweCampus));
	}
	
	/**
	 * 删除校区
	 */
	@RequiresPermissions("fwe:fweCampus:remove")
	@Log(title = "校区", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweCampusService.deleteFweCampusByIds(ids));
	}
	
}
