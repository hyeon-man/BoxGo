package kr.ac.kopo.util;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pager {
    private int page = 1;
    private int perPage = 10;
    private float total;
    private int perGroup = 5;

    public int getOffset() {
        return (page - 1) * perPage;
    }

    private int search;
    private String keyword;

    private int lowPrice = 0;
    private int highPrice = 0;


    public String getQuery() {
        if (search < 1)
            return "";

        if (search == 4)
            return "&search=" + search + "&lowPrice=" + lowPrice + "&highPrice=" + highPrice;

        return "&search=" + search + "&keyword=" + keyword;
    }


    public int getLast() {
        return (int) Math.ceil(total / perPage);
    }

    public int getPrev() {
        return page <= perGroup ? 1 : (((page - 1) / perGroup) - 1) * perGroup + 1;
    }

    public int getNext() {
        int next = (((page - 1) / perGroup) + 1) * perGroup + 1;
        int last = getLast();

        return next < last ? next : last;
    }

    public List<Integer> getList() {
        List<Integer> list = new ArrayList<Integer>();

        int startPage = (((page - 1) / perGroup) + 0) * perGroup + 1;

        for (int i = startPage; i < (startPage + perGroup) && i <= getLast(); i++)
            list.add(i);

        if (list.isEmpty())
            list.add(1);

        return list;
    }

}





