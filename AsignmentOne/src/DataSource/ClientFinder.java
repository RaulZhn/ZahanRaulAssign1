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
public class ClientFinder {

  //  private  static Session s = NewHibernateUtil.getSessionFactory().openSession();

    public static ClientGateway findByID(int id)
    {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
      try{
         tx = s.beginTransaction();
         List clients = s.createQuery("FROM ClientGateway").list(); 
         System.out.println("ceva");
         for (Iterator iterator = clients.iterator(); iterator.hasNext();)
         {
            ClientGateway client; 
            client = (ClientGateway) iterator.next();
            if(client.getCid() == id) return client;
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
       s.close(); 
              }
       return null;
    }
    
    public static ArrayList<ClientGateway> findAll()
    {
         ArrayList<ClientGateway> clnts = new ArrayList<ClientGateway>();
         Session s = NewHibernateUtil.getSessionFactory().openSession();
         Transaction tx = null;
      try{
         
         tx = s.beginTransaction();
         List clients = s.createQuery("FROM ClientGateway").list(); 
         
         for (Iterator iterator = clients.iterator(); iterator.hasNext();)
         {
            ClientGateway  client = (ClientGateway) iterator.next();
            clnts.add(client);
            
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
      s.close(); 
              }
      return clnts;
    }

}
