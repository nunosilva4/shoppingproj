package ns.simpleprojs.shopping.dao;

import ns.simpleprojs.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
}