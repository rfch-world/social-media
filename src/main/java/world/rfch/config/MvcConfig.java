package world.rfch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //Burani Murad tamamlayacaq
        registry
                .addResourceHandler("/app/","/*","/app/*")
                .addResourceLocations("file:C:/social-media/social-media/src/main/resources/template/**","file:C:/Users/roma-cervice/social-media/src/main/resources/template/","file:C:/Users/roma-cervice/social-media/src/main/resources/static/template/**");
        registry
                .addResourceHandler("/static/**","/images/***","/fonts/**","/images/**","/images/*","/images/","/*")
                .addResourceLocations("file:C:/social-media/src/main/resources/static/**","file:C:/Users/roma-cervice/social-media/src/main/resources/static/","file:C:/Users/roma-cervice/social-media/src/main/resources/static/images/**");
    }
}
