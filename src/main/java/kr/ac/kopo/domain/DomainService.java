package kr.ac.kopo.domain;

import kr.ac.kopo.Vo.Domain;
import kr.ac.kopo.util.Pager;

import java.util.List;

public interface DomainService {
    List<Domain> list(Pager pager);

    void add(Domain domain);

    Domain item(int id);

    void update(Domain domain);

    void delete(int id);
}
