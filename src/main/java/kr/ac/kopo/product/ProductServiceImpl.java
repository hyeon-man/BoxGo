package kr.ac.kopo.product;

import kr.ac.kopo.Vo.Product;
import kr.ac.kopo.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    final ProductDao dao;

    public ProductServiceImpl(ProductDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> list(Pager pager) {
        pager.setTotal(dao.total(pager));

        return dao.list(pager);
    }

    @Override
    public void add(Product product) {
        dao.add(product);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public Product item(int id) {
        return dao.item(id);
    }

    @Override
    public void update(Product product) {
        dao.update(product);
    }

    @Override
    public List<Product> category() {
        return dao.category();
    }
}
