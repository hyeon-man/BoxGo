package kr.ac.kopo.domain;

import kr.ac.kopo.Vo.Domain;
import kr.ac.kopo.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceImpl implements DomainService{
    final DomainDao dao;
    public DomainServiceImpl(DomainDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Domain> list(Pager pager) {
        pager.setTotal(dao.total(pager));

        return dao.list(pager);
    }

    @Override
    public void add(Domain domain) {
        dao.add(domain);
    }

    @Override
    public Domain item(int id) {
        return dao.item(id);
    }

    @Override
    public void update(Domain domain) {
        dao.update(domain);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
