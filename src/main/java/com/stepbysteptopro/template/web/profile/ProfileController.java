package com.stepbysteptopro.template.web.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stepbysteptopro.template.model.user.User;
import com.stepbysteptopro.template.service.user.UserService;


@Controller
@RequestMapping("/profile")
public class ProfileController {
    
    @Autowired
    private UserService userService;
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

	/*
	    public List<Entity> getSkillStatusesLabels() {
        List<Entity> labels = new ArrayList<Entity>();
        labels.add(new Entity(SkillConstants.STATUS_PRIMARY, getMessage("common.primary")));
        labels.add(new Entity(SkillConstants.STATUS_CORE, getMessage("common.core")));
        labels.add(new Entity(SkillConstants.STATUS_REGULAR, getMessage("common.regular")));
        labels.add(new Entity(SkillConstants.STATUS_APPLICANT, getMessage("common.applicant")));
        return labels;
    }
	
	@ModelAttribute("sex")
	public List<Entity> getSex() {
		return reservationService.getAllSportTypes();
	}
	*/
	
    @RequestMapping(value="/view.do", method=RequestMethod.GET)
    public String viewProfile(Model model) {
        User user = new User(); // userService.getUser(1L);
        model.addAttribute("user", user);
        return "viewProfile";
    }
    
    @RequestMapping(value="/edit.do", method=RequestMethod.GET)
    public String editProfile(@RequestParam(value="userId", required = false) Long userId, Model model) {
        if(userId == null) {
            model.addAttribute("user", new User()); 
        } else {
            model.addAttribute("user", new User() ); //userService.getUser(userId));
        }
        return "editProfile";
    }
    
    @RequestMapping(value="/save.do", method=RequestMethod.POST)
    public String saveProfile(@ModelAttribute("profile") User user) {
	/*
	
	reservationValidator.validate(profile, result);
	    
		if (result.hasErrors()) {
			model.addAttribute("profile", profile);
			return "reservationForm";
		} else {
			reservationService.make(profile);
			return "redirect:reservationSuccess";
		}
	*/
	
		//The redirect: prefix in the view name is used to avoid a problem known as duplicate form submission
		//To avoid this problem, you can apply the post/redirect/get design pattern, which recommends
        //redirecting to another URL after a form submission is handled successfully, instead of returning an
        //HTML page directly.
        return "redirect:viewProfile";
    }
}
