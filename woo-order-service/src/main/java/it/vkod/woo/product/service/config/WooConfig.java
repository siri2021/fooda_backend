package it.vkod.woo.product.service.config;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WooConfig {

    @Value("${store.url}")
    private String url;

    @Value("${store.ck}")
    private String ck;

    @Value("${store.cs}")
    private String cs;

    @Bean
    public WooCommerce getWooCommerceBean() {
        // Setup client
        OAuthConfig config = new OAuthConfig(url, ck, cs);
        return new WooCommerceAPI(config, ApiVersionType.V3);
    }
}
