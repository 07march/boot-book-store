package by.bookstoreboot.bookstoreboot.interceptor;

import by.bookstoreboot.bookstoreboot.controller.exception.InvalidUUIDUserApiKey;
import by.bookstoreboot.bookstoreboot.entity.Key;
import by.bookstoreboot.bookstoreboot.service.KeyService;
import by.bookstoreboot.bookstoreboot.service.UserServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private final KeyService keyService;

    public ApiKeyInterceptor(KeyService keyService) {
        this.keyService = keyService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader("token");
        if (apiKey == null || apiKey.isEmpty()) throw new InvalidUUIDUserApiKey("Empty api key");
        if (keyService.findKeyByUuid(UUID.fromString(apiKey)) != null) {
            return true;
        }
        throw new InvalidUUIDUserApiKey("Api key " + apiKey + " not found!");
    }
}
