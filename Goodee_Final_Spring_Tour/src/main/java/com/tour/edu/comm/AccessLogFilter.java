package com.tour.edu.comm;

import java.io.IOException;

/**
 * @author SIMON
 * @since 2021. 11. 24.
 */

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessLogFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);//this.getClass()와 동일하다.

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("(❁´◡`❁)(❁´◡`❁)(❁´◡`❁)(❁´◡`❁)Filter 시작");
	}
	
	@Override
	/**
	 * 요청의 객체인 servletRequest와 ServletResponse의 정보에서 필요한 Header와 정보를 추출 및 출력. <br>
	 * 반드시 흐름제어를 위해서는 흐름제어 코드 (RequesDispatcher / SendRedirect)를 작성해 주거나 <br>
	 * 일반 흐름을 만들기 위해 chain.doFilter 메소드를 반드시 구현해야 한다.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String chk = req.getParameter("check");
		boolean flag = Boolean.parseBoolean(chk);
		//System.out.println("필터에서 값을 확인해 봄 : " + chk);
		
		/*if(flag) {
			chain.doFilter(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}*/
		
		//현재 서버에 요청하는 Client의 IP주소를 가져온다
		String remoteAddr = StringUtils.defaultString(req.getRemoteAddr(),"-");
		
		//Client가 요청한 호출 주소
		String uri = StringUtils.defaultIfEmpty(req.getRequestURI(), "");
		
		//Client 요청된 주소에서 전달하는 parameter
		String queryString = StringUtils.defaultIfBlank(req.getQueryString(), "");
		
		//Header 정보를 출력
		String referer = StringUtils.defaultString(req.getHeader("referer"),"");
		
		//접속한 사용자의 플랫폼 정보를 출력
		String userAgent = StringUtils.defaultString(req.getHeader("User-Agent"),"-");
		
		String fullUrl = uri+(StringUtils.isNotEmpty(queryString)? "?"+queryString : queryString);
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":").append(fullUrl).append(":").append(referer).append(":").append(userAgent);
		
		logger.info("Logger Filter {}", sb.toString());
		
		chain.doFilter(request, response);
		
		//System.out.println(remoteAddr);
		//System.out.println(uri);
		//System.out.println(queryString);
		//System.out.println("refer" + referer);
		//System.out.println("User-Agent" + userAgent);
	}

	@Override
	public void destroy() {
		System.out.println("╰(*°▽°*)╯╰(*°▽°*)╯╰(*°▽°*)╯Filter 종료");
	}

}
