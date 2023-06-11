package com.qrcode.buspass.controller;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.qrcode.buspass.entity.RateMasterEntity;
import com.qrcode.buspass.entity.SourceMastereEntity;
import com.qrcode.buspass.service.IDestinationMasterService;
import com.qrcode.buspass.service.RateMasterService;
import com.qrcode.buspass.service.SourceMasterService;

@Controller
public class RateMasterController {
	@Autowired
	RateMasterService rateMasterService;
	
	@Autowired
	SourceMasterService masterService;
	
	@Autowired
	IDestinationMasterService iDestinationMasterService;

	@GetMapping("/rateMasterPage")
	public String rateMasterPage(@ModelAttribute("rateMasterEntity") RateMasterEntity rateMasterEntity, Model model) {
		model.addAttribute("rateMasterEntity", rateMasterEntity);

		List<SourceMastereEntity> lst = rateMasterService.fetchAllSource();
		model.addAttribute("lst", lst);

		List<DestinationMasterEntity> ldt = rateMasterService.fetAllDestination();
		model.addAttribute("ldt", ldt);

		List<Object[]> rateList = rateMasterService.fetchAllRate();
		List<RateMasterEntity> rateList2 = new ArrayList<RateMasterEntity>();
		for (Iterator i = rateList.iterator(); i.hasNext();) {

			Object[] objects = (Object[]) i.next();
			RateMasterEntity rateOp = new RateMasterEntity();
			rateOp.setSourceId(Integer.parseInt(objects[0].toString()));
			rateOp.setSourceName(objects[1].toString());
			rateOp.setDestinationId(Integer.parseInt(objects[2].toString()));
			rateOp.setDestinationName(objects[3].toString());
			rateOp.setRateId(Integer.parseInt(objects[4].toString()));
			rateOp.setFare(Double.parseDouble(objects[5].toString()));
			rateList2.add(rateOp);
		}

		model.addAttribute("rateList2", rateList2);
		String msg = (String) model.asMap().get("message");
		model.addAttribute("msg", msg);
		return "rate-master-page";
	}

	@PostMapping("/saveRateMaster")
	public String saveRateMaster(@ModelAttribute("rateMasterEntity") RateMasterEntity rateMasterEntity, Model model,
			RedirectAttributes redirectAttributes) {

		System.out.println("i am ratemaster " + rateMasterEntity.toString());
		// Integer count=
		// rateMasterService.findSouDesfare(rateMasterEntity.getSourceId(),rateMasterEntity.getDestinationId());

		Integer saveId = rateMasterService.save(rateMasterEntity);

		if (saveId > 0)
			redirectAttributes.addFlashAttribute("message", "success");
		else
			redirectAttributes.addFlashAttribute("message", "failure");
		return "redirect:/rateMasterPage";
	}
	
	@GetMapping("/deleteRate/{rateId}")
	public String deleteData(@PathVariable Integer rateId, RedirectAttributes redirectAttributes) {
		try {
			rateMasterService.deleteRate(rateId);
			redirectAttributes.addFlashAttribute("message", "Rate has been removed form the Application");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "something went worng");
			e.printStackTrace();
		}
		// redirectAttributes.addFlashAttribute("message","success");
		return "redirect:/rateMasterPage";
	}

	@GetMapping("/editRate/{rateId}")
	public String showEdit(@PathVariable Integer rateId, RedirectAttributes attributes, Model model) {
		String page = null;
		try {
			RateMasterEntity rateMasterEntity = rateMasterService.getRateDetails(rateId);
			SourceMastereEntity sourceMastereEntity= masterService.getSourceDetails(rateMasterEntity.getSourceId());
			rateMasterEntity.setSourceName(sourceMastereEntity.getSourceName());
			DestinationMasterEntity destinationMasterEntity=iDestinationMasterService.getDestination(rateMasterEntity.getDestinationId());
			rateMasterEntity.setDestinationName(destinationMasterEntity.getDestinationName());
			model.addAttribute("rateMasterEntity", rateMasterEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "rate-master-edit";
	}

	@PostMapping("/updateRate")
	public String updateData(@ModelAttribute("rateMasterEntity") RateMasterEntity rateMasterEntity, RedirectAttributes redirectAttributes) {
		
		try {
		rateMasterService.updateRatedetails(rateMasterEntity);
		redirectAttributes.addFlashAttribute("message", "Rate is Updated successfully");
		}catch (Exception e) {
			e.getStackTrace();
		}
		return "redirect:/rateMasterPage";
	}
}
