package be.fooda.backend.converter.config;

import be.fooda.backend.converter.utils.CsvConverter;
import be.fooda.backend.converter.utils.YamlConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class WebConfig {

    @Bean
    public CsvConverter getCsvConverterBean() {
        return new CsvConverter();
    }

    @Bean
    public YamlConverter getYamlConverterBean() {
        return new YamlConverter();
    }

    @Bean
    public MappingJackson2HttpMessageConverter getJsonConverterBean() {
        return new MappingJackson2HttpMessageConverter();
    }
}
