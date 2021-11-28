package cn.xuguowen.pojo;

import java.util.List;
import java.util.Map;

/**
 * @author 徐国文
 * @create 2021-10-19 17:03
 */
public class QueryVo {
    private String keyWords;

    private User user;
    private List<User> userList;
    private Map<String,User> userMap;

    @Override
    public String toString() {
        return "QueryVo{" +
                "keyWords='" + keyWords + '\'' +
                ", user=" + user +
                ", userList=" + userList +
                ", userMap=" + userMap +
                '}';
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public User getUser() {
        return user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
}
