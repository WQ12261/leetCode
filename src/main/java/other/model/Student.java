package other.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 1226134406@qq.com
 * @className Student
 * @description
 * @time 2020/12/23 16:32
 */
public class Student {
    String name;
    Integer age;
    BigDecimal fortune;
    Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getFortune() {
        return fortune;
    }

    public void setFortune(BigDecimal fortune) {
        this.fortune = fortune;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
