package ns.simpleprojs.shopping.controller;

import ns.simpleprojs.shopping.dao.ProductDao;
import ns.simpleprojs.shopping.exception.ProductNotFoundException;
import ns.simpleprojs.shopping.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping({"/", ""})
    public List<Product> getProducts() {
        return productDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productDao.findById(id).orElseThrow(ProductNotFoundException::new), HttpStatus.OK);
    }

    @PostMapping
    public Product createProduct(@RequestBody String productName) {
        Product product = new Product();
        product.setName(productName);
        return productDao.save(product);
    }
}