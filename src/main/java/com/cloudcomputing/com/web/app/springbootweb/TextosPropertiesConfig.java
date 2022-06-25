package com.cloudcomputing.com.web.app.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {

}
