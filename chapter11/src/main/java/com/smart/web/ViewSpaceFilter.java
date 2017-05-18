package com.smart.web;

import com.smart.domain.User;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.smart.cons.CommonConstant.LOGIN_TO_URL;

/**
 * Created by Administrator on 2017/5/18.
 */
public class ViewSpaceFilter implements Filter {
    private static final String FILTERED_REQUEST = "@@session_context_filtered_request";

    private static final String[] INHERENT_URIS = {"/add", "/save", "/edit", "/update", "delete"};

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if(request != null && request.getAttribute(FILTERED_REQUEST) != null) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            User userContext = getSessionUser(httpRequest);
            if(userContext == null && isURILogin(httpRequest.getRequestURI(), httpRequest)) {
                String toUrl = httpRequest.getRequestURL().toString();
                if(!StringUtils.isEmpty(httpRequest.getQueryString())) {
                    toUrl += "?" + httpRequest.getQueryString();
                }

                httpRequest.getSession().setAttribute(LOGIN_TO_URL, toUrl);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }
           chain.doFilter(request, response);
        }
    }

    private boolean isURILogin(String requestURI, HttpServletRequest request) {
        for (String uri : INHERENT_URIS) {
            if(requestURI != null && requestURI.indexOf(uri) >= 0) {
                return true;
            }
        }
        return false;
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    protected User getSessionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("USER_CONTEXT");
    }

    public void destroy() {

    }
}
