package stitchr.stitcher2mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import stitchr.stitcher2mvc.Controllers.AuthenticationController;


@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {

        return new AuthenticationInterceptor();
    }

    @Bean
    public AuthenticationController authenticationController() {

        return new AuthenticationController();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( authenticationInterceptor() );
    }
}
