package kr.ac.kopo.domain;

import kr.ac.kopo.Vo.Domain;
import kr.ac.kopo.util.Pager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DomainDaoImpl implements DomainDao{
    final SqlSession sql;
    public DomainDaoImpl(SqlSession sql) {
        this.sql = sql;
    }

    @Override
    public List<Domain> list(Pager pager) {
        System.out.println(pager.getKeyword());
        System.out.println(pager.getSearch());
        System.out.println("여기에요");
        return sql.selectList("domain.list", pager);
    }

    @Override
    public void delete(int id) {
        sql.delete("domain.delete", id);
    }

    @Override
    public void update(Domain domain) {
        sql.update("domain.update",domain);
    }

    @Override
    public Domain item(int id) {
        return sql.selectOne("domain.item", id);
    }

    @Override
    public void add(Domain domain) {
        sql.insert("domain.add",domain);
    }

    @Override
    public int total(Pager pager) {
        return sql.selectOne("domain.total", pager);
    }
}
