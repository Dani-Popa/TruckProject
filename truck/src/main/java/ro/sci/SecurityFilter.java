package ro.sci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.sci.domain.User;
import ro.sci.service.SecurityService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityFilter implements Filter {

	@Autowired
	private SecurityService securityService;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request,
						 ServletResponse response,
						 FilterChain chain)
			throws IOException, ServletException {


		User user = (User) ((HttpServletRequest) request)
				.getSession().getAttribute("currentUser");

		securityService.setCurrentUser(user);

		String url = ((HttpServletRequest) request).getRequestURL().toString();

		if (!url.toLowerCase().contains("login")) {
			if (user == null) {

				((HttpServletRequest) request)
						.getSession().setAttribute("nextUrl", url);
				HttpServletResponse servletResponse = (HttpServletResponse) response;
				//servletResponse.sendError(401);
				servletResponse.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				servletResponse.setHeader("Location", "/login");
				return;
			} else {
//				if authorized do nothing
//				if (false) {
//					//not authorized
//						HttpServletResponse servletResponse = (HttpServletResponse) response;
//						servletResponse.sendError(401);
//						return;
//				}
			}
		}

		// System.out.println("Thread name: " + Thread.currentThread().getName()
		// +
		// ", current user: " + (user != null ? user.getUserName() : null));
		//


			chain.doFilter(request, response);



	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
