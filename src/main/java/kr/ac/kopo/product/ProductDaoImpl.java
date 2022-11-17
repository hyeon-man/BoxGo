package kr.ac.kopo.product;

import kr.ac.kopo.Vo.Product;
import kr.ac.kopo.util.Pager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    final SqlSession sql;

    public ProductDaoImpl(SqlSession sql) {
        this.sql = sql;
    }

    @Override
    public List<Product> list(Pager pager) {
        return sql.selectList("product.list", pager);
    }

    @Override
    public void add(Product product) {
        sql.insert("product.insert", product);
    }

    @Override
    public void delete(int id) {
        sql.delete("product.delete", id);
    }

    @Override
    public Product item(int id) {
        return sql.selectOne("product.item", id);
    }

    @Override
    public void update(Product product) {
        sql.update("product.update", product);
    }

    @Override
    public int total(Pager pager) {
        return sql.selectOne("product.total", pager);
    }

    @Override
    public List<Product> category() {
        return sql.selectList("product.category");
    }
}
