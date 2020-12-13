package com.finalproject.web.filter;

import com.finalproject.entity.User;
import com.finalproject.service.SecurityCheck;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.finalproject.constants.PageUrlConstants.LOGIN_PAGE;
import static com.finalproject.constants.PageUrlConstants.NO_ACCESS_PAGE;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(AuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String path = getPath(httpServletRequest);

        if (!SecurityCheck.isSecurePage(path)) {
            LOG.info("Page is not secured: " + path);
            chain.doFilter(request, response);
            return;
        }
        String contextPath = httpServletRequest.getContextPath();

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            LOG.info("User not logged");
            httpServletResponse.sendRedirect(contextPath + LOGIN_PAGE);
            return;
        }

        boolean hasPermission = SecurityCheck.hasPermission(path, user.getSecurityAccess());

        if (!hasPermission) {
            LOG.info("User does not have permission : " + user + " , " + path);
            httpServletResponse.sendRedirect(contextPath + NO_ACCESS_PAGE);
            return;
        }

        LOG.info("User has permission. Continue");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private String getPath(HttpServletRequest req) {
        String requestUri = req.getRequestURI();
        int lastPath = requestUri.lastIndexOf('/');
        String path = requestUri.substring(lastPath);
        LOG.info("Path: " + path);
        return path;
    }
}
