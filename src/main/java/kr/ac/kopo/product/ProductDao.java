package kr.ac.kopo.product;

import kr.ac.kopo.Vo.Product;
import kr.ac.kopo.util.Pager;

import java.util.List;

public interface ProductDao {
    List<Product> list(Pager pager);

    void add(Product product);

    void delete(int id);

    Product item(int id);

    void update(Product product);

    int total(Pager pager);

    List<Product> category();
}
