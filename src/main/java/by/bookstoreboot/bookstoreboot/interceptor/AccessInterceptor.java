package by.bookstoreboot.bookstoreboot.interceptor;

import by.bookstoreboot.bookstoreboot.controller.exception.AccessException;
import by.bookstoreboot.bookstoreboot.controller.exception.InvalidUUIDUserApiKey;
import by.bookstoreboot.bookstoreboot.entity.Key;
import by.bookstoreboot.bookstoreboot.entity.Role;
import by.bookstoreboot.bookstoreboot.service.KeyService;
import by.bookstoreboot.bookstoreboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class AccessInterceptor implements HandlerInterceptor {

    @Autowired
    private KeyService keyService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader("token");
        if (apiKey == null || apiKey.isEmpty()) throw new InvalidUUIDUserApiKey("empty api key");
        if (keyService.findKeyByRole(Role.ADMIN) != null){
            return true;
        }
        throw new AccessException("Access denied");
    }
}
