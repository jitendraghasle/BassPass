package com.qrcode.buspass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qrcode.buspass.entity.SourceMastereEntity;
import com.qrcode.buspass.service.SourceMasterService;

@Controller
public class SourceMasterController {

	@Autowired
	SourceMasterService sourceMasterService;

	@GetMapping("/sourceMasterPage")
	public String sourceMasterPage(@ModelAttribute("sourceMastereEntity") SourceMastereEntity sourceMastereEntity,
			Model model) {
		model.addAttribute("sourceMastereEntity", sourceMastereEntity);
		List<SourceMastereEntity> sourceList = sourceMasterService.getSourceList();
		System.out.println("sourceList  :--" + sourceList.toString());
		model.addAttribute("sourceList", sourceList);
		String msg = (String) model.asMap().get("message");
		model.addAttribute("msg", msg);
		return "source-master-page";

	}

	@PostMapping("/saveSourceMaster")
	public String saveSourceMaster(@ModelAttribute("sourceMastereEntity") SourceMastereEntity sourceMastereEntity,
			Model model, RedirectAttributes redirectAttributes) {

		System.out.println("i am source    " + sourceMastereEntity.getSourceName());

		// finding the source name for present or not
		Integer count = sourceMasterService.getSource(sourceMastereEntity.getSourceName());

		if (count > 0)
			redirectAttributes.addFlashAttribute("message",
					sourceMastereEntity.getSourceName() + " Destination is available already");
		else {
			Integer saveId = sourceMasterService.save(sourceMastereEntity);
			if (saveId > 0)

				redirectAttributes.addFlashAttribute("message", "success");
			else
				redirectAttributes.addFlashAttribute("message", "failure");
		}
		// model.addAttribute("sourceMastereEntity", sourceMastereEntity);
		return "redirect:/sourceMasterPage";

	}

	@GetMapping("/deleteSource/{sourceId}")
	public String deleteData(@PathVariable Integer sourceId, RedirectAttributes redirectAttributes) {
		try {
			sourceMasterService.deleteSource(sourceId);
			redirectAttributes.addFlashAttribute("message", "sourece has been removed deleted");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "something went worng");
			e.printStackTrace();
		}
		// redirectAttributes.addFlashAttribute("message","success");
		return "redirect:/sourceMasterPage";
	}

	@GetMapping("/editSource/{sourceId}")
	public String showEdit(@PathVariable Integer sourceId, RedirectAttributes attributes, Model model) {
		String page = null;
		try {
			SourceMastereEntity sourceMastereEntity = sourceMasterService.getSourceDetails(sourceId);
			model.addAttribute("sourceMastereEntity", sourceMastereEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "source-master_edit";
	}

	@PostMapping("/updateSource")
	public String updateData(@ModelAttribute("sourceMastereEntity") SourceMastereEntity sourceMastereEntity, RedirectAttributes redirectAttributes) {
		sourceMastereEntity.getSourceId();
		try {
		sourceMasterService.updateSourcedetails(sourceMastereEntity);
		redirectAttributes.addFlashAttribute("message", "Source Name Updated successfully");
		}catch (Exception e) {
			e.getStackTrace();
		}
		return "redirect:/sourceMasterPage";
	}

}
