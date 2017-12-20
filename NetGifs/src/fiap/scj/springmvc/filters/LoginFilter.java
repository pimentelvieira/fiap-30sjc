package fiap.scj.springmvc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

	private static String ALLOWED_PATH = "/NetGifs/login";
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Passou no filtro!");
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		System.out.println(request.getRequestURI());
		
		if(request.getRequestURI().contains(ALLOWED_PATH)) {
			chain.doFilter(req, resp);
		} else {
			Object user = request.getSession().getAttribute("usrLogado");
			if (user == null) {
				request.getRequestDispatcher("/nologin").forward(request, response);
			} else {
				chain.doFilter(req, resp);
			}
		}
	}
}
