package stitchr.stitcher2mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import stitchr.stitcher2mvc.Controllers.AbstractController;
import stitchr.stitcher2mvc.models.User;
import stitchr.stitcher2mvc.models.data.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        // All publicly available pages here
        List<String> authPages = Arrays.asList("index", "stitchr/user/login", "stitchr/user/register");

        // These pages require sign-in
        if (authPages.contains(request.getRequestURI())) {

            boolean isLoggedIn = false;
            User user;
            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                user = userDao.findByUid(userId);

                if (user != null) {
                    isLoggedIn = true;

                }
            }

            if (!isLoggedIn) {
                response.sendRedirect("login");
                return false;
            }
        }

            return true;
    }


}
