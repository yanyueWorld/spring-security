package com.study.demo.filter;


import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomFilter.
 *
 * @author yanyue, 2019/7/5
 * @version spring-security v1.0
 */
public class CustomFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * CustomFilter 构造器.
     *
     * @param defaultFilterProcessesUrl
     */
    public CustomFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, HttpMethod.POST.name()));
    }

    /**
     * attemptAuthentication.
     * 将用户信息检验后的结果封装成一个token，并且返回该token.
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return Authencation
     * @throws AuthenticationException,
     * @throws IOException,
     * @throws ServletException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        customCheck(username, password);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, authorities);
        return token;
    }

    /**
     * customCheck 检查用户名和密码
     *
     * @param username
     * @param password
     * @throws RuntimeException
     */
    private void customCheck(String username, String password) {
        if (!("admin".equals(username) && "admin".equals(password))) {
            throw new RuntimeException("用户名和密码错误!");
        }
    }
}
