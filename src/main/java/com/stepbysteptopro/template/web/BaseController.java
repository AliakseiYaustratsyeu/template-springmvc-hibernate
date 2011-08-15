package com.stepbysteptopro.template.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.context.ServletContextAware;

import com.stepbysteptopro.template.common.Constants;

public class BaseController implements ServletContextAware {
    protected final transient Log log = LogFactory.getLog(getClass());
    public static final String MESSAGES_KEY = "successMessages";
    public static final String ERRORS_KEY = "errors";
    protected String cancelView;
    protected String successView;

    private MessageSourceAccessor messages;
    private ServletContext servletContext;
    
    protected SessionRegistry sessionRegistry;
    
    @Autowired
    public void setSessionRegistry(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @Autowired
    public void setMessages(MessageSource messageSource) {
        messages = new MessageSourceAccessor(messageSource);
    }

    @SuppressWarnings("unchecked")
    public void saveError(HttpServletRequest request, String error) {
        List errors = (List) request.getSession().getAttribute(ERRORS_KEY);
        if (errors == null) {
            errors = new ArrayList();
        }
        errors.add(error);
        request.getSession().setAttribute(ERRORS_KEY, errors);
    }

    @SuppressWarnings("unchecked")
    public void saveMessage(HttpServletRequest request, String msg) {
        List messages = (List) request.getSession().getAttribute(MESSAGES_KEY);

        if (messages == null) {
            messages = new ArrayList();
        }

        messages.add(msg);
        request.getSession().setAttribute(MESSAGES_KEY, messages);
    }

    /**
     * Convenience method for getting a i18n key's value. Calling getMessageSourceAccessor() is used because the
     * RequestContext variable is not set in unit tests b/c there's no DispatchServlet Request.
     * 
     * @param msgKey
     * @param locale
     *            the current locale
     * @return
     */
    public String getText(String msgKey) {
        return messages.getMessage(msgKey);
    }

    /**
     * Convenient method for getting a i18n key's value with a single string argument.
     * 
     * @param msgKey
     * @param arg
     * @param locale
     *            the current locale
     * @return
     */
    public String getText(String msgKey, String arg) {
        return getText(msgKey, new Object[] {arg});
    }

    /**
     * Convenience method for getting a i18n key's value with arguments.
     * 
     * @param msgKey
     * @param args
     * @param locale
     *            the current locale
     * @return
     */
    public String getText(String msgKey, Object[] args) {
        return messages.getMessage(msgKey, args);
    }

    protected Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * Convenience method to get the Configuration HashMap from the servlet context.
     * 
     * @return the user's populated form from the session
     */
    public Map getConfiguration() {
        Map config = (HashMap) servletContext.getAttribute(Constants.CONFIG);

        // so unit tests don't puke when nothing's been set
        if (config == null) {
            return new HashMap();
        }

        return config;
    }

    public final BaseController setCancelView(String cancelView) {
        this.cancelView = cancelView;
        return this;
    }

    public final String getCancelView() {
        // Default to successView if cancelView is invalid
        if (this.cancelView == null || this.cancelView.length() == 0) {
            return getSuccessView();
        }
        return this.cancelView;
    }

    public final String getSuccessView() {
        return this.successView;
    }

    public final BaseController setSuccessView(String successView) {
        this.successView = successView;
        return this;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    protected ServletContext getServletContext() {
        return servletContext;
    }
}
