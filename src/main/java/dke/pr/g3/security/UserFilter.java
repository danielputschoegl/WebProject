package dke.pr.g3.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dke.pr.g3.bean.LoginBean;
import dke.pr.g3.model.Role;

/**
 * Filter checks if LoginBean has loginIn property set to true. If it is not set
 * then request is being redirected to the login.xhtml page.
 * 
 * @author itcuties
 *
 */
public class UserFilter implements Filter {

	/**
	 * Checks if user is logged in. If not it redirects to the login.xhtml page.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LoginBean loginBean = (LoginBean) ((HttpServletRequest) request).getSession().getAttribute("loginBean");
		String uri = ((HttpServletRequest) request).getRequestURI();
		String page = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));

		if (loginBean == null || !loginBean.isLoggedIn()) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
		} else {
			Role role = loginBean.getUser().getRole();

			if (role == Role.RA) {
				if (page.equals("")) {
					String contextPath = ((HttpServletRequest) request).getContextPath();
					((HttpServletResponse) response).sendRedirect(contextPath + "/secured/index.xhtml");
				}
			} else if (role == Role.RD) {
				if (page.equals("")) {
					String contextPath = ((HttpServletRequest) request).getContextPath();
					((HttpServletResponse) response).sendRedirect(contextPath + "/secured/index.xhtml");
				}
			} else if (role == Role.D) {
				if (page.equals("")) {
					String contextPath = ((HttpServletRequest) request).getContextPath();
					((HttpServletResponse) response).sendRedirect(contextPath + "/secured/index.xhtml");
				}
			} else if (role == Role.U) {
				if (page.equals("")) {
					String contextPath = ((HttpServletRequest) request).getContextPath();
					((HttpServletResponse) response).sendRedirect(contextPath + "/secured/index.xhtml");
				}
			} else {
				String contextPath = ((HttpServletRequest) request).getContextPath();
				((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
			}
		}

		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
