package it.vkod.fooda.csv.server.controllers;

import it.vkod.fooda.csv.server.models.Product;
import it.vkod.fooda.csv.server.definitions.ConvertableMediaTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/convert")
public class ProductController {

    @PostMapping(value = "/csv2json", consumes = ConvertableMediaTypes.TEXT_CSV_VALUE, produces = ConvertableMediaTypes.APPLICATION_JSON_VALUE)
    public List<Product> csv2json(@RequestBody Product.Data products) {
        return products.getList();
    }

    @PostMapping(value = "/json2csv", consumes = ConvertableMediaTypes.APPLICATION_JSON_VALUE, produces = ConvertableMediaTypes.TEXT_CSV_VALUE)
    public Product.Data json2csv(@RequestBody List<Product> products) {
        Product.Data data = new Product.Data();
        data.setList(products);
        return data;
    }

    @PostMapping(value = "/yaml2json", consumes = ConvertableMediaTypes.TEXT_YAML_VALUE, produces = ConvertableMediaTypes.APPLICATION_JSON_VALUE)
    public List<Product> yaml2json(@RequestBody Product.Data products) {
        return products.getList();
    }

    @PostMapping(value = "/json2yaml", consumes = ConvertableMediaTypes.APPLICATION_JSON_VALUE, produces = ConvertableMediaTypes.TEXT_YAML_VALUE)
    public Product.Data json2yaml(@RequestBody List<Product> products) {
        Product.Data data = new Product.Data();
        data.setList(products);
        return data;
    }

    @PostMapping(value = "/xml2json", consumes = ConvertableMediaTypes.APPLICATION_XML_VALUE, produces = ConvertableMediaTypes.APPLICATION_JSON_VALUE)
    public List<Product> xml2json(@RequestBody List<Product> products) {
        return products;
    }

    @PostMapping(value = "/json2xml", consumes = ConvertableMediaTypes.APPLICATION_JSON_VALUE, produces = ConvertableMediaTypes.APPLICATION_XML_VALUE)
    public List<Product> json2xml(@RequestBody List<Product> products) {
        return products;
    }
}