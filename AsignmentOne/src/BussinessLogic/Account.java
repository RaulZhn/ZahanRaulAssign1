/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BussinessLogic;

import DataSource.AccountFinder;
import DataSource.AccountGateway;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Raul Zhn
 */
public class Account {
    
    private AccountGateway data;
    //private UserFinder finder;
    
    public Account(AccountGateway a) {
        super();
        data = a;
		
	}
    public Account(){
	super();
	data = new AccountGateway();
    }
   public int getAid() {
        return data.getAid();
    }
   
    public String getType() {
        return data.getType();
    }
    
    public int getAmount() {
        return data.getAmount();
    }
    
    public Date getCreationDate() {
        return data.getCreationDate();
    }
   
    public int getUid() {
        return data.getUid();
    }
  
    public int getCid() {
        return data.getCid();
    }
    
    public void insert(int aid, String type, int amount, Date creationDate, int uid, int cid){
	data.insert(aid, type, amount, creationDate, uid, cid);
    }
    
    public void update(int aid, String type, int amount, Date creationDate, int uid, int cid){
        data.update(aid, type, amount, creationDate, uid, cid);
    }
    
    public void delete(int uid){
         AccountGateway u = DataSource.AccountFinder.findByID(uid);
		data.delete(uid, u.getType(), u.getAmount(), u.getCreationDate(), u.getUid(), u.getCid());
    }
    
    @Override
    public String toString(){
        return data.toString();
    }
    public static String view(int id)
    {
        AccountGateway aux = AccountFinder.findByID(id);
        return aux.toString();
    }
    public static String viewAll(int uid){
        String all = new String("");
        ArrayList<AccountGateway> aux = new ArrayList<AccountGateway>();
	aux = AccountFinder.findAll();
	for(int i = 0;i<aux.size();i++)
        {
            if(uid == aux.get(i).getUid())
            all = all + aux.get(i).toString() + "\n";
        }
	return all;
    }	
	
   
}
