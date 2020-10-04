package tree.util;

/**
 * @author 1226134406@qq.com
 * @description
 * @create 2020/10/4 17:17
 */
public enum ClueStatue {


    CENTER_CLUE("中序序列化"),

    PRE_CLUE("前序序列化"),
    NO_CLUE("还没有序列化"),

    LAST_CLUE("后序序列化");

    private final String statue;



    private ClueStatue(String str) {
        this.statue=str;
    }

    public String getDesc() {
        return statue;
    }

    @Override
    public String toString() {
        return "ClueStatue{" +
                "statue='" + statue + '\'' +
                '}';
    }
}
