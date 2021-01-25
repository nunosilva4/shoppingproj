package ns.simpleprojs.shopping.controller;

import ns.simpleprojs.shopping.dao.ProductDao;
import ns.simpleprojs.shopping.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}