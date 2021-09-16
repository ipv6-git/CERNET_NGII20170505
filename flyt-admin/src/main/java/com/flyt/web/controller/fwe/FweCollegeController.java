package com.flyt.web.controller.fwe;

import com.flyt.common.annotation.Log;
import com.flyt.common.core.controller.BaseController;
import com.flyt.common.core.domain.AjaxResult;
import com.flyt.common.core.page.TableDataInfo;
import com.flyt.common.enums.BusinessType;
import com.flyt.common.utils.poi.ExcelUtil;
import com.flyt.framework.util.ShiroUtils;
import com.flyt.fwe.domain.FweCollege;
import com.flyt.fwe.service.IFweCollegeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学院 信息操作处理
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/fwe/fweCollege")
public class FweCollegeController extends BaseController
{
    private String prefix = "fwe/fweCollege";
	
	@Autowired
	private IFweCollegeService fweCollegeService;
	
	@RequiresPermissions("fwe:fweCollege:view")
	@GetMapping()
	public String fweCollege()
	{
	    return prefix + "/fweCollege";
	}
	
	/**
	 * 查询学院列表
	 */
	@RequiresPermissions("fwe:fweCollege:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FweCollege fweCollege)
	{
		startPage();
        List<FweCollege> list = fweCollegeService.selectFweCollegeList(fweCollege);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学院列表
	 */
	@RequiresPermissions("fwe:fweCollege:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FweCollege fweCollege)
    {
    	List<FweCollege> list = fweCollegeService.selectFweCollegeList(fweCollege);
        ExcelUtil<FweCollege> util = new ExcelUtil<FweCollege>(FweCollege.class);
        return util.exportExcel(list, "fweCollege");
    }
	
	/**
	 * 新增学院
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学院
	 */
	@RequiresPermissions("fwe:fweCollege:add")
	@Log(title = "学院", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FweCollege fweCollege)
	{		
		fweCollege.setCreateBy(ShiroUtils.getLoginName());
		fweCollege.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCollegeService.insertFweCollege(fweCollege));
	}

	/**
	 * 修改学院
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FweCollege fweCollege = fweCollegeService.selectFweCollegeById(id);
		mmap.put("fweCollege", fweCollege);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学院
	 */
	@RequiresPermissions("fwe:fweCollege:edit")
	@Log(title = "学院", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FweCollege fweCollege)
	{
		fweCollege.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(fweCollegeService.updateFweCollege(fweCollege));
	}
	
	/**
	 * 删除学院
	 */
	@RequiresPermissions("fwe:fweCollege:remove")
	@Log(title = "学院", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fweCollegeService.deleteFweCollegeByIds(ids));
	}
	
}
