package dao;

import model.Login;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;

    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAccount("tan");
        u1.setAge(20);
        u1.setEmail("tan@gmail.com");
        u1.setName("Trần Ngọc Tân");
        u1.setPassword("12345");
        users.add(u1);

        User u2 = new User();
        u2.setAccount("linh");
        u2.setAge(20);
        u2.setEmail("linh@gmail.com");
        u2.setName("Nguyễn Mỹ Linh");
        u2.setPassword("123");
        users.add(u2);

        User u3 = new User();
        u3.setAccount("nam");
        u3.setAge(20);
        u3.setEmail("nam@gmail.com");
        u3.setName("Nguyễn Nam");
        u3.setPassword("123");
        users.add(u3);
    }

    public static User checkLogin(Login login) {
        for (User u : users) {
            if (u.getAccount().equals(login.getAccount()) && u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }
}
