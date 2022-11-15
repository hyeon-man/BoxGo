package kr.ac.kopo.keywords;

import kr.ac.kopo.Vo.Keywords;
import kr.ac.kopo.util.KeywordsPager;
import kr.ac.kopo.util.Pager;

import java.util.List;

public interface KeywordsService {
    List<Keywords> list(KeywordsPager pager);

    void add(Keywords keywords);

    Keywords item(int id);

    void update(Keywords keywords);

    void delete(Keywords keywords);
}
