package harsh.rane.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TransactionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.err.println("Starting a transaction for req : {}" + req.getRequestURI());
		System.err.println("Committing a transaction for req : {}" + req.getAuthType());
		System.err.println("Committing a transaction for req : {}" + req.getContextPath());
		System.err.println("Committing a transaction for req : {}" + req.getHeaderNames());
		System.err.println("Committing a transaction for req : {}" + req.getProtocol());
		System.err.println("Committing a transaction for req : {}" + req.getLocales());
		System.err.println("Committing a transaction for req : {}" + res.getStatus());
		chain.doFilter(request, response);
	}

}
