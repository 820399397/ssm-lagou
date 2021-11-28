package cn.xuguowen.pojo;

/**
 * @author 徐国文
 * @create 2021-10-19 14:47
 */
public class User {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    // 一定要记住编写set方法，因为mvc底层接收到的数据通过set方法封装到实体类中的属性上
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
