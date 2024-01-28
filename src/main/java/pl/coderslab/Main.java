package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDAO;

public class Main {
    public static void main(String[] args) {
        boolean checkPassword;

        UserDAO dao = new UserDAO();

        User user1 = new User("Jan Kowalski", "jkowalski@gmail.com", "jkpass");
        user1 = dao.create(user1);
        // Expected result: Jan Kowalski in database, id updated in user1, password hashed in user1

        User user2 = new User("Jerzy Nowak", "jnowak@gmail.com", "jnpass");
        user2 = dao.create(user2);
        // Expected result: Jerzy Nowak in database, id updated in user2, password hashed in user2

        User user3 = new User("Anna Jankowska", "ajankowska@gmail.com", "jjpass");
        user3 = dao.create(user3);
        // Expected result: Anna Jankowska in database, id updated in user3, password hashed in user3

        user2.setEmail("jerzy.nowak@gmail.com");
        dao.update(user2);
        // Expected result: email updated in database for Jerzy Nowak

        User user4 = dao.read(user3.getId());
        // Expected result: data of Anna Jankowska in user4

        dao.delete(user3.getId());
        // Expected result: Anna Jankowska deleted from database

        User[] users = dao.findAllUsers();
        // Expected result: Jan Kowalski and Jerzy Nowak (with new email) in users array

        checkPassword = dao.checkPassword(2, "bledne haslo");
        // Expected result: false
        checkPassword = dao.checkPassword(2, "jnpass");
        // Expected result: true
        dao.updatePassword(2, "jnpass2");
        checkPassword = dao.checkPassword(2, "jnpass");
        // Expected result: false
        checkPassword = dao.checkPassword(2, "jnpass2");
        // Expected result: true

        dao.delete(user1.getId());
        dao.delete(user2.getId());
        // Expected result: users table empty
    }
}
