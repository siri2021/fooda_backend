package it.vkod.woo.collector.service.services;

import it.vkod.woo.collector.service.models.Product;
import it.vkod.woo.collector.service.exceptions.ResourceNotFoundException;
import it.vkod.woo.collector.service.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteAllByStoreId(@Min(value = 1L, message = "Invalid store ID.") long storeId) {
        Iterable<Product> allProductsByStoreId = productRepository.findAllByStoreId(storeId);
        allProductsByStoreId.forEach(product -> productRepository.delete(product));
    }

    @Override
    public boolean exists(Product product) {
        return productRepository.existsByNameAndStoreId(product.getName(), product.getStoreId());
    }

}