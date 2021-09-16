package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweMajor;
import com.flyt.fwe.service.IFweMajorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专业 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweMajor")
public class FweMajorController extends BaseController
{
    private String prefix = "fwe/fweMajor";
	
	@Autowired
	private IFweMajorService fweMajorService;
	
	@RequiresPermissions("fwe:fweMajor:view")
	@GetMapping()
	public String fweMajor()
	{
	    return prefix + "/fweMajor";
	}
	
	/**
	 * 查询专业列表
	 */
	@RequiresPermissions("fwe:fweMajor:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweMajor fweMajor)
	{
		startPage();
        List<FweMajor> list = fweMajorService.selectFweMajorList(fweMajor);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出专业列表
	 */
	@RequiresPermissions("fwe:fweMajor:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweMajor fweMajor)
    {
    	List<FweMajor> list = fweMajorService.selectFweMajorList(fweMajor);
        ExcelUtil<FweMajor> util = new ExcelUtil<FweMajor>(FweMajor.class);
        return util.exportExcel(list, "fweMajor");
    }
	
	/**
	 * 新增专业
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存专业
	 */
	@RequiresPermissions("fwe:fweMajor:add")
	@Log(title = "专业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweMajor fweMajor)
	{
		fweMajor.setCreateBy(ShiroUtils.getLoginName());
		fweMajor.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweMajorService.insertFweMajor(fweMajor));
	}

	/**
	 * 修改专业
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweMajor fweMajor = fweMajorService.selectFweMajorById(id);
		mmap.put("fweMajor", fweMajor);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存专业
	 */
	@RequiresPermissions("fwe:fweMajor:edit")
	@Log(title = "专业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweMajor fweMajor)
	{
		fweMajor.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweMajorService.updateFweMajor(fweMajor));
	}
	
	/**
	 * 删除专业
	 */
	@RequiresPermissions("fwe:fweMajor:remove")
	@Log(title = "专业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweMajorService.deleteFweMajorByIds(ids));
	}
	
}
