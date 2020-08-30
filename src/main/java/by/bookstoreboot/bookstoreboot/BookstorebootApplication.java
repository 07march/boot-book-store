package by.bookstoreboot.bookstoreboot;

import by.bookstoreboot.bookstoreboot.interceptor.AccessInterceptor;
import by.bookstoreboot.bookstoreboot.interceptor.ApiKeyInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
@EnableWebMvc
public class BookstorebootApplication implements WebMvcConfigurer {

    private final ApiKeyInterceptor apiKeyInterceptor;
    private final AccessInterceptor accessInterceptor;

    public BookstorebootApplication(ApiKeyInterceptor apiKeyInterceptor, AccessInterceptor accessInterceptor) {
        this.apiKeyInterceptor = apiKeyInterceptor;
        this.accessInterceptor = accessInterceptor;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookstorebootApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiKeyInterceptor).addPathPatterns("/**").excludePathPatterns("/user", "/user/auth", "/order");
        registry.addInterceptor(accessInterceptor).addPathPatterns(
                "/user/get/*",
                "/address", "/address/**",
                "/author","/author/delete", "/author/delete/id", "/author/update",
                "/city", "/city/delete", "/city/delete/id", "/city/update",
                "/book", "/book/update/*",
                "/store", "/store/delete", "/store/delete/id", "/store/update/*",
                "/order/find/*", "/order/update/*").excludePathPatterns("/user/auth");
    }

}
