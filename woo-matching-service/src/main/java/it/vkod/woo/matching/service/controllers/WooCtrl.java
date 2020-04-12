package it.vkod.woo.matching.service.controllers;

import com.netflix.discovery.shared.Applications;
import it.vkod.woo.matching.service.models.WooStore;
import it.vkod.woo.matching.service.models.pojo.WooProduct;
import it.vkod.woo.matching.service.services.WooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.Cacheable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/match/")
public class WooCtrl {

    @Autowired
    private WooService wooService;

    @GetMapping("urls")
    public List<String> apiGetProductServiceUrls() {
        return wooService.apiGetProductServiceUrls();
    }

    @Cacheable("/match")
    @GetMapping("{keyword}")
    public List<WooProduct> apiMatch(@PathVariable("keyword") final String keyword) {
        List<WooProduct> wooProducts = new ArrayList<>();
        final List<String> activeProductServices = apiGetProductServiceUrls();
        activeProductServices.forEach(url -> {
            final String urlFinal = url + "wc/search/" + keyword;
            final WooProduct[] matchedProducts = wooService.apiSearch(urlFinal);
            wooProducts.addAll(Arrays.asList(matchedProducts));
        });
        return wooProducts;
    }


//    @Cacheable("/match")
//    @GetMapping("{keyword}")
//    public WooStore[] apiMatch(@PathVariable("keyword") final String keyword) {
//        final WooStore[] wooStoreCollection = wooService.apiGetActiveStores();
//        Arrays.stream(wooStoreCollection).forEach(store -> {
//            final String url = "http://localhost:" + store.getPort() + "/wc/search/" + keyword;
//            final WooProduct[] matchedProducts = wooService.apiSearch(url);
//            store.setMatchedProducts(matchedProducts);
//        });
//        return wooStoreCollection;
//    }

//    @Cacheable(value = "/all")
//    @GetMapping("")
//    public WooStore[] apiGetAll() {
//        final WooStore[] wooStoreCollection = wooService.apiGetActiveStores();
//        Arrays.stream(wooStoreCollection).forEach(store -> {
//            final String url = "http://localhost:" + store.getPort() + "/wc/page/1";
//            final WooProduct[] allProductByPage = wooService.apiSearch(url);
//            store.setMatchedProducts(allProductByPage);
//        });
//        return wooStoreCollection;
//    }

}
