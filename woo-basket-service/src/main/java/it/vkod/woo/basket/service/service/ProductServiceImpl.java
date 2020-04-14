package it.vkod.woo.basket.service.service;

import it.vkod.woo.basket.service.exception.ResourceNotFoundException;
import it.vkod.woo.basket.service.model.Product;
import it.vkod.woo.basket.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

//    public ProductServiceImpl(ProductRepository repo) {
//        this.repo = repo;
//    }

    @Override
    public Iterable<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        if (!existsByIdAndStoreId(product.getId(), product.getStoreId())) {
            return repo.save(product);
        } else {
            return null;
        }
    }

    @Override
    public boolean existsByIdAndStoreId(final long id, final long storeId) {
        return repo.existsByIdAndStoreId(id, storeId);
    }
}
