package ns.simpleprojs.shopping.service;

import ns.simpleprojs.shopping.dao.ProductDao;
import ns.simpleprojs.shopping.exception.ProductNotFoundException;
import ns.simpleprojs.shopping.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional(readOnly = true)
    public List<Product> getProducts() {
        return productDao.findAll();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Product> getProductById(Long id) {
        return new ResponseEntity<>(productDao.findById(id).orElseThrow(ProductNotFoundException::new), HttpStatus.OK);
    }

    @Transactional
    public Product createProduct(@RequestBody String productName) {
        Product product = new Product();
        product.setName(productName);
        return productDao.save(product);
    }

}
