package kr.ac.kopo.keywords;

import kr.ac.kopo.Vo.Keywords;
import kr.ac.kopo.util.KeywordsPager;
import kr.ac.kopo.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordsServiceImpl implements KeywordsService {
    final KeywordsDao dao;
    public KeywordsServiceImpl(KeywordsDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Keywords> list(KeywordsPager pager) {
        pager.setTotal(dao.total(pager));

        return dao.list(pager);
    }

    @Override
    public void add(Keywords keywords) {
        dao.add(keywords);
    }

    @Override
    public Keywords item(int id) {
        return dao.item(id);
    }

    @Override
    public void update(Keywords keywords) {
        dao.update(keywords);
    }

    @Override
    public void delete(Keywords keywords) {
        dao.delete(keywords);
    }

    @Override
    public List<Keywords> list(int domainId) {
        KeywordsPager pager = new KeywordsPager();
        pager.setDomainId(domainId);
        pager.setPerGroup(0);


        return dao.list(pager);
    }
}
