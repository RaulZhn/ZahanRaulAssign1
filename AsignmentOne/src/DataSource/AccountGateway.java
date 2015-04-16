package DataSource;
// Generated Apr 7, 2015 11:04:57 PM by Hibernate Tools 3.6.0


import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * AccountGateway generated by hbm2java
 */
public class AccountGateway  implements java.io.Serializable {


     private int aid;
     private String type;
     private int amount;
     private Date creationDate;
     private int uid;
     private int cid;

    public AccountGateway() {
    }

    public AccountGateway(int aid, String type, int amount, Date creationDate, int uid, int cid) {
       this.aid = aid;
       this.type = type;
       this.amount = amount;
       this.creationDate = creationDate;
       this.uid = uid;
       this.cid = cid;
    }
   
    public int getAid() {
        return this.aid;
    }
    
    public void setAid(int aid) {
        this.aid = aid;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public int getAmount() {
        return this.amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public int getUid() {
        return this.uid;
    }
    
    public void setUid(int uid) {
        this.uid = uid;
    }
    public int getCid() {
        return this.cid;
    }
    
    public void setCid(int cid) {
        this.cid = cid;
    }

     @Override
    public String toString()
    {
        return  (aid + " | " +  type + " | " + amount + " | " + creationDate + " | " + uid + " | " + cid);
    }
    
     public boolean insert(int aid, String type, int amount, Date creationDate, int uid, int cid){
     
      Session s = NewHibernateUtil.getSessionFactory().openSession();
      boolean done = false;    
      Transaction tx = null;
      try{
         tx = s.beginTransaction();
         s.save(new AccountGateway(aid, type, amount, creationDate, uid, cid));
         done = true;
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
         s.close(); 
      }
        return true;
    }
    public boolean update(int aid, String type, int amount, Date creationDate, int uid, int cid){
    
     boolean done = false;
     Transaction tx = null;
     Session s = NewHibernateUtil.getSessionFactory().openSession();
      try{
         tx = s.beginTransaction();
         s.update(new AccountGateway(aid, type, amount, creationDate, uid, cid));
         done = true;
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
      }finally {
         s.close(); 
      }
        return done;
    }
    
     public boolean delete(int aid, String type, int amount, Date creationDate, int uid, int cid){
    
     boolean done = false;
     Session s = NewHibernateUtil.getSessionFactory().openSession();
     Transaction tx = null;
      try{
         tx = s.beginTransaction();
         s.delete(new AccountGateway(aid, type, amount, creationDate, uid, cid));
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

