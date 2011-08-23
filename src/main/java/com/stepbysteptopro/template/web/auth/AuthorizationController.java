package com.stepbysteptopro.template.web.auth;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizationController {
    @RequestMapping(method = RequestMethod.GET, value = "/accessDenied.do")
    public String accessDenied(ModelMap model, HttpServletRequest request) {
        AccessDeniedException ex = (AccessDeniedException) request.getAttribute(WebAttributes.ACCESS_DENIED_403);
       
        model.addAttribute("errorDetails", ex.getMessage());
        
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        model.addAttribute("errorTrace", sw.toString());
        
        return "/auth/accessDenied";
    }
}
