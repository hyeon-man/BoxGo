package kr.ac.kopo.domain;

import kr.ac.kopo.Vo.Domain;
import kr.ac.kopo.util.Pager;

import java.util.List;

public interface DomainDao {
    List<Domain> list(Pager pager);

    void delete(int id);

    void update(Domain domain);

    Domain item(int id);

    void add(Domain domain);

    int total(Pager pager);
}
