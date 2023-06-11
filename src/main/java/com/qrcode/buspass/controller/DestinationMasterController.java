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

import com.qrcode.buspass.entity.DestinationMasterEntity;
import com.qrcode.buspass.entity.SourceMastereEntity;
import com.qrcode.buspass.service.IDestinationMasterService;
import com.qrcode.buspass.service.SourceMasterService;

@Controller
public class DestinationMasterController {
	@Autowired
	IDestinationMasterService destinationMasterService;

	@GetMapping("/destinationMasterPage")
	public String sourceMasterPage(@ModelAttribute("destinationMasterEntity") DestinationMasterEntity destinationMasterEntity,
			Model model) {
		model.addAttribute("destinationMasterEntity", destinationMasterEntity);
		List<DestinationMasterEntity> DestinationList = destinationMasterService.getDestination();
		System.out.println("sourceList  :--" + DestinationList.toString());
		model.addAttribute("sourceList", DestinationList);
		String msg = (String) model.asMap().get("message");
		model.addAttribute("msg", msg);
		return "destination-master-page";

	}

	@PostMapping("/saveDestinationMaster")
	public String saveSourceMaster(@ModelAttribute("destinationMasterEntity") DestinationMasterEntity destinationMasterEntity,
			Model model, RedirectAttributes redirectAttributes) {

		System.out.println("i am source    " + destinationMasterEntity.getDestinationName());

		// finding the source name for present or not
		Integer count = destinationMasterService.getDestination(destinationMasterEntity.getDestinationName());

		if (count > 0)
			redirectAttributes.addFlashAttribute("message",destinationMasterEntity.getDestinationName() + " Source is available already");
		else {
			Integer saveId = destinationMasterService.save(destinationMasterEntity);
			if (saveId > 0)

				redirectAttributes.addFlashAttribute("message", "success");
			else
				redirectAttributes.addFlashAttribute("message", "failure");
		}
		return "redirect:/destinationMasterPage";

	}
	
	

	@GetMapping("/deleteDestination/{destinationId}")
	public String deleteData(@PathVariable Integer destinationId, RedirectAttributes redirectAttributes) {
		try {
			destinationMasterService.deleteDestination(destinationId);
			redirectAttributes.addFlashAttribute("message", "sourece has been removed deleted");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "something went worng");
			e.printStackTrace();
		}
		// redirectAttributes.addFlashAttribute("message","success");
		return "redirect:/destinationMasterPage";
	}

	@GetMapping("/editDestination/{destinationId}")
	public String showEdit(@PathVariable Integer destinationId, RedirectAttributes attributes, Model model) {
		String page = null;
		try {
			DestinationMasterEntity destinationMasterEntity = destinationMasterService.getDestination(destinationId);
			model.addAttribute("destinationMasterEntity", destinationMasterEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "destination-master_edit";
	}

	@PostMapping("/updateDestination")
	public String updateData(@ModelAttribute("sourceMastereEntity") DestinationMasterEntity destinationMasterEntity, RedirectAttributes redirectAttributes) {
	
		try {
			destinationMasterService.updateDestiontiondetails(destinationMasterEntity);
		redirectAttributes.addFlashAttribute("message", "Source Name Updated successfully");
		}catch (Exception e) {
			e.getStackTrace();
		}
		return "redirect:/destinationMasterPage";
	}
}
