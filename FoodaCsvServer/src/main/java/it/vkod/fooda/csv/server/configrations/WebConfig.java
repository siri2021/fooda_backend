package it.vkod.fooda.csv.server.configrations;

import it.vkod.fooda.csv.server.utils.CsvConverter;
import it.vkod.fooda.csv.server.utils.YamlConverter;
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
