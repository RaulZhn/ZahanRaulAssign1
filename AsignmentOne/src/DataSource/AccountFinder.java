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
public class AccountFinder {
    
     public static AccountGateway findByID(int id)
    {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
      try{
         tx = s.beginTransaction();
         List accounts = s.createQuery("FROM AccountGateway").list(); 
         for (Iterator iterator = accounts.iterator(); iterator.hasNext();)
         {
            AccountGateway account; 
            account = (AccountGateway) iterator.next();
            if(account.getAid() == id) return account;
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
       s.close(); 
              }
       return null;
    }
    
    public static ArrayList<AccountGateway> findAll()
    {
         ArrayList<AccountGateway> acc = new ArrayList<AccountGateway>();
         Session s = NewHibernateUtil.getSessionFactory().openSession();
         Transaction tx = null;
      try{
         
         tx = s.beginTransaction();
         List accs = s.createQuery("FROM AccountGateway").list(); 
         
         for (Iterator iterator = accs.iterator(); iterator.hasNext();)
         {
            AccountGateway  ac = (AccountGateway) iterator.next();
            acc.add(ac);
            
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
      s.close(); 
              }
      return acc;
    }
    
}
