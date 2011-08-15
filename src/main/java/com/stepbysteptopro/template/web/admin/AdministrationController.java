package com.stepbysteptopro.template.web.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.session.SessionInformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.stepbysteptopro.template.web.BaseController;

@Controller
@RequestMapping("/administration")
public class AdministrationController extends BaseController {

    @RequestMapping(value = "/listActiveUsers.do", method = RequestMethod.GET)
    public String listActiveUsers(Model model) {
        Map<Object, Date> lastActivityDates = new HashMap<Object, Date>();
        for (Object principal : sessionRegistry.getAllPrincipals()) {
            // a principal may have multiple active sessions
            for (SessionInformation session : sessionRegistry.getAllSessions(principal, false)) {
                // no last activity stored
                if (lastActivityDates.get(principal) == null) {
                    lastActivityDates.put(principal, session.getLastRequest());
                } else {
                    // check to see if this session is newer than the last stored
                    Date prevLastRequest = lastActivityDates.get(principal);
                    if (session.getLastRequest().after(prevLastRequest)) {
                        // update if so
                        lastActivityDates.put(principal, session.getLastRequest());
                    }
                }
            }
        }

        model.addAttribute("activeUsers", lastActivityDates);
        
        int amountOfUsers = sessionRegistry.getAllPrincipals().size();
        model.addAttribute("numUsers", amountOfUsers);
        
        return ".listActiveUsers";
    }
}
