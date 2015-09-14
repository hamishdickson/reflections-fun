package reflectionsFun.com.github.hamishdickson;

import java.util.List;

public class TestBean {
    private String string1;
    private boolean aBoolean;
    private int anInt;
    private List<Integer> integerList;

    public TestBean() {
    }

    public TestBean(String string1, boolean aBoolean, int anInt, List<Integer> integerList) {
        this.string1 = string1;
        this.aBoolean = aBoolean;
        this.anInt = anInt;
        this.integerList = integerList;
    }

    public String getString1() {
        return string1;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public int getAnInt() {
        return anInt;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }
}
