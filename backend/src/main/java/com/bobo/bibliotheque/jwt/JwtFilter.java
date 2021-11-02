package com.bobo.bibliotheque.jwt;

import com.bobo.bibliotheque.configuration.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailService service;

    @Autowired
    private JwtUtils jwtutils;


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        Cookie[] cookies = request.getCookies();

        // Normal security process for specific URLs
        if (getAuthorizedUrls(requestURI) || cookies == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Check cookie
        String jwtToken = getJwtTokenFromCookie(cookies);
        if (jwtToken == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Check token is valid, and not expired
        String username;
        try {
            username = jwtutils.getUsernameFromToken(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            filterChain.doFilter(request, response);
            return;
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails;
            try {
                userDetails = service.loadUserByUsername(username);
            } catch (Exception e) {
                e.printStackTrace();
                filterChain.doFilter(request, response);
                return;
            }

            if (jwtutils.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(userDetails);
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean getAuthorizedUrls(String requestURI) {
        return requestURI.equals("/users");
    }

    private String getJwtTokenFromCookie(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
