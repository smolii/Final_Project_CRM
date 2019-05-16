package pl.coderslab.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = { "/priority/*", "/task/*", "/user/*", "/project/*", "/status/*" })
public class AuthorisationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		if(req.getSession().getAttribute("loggedUser")!=null) {
		chain.doFilter(request,	response);
		}
		else {System.out.println("odmowa dostepu");
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.sendRedirect("/CRM/accessDenied");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}