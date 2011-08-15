package com.stepbysteptopro.template.web.registration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stepbysteptopro.template.web.BaseFormController;



@Controller
@RequestMapping("/registration")
public class RegistrationController extends BaseFormController {
    
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    public RegistrationForm registrationForm() {
        return new RegistrationForm();  
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registrationFormSubmit(RegistrationForm form, BindingResult errors, HttpServletRequest request, 
            HttpServletResponse response)
            throws Exception {
       /* if (log.isDebugEnabled()) {
            log.debug("entering 'onSubmit' method...");
        }
        
        user.setEnabled(true);

        // Set the default user role on this new user
        user.addRole(roleManager.getRole(Constants.USER_ROLE));

        try {
            this.getUserManager().saveUser(user);
        } catch (AccessDeniedException ade) {
            // thrown by UserSecurityAdvice configured in aop:advisor userManagerSecurity
            log.warn(ade.getMessage());
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return null; 
        } catch (UserExistsException e) {
            errors.rejectValue("username", "errors.existing.user",
                    new Object[]{user.getUsername(), user.getEmail()}, "duplicate user");

            // redisplay the unencrypted passwords
            user.setPassword(user.getConfirmPassword());
            return "signup";
        }

        saveMessage(request, getText("user.registered", user.getUsername()));
        request.getSession().setAttribute(Constants.REGISTERED, Boolean.TRUE);

        // log user in automatically
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getConfirmPassword(), user.getAuthorities());
        auth.setDetails(user);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Send user an e-mail
        if (log.isDebugEnabled()) {
            log.debug("Sending user '" + user.getUsername() + "' an account information e-mail");
        }

        // Send an account information e-mail
        message.setSubject(getText("signup.email.subject"));

        try {
            sendUserMessage(user, getText("signup.email.message"), RequestUtil.getAppURL(request));
        } catch (MailException me) {
            saveError(request, me.getMostSpecificCause().getMessage());
        }*/
        
        return "redirect:mainMenu.html";
    }
}
