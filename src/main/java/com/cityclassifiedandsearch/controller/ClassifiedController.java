package com.cityclassifiedandsearch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cityclassifiedandsearch.bean.Classified;
import com.cityclassifiedandsearch.repo.ClassifiedRepository;
import com.cityclassifiedandsearch.repo.UserRepository;
import com.cityclassifiedandsearch.service.ClassifiedService;
import com.cityclassifiedandsearch.service.UserServiceImpl;

@Controller
public class ClassifiedController {
	@Autowired
	private ClassifiedService classifiedService;
	
	@Autowired
	private ClassifiedRepository classifiedRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserRepository userRepository;
	
	public int getCurrentUserId(Authentication authentication) {
		return (userRepository.findByUserEmail(authentication.getName())).getUserId();
	}
	
	//Guest
	/*View Classifieds*/
	
	//View CLassifieds
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("classifieds", classifiedService.getAllClassifieds());
		return "index";
	}
	@GetMapping("/viewclassified/{classifiedId}")
	public String viewClassified(Model model, @PathVariable("classifiedId") int classifiedId) {
		Classified classified = classifiedService.getClassifiedById(classifiedId);
		if(classified==null) model.addAttribute("error", "Classified doesn't exist");
		model.addAttribute("classified", classified);
		model.addAttribute("userDetails", userServiceImpl.getUserById(classified.getUserId()));
		return "viewclassified";
	}
	
	//User
	/* View Classifieds
	 * Post Classifieds
	 * Update Classifieds
	 * Delete Classifieds */
	
	//View CLassifieds
	@GetMapping("/user/index")
	public String userIndex(Model model, Authentication authentication) {
		model.addAttribute("classifieds", classifiedService.getAllClassifieds());
		model.addAttribute("currentUserId", getCurrentUserId(authentication));
		return "userindex";
	}
	@GetMapping("/user/viewclassified/{classifiedId}")
	public String userViewClassified(Model model, @PathVariable("classifiedId") int classifiedId) {
		Classified classified = classifiedService.getClassifiedById(classifiedId);
		if(classified==null) model.addAttribute("error", "Classified doesn't exist");
		model.addAttribute("classified", classified);
		model.addAttribute("userDetails", userServiceImpl.getUserById(classified.getUserId()));
		return "userviewclassified";
	}
	@GetMapping("/user/myclassifieds")
	public String myClassified(Model model, Authentication authentication) {
		model.addAttribute("myClassifieds", classifiedService.getClassifiedByUserId(getCurrentUserId(authentication)));
		return "myclassifieds";
	}
	
	//Post Classifieds
	@GetMapping("/user/postclassified")
	public String postClassifiedForm() {
		return "postclassified";
	}
	@PostMapping("/user/postclassified")
	public String postClassified(Authentication authentication,
			@RequestParam("classifiedCategory")String classifiedCategory,
			@RequestParam("classifiedTitle")String classifiedTitle,
			@RequestParam("description")String description,
			@RequestParam("file") MultipartFile image) {
		try {
			if(image.isEmpty()) {
				classifiedService.createClassified(getCurrentUserId(authentication), classifiedCategory, classifiedTitle, description);
			}
			else {
				classifiedService.createClassified(getCurrentUserId(authentication), classifiedCategory, classifiedTitle, description, image);
			}
		}
		catch (IOException e) {
			return "redirect:/user/postclassified?error";
		}
		return "redirect:/user/postclassified?success";
	}
	
	//Update Classifieds
	@GetMapping("/user/editclassified/{classifiedId}")
	public String editClassifiedForm(@PathVariable("classifiedId") int classifiedId, Model model) {
		model.addAttribute("classified", classifiedService.getClassifiedById(classifiedId));
		return "editclassified";
	}
	@PostMapping("/user/editclassified/{classifiedId}")
	public String editClassified(@PathVariable("classifiedId")int classifiedId,
			@RequestParam("classifiedCategory")String classifiedCategory,
			@RequestParam("classifiedTitle")String classifiedTitle,
			@RequestParam("description")String description,
			@RequestParam("file") MultipartFile image) throws IOException {
		try {
			if(image.isEmpty()) {
				classifiedService.updateClassified(classifiedId, classifiedCategory, classifiedTitle, description);
			}
			else {
				classifiedService.updateClassified(classifiedId, classifiedCategory, classifiedTitle, description, image);
			}
		}
		catch (IOException e) {
			return "redirect:/user/editclassified/" + classifiedId + "?error";
		}
		return "redirect:/user/editclassified/" + classifiedId + "?success";
	}
	
	//Delete Classifieds
	@GetMapping("/user/deleteclassified/{classifiedId}")
	public String deleteClassified(@PathVariable("classifiedId")int classifiedId) {
		classifiedService.deleteClassifiedById(classifiedId);
		return "redirect:/user/myclassifieds?success";
	}
	
	//Admin
	/* View Classifieds
	 * Approve/Reject Classifieds
	 * Delete CLassifieds */
	
	//View Classifieds
	@GetMapping("/admin/index")
	public String adminIndex(Model model) {
		model.addAttribute("classifieds", classifiedService.getAllClassifieds());
		return "adminindex";
	}
	@GetMapping("/admin/viewclassified/{classifiedId}")
	public String adminViewClassified(Model model, @PathVariable("classifiedId") int classifiedId) {
		Classified classified = classifiedService.getClassifiedById(classifiedId);
		if(classified==null) model.addAttribute("error", "Classified doesn't exist");
		model.addAttribute("classified", classified);
		model.addAttribute("userDetails", userServiceImpl.getUserById(classified.getUserId()));
		return "adminviewclassified";
	}
	
	//Approve/Reject Classifieds
	@GetMapping("/admin/approve")
	public String viewPendingApproval(Model model) {
		model.addAttribute("classifieds", classifiedRepository.findByApproval(false));
		return "approve";
	}
	@GetMapping("/admin/approve/{classifiedId}")
	public String approveClassified(@PathVariable("classifiedId") int classifiedId) {
		classifiedService.approve(classifiedId);
		return "redirect:/admin/approve?success";	
	}
	@GetMapping("/admin/reject/{classifiedId}")
	public String rejectClassified(@PathVariable("classifiedId") int classifiedId) {
		classifiedService.deleteClassifiedById(classifiedId);
		return "redirect:/admin/approve?success";	
	}
	
	//Delete Classified
	@GetMapping("/admin/deleteclassified/{classifiedId}")
	public String adminDeleteClassified(@PathVariable("classifiedId") int classifiedId) {
		classifiedService.deleteClassifiedById(classifiedId);
		return "redirect:/admin/index?success";	
	}
}
