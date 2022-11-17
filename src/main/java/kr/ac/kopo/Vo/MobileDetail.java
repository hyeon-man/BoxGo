package kr.ac.kopo.Vo;

public class MobileDetail extends Detail {

    private String category;
    private String brand;
    private String size;
    private String color;

    @Override
    public String get(String key) {
        if ("category".equals(key)) {
            return category;
        } else if ("brand".equals(key)) {
            return brand;
        } else if ("size".equals(key)) {
            return size;
        } else if ("color".equals(key)) {
            return color;
        }
        return null;
    }
}
