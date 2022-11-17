package kr.ac.kopo.Vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String barcode;
    private Detail detail;
}
