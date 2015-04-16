/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Raul Zhn
 */
public class UserFinder {
    
   // private  static Session s = NewHibernateUtil.getSessionFactory().openSession();

    public static UserGateway findByID(int id)
    {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
      try{
         tx = s.beginTransaction();
         List clients = s.createQuery("FROM UserGateway").list(); 
         for (Iterator iterator = clients.iterator(); iterator.hasNext();)
         {
            UserGateway user; 
            user = (UserGateway) iterator.next();
            if(user.getUid() == id) return user;
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
       s.close(); 
              }
       return null;
    }
    
    public static UserGateway findByUser(String name)
    {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
      try{
         tx = s.beginTransaction();
         List clients = s.createQuery("FROM UserGateway").list(); 
         for (Iterator iterator = clients.iterator(); iterator.hasNext();)
         {
            UserGateway user; 
            user = (UserGateway) iterator.next();
            if(user.getUuser().equals(name)) return user;
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
       s.close(); 
              }
       return null;
    }
    
    public static ArrayList<UserGateway> findAll()
    {
         ArrayList<UserGateway> usr = new ArrayList<UserGateway>();
         Session s = NewHibernateUtil.getSessionFactory().openSession();
         Transaction tx = null;
      try{
         
         tx = s.beginTransaction();
         List users = s.createQuery("FROM UserGateway").list(); 
         
         for (Iterator iterator = users.iterator(); iterator.hasNext();)
         {
            UserGateway  user = (UserGateway) iterator.next();
            usr.add(user);
            
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
      s.close(); 
              }
      return usr;
    }
}
