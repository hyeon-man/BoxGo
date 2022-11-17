package kr.ac.kopo.Vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Detail {

    private int id;
    private int price;
    private int salePrice;

    public abstract String get (String key);

    

}
