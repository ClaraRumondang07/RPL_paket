/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.User;
import util.NewHibernateUtil;

/**
 *
 * @author willy
 */
public class userHelper {

    public userHelper() {
    }
    
    public User cariUser(String id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String query = "from User u where u.id=:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        List<User> list = q.list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public User login(String id, String password) {
        User user = this.cariUser(id);
        if (user != null) {
            //user ada 
            if (user.getPassword().equals(password)) {
                //password sama
                return user;
            } else {
                //password berbeda
                return null;
            }
        } else {
            //user tidak ada
            return null;
        }
    }
}
