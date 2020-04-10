package it.vkod.woo.csv.config;

import it.vkod.woo.csv.utils.CsvConverter;
import it.vkod.woo.csv.utils.YamlConverter;
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
