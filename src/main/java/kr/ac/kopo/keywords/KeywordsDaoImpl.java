package kr.ac.kopo.keywords;

import kr.ac.kopo.Vo.Keywords;
import kr.ac.kopo.util.KeywordsPager;
import kr.ac.kopo.util.Pager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class KeywordsDaoImpl implements KeywordsDao {
    final SqlSession sql;

    public KeywordsDaoImpl(SqlSession sql) {
        this.sql = sql;
    }

    @Override
    public List<Keywords> list(KeywordsPager pager) {

        return sql.selectList("keywords.list", pager);
    }

    @Override
    public int total(Pager pager) {

        return sql.selectOne("keywords.total", pager);
    }

    @Override
    public void add(Keywords keywords) {
        sql.insert("keywords.add", keywords);
    }

    @Override
    public Keywords item(int id) {
        return sql.selectOne("keywords.item", id);
    }

    @Override
    public void update(Keywords keywords) {
        sql.update("keywords.update", keywords);
    }

    @Override
    public void delete(Keywords keywords) {
        sql.delete("keywords.delete", keywords);
    }
}
