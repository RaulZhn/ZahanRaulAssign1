package DataSource;
// Generated Apr 7, 2015 11:04:57 PM by Hibernate Tools 3.6.0

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * ClientGateway generated by hbm2java
 */
public class ClientGateway  implements java.io.Serializable {


     private int cid;
     private String name;
     private String bi;
     private int cnp;
     private String adresa;
    // private Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
     
    public ClientGateway() {
       super();
       this.cid = 0;
       this.name = "";
       this.bi = "";
       this.cnp = 0;
       this.adresa = "";
        
    }

    public ClientGateway(int cid, String name, String bi, int cnp, String adresa) {
       this.cid = cid;
       this.name = name;
       this.bi = bi;
       this.cnp = cnp;
       this.adresa = adresa;
    }
   
    public int getCid() {
        return this.cid;
    }
    
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getBi() {
        return this.bi;
    }
    
    public void setBi(String bi) {
        this.bi = bi;
    }
    public int getCnp() {
        return this.cnp;
    }
    
    public void setCnp(int cnp) {
        this.cnp = cnp;
    }
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
     @Override
    public String toString()
    {
        return  (cid + " | " + name + " | " + bi + " | " + cnp + " | " + adresa);
    }
	
    public boolean insert(int cid, String name,String BI,int  CNP, String adresa){
      Session s = NewHibernateUtil.getSessionFactory().openSession();
      boolean done = false;    
      Transaction tx = null;
      try{
         tx = s.beginTransaction();
         s.save(new ClientGateway(cid,name,BI,CNP,adresa));
         done = true;
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
         s.close(); 
      }
        return true;
    }
    public boolean update(int cid, String name,String BI,int  CNP, String adresa){
     Session s = NewHibernateUtil.getSessionFactory().openSession();
     boolean done = false;
     Transaction tx = null;
      try{
         tx = s.beginTransaction();
         s.update(new ClientGateway(cid,name,BI,CNP,adresa));
         done = true;
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
         s.close(); 
      }
        return done;
    }

    

}

