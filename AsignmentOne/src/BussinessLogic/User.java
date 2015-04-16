/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BussinessLogic;

import java.util.ArrayList;

import DataSource.UserFinder;
import DataSource.UserGateway;

/**
 *
 * @author Raul Zhn
 */
public class User {
    
    private UserGateway data;
    //private UserFinder finder;
    
    public User(UserGateway a) {
        super();
        data = a;
		
	}
    public User(){
	super();
	data = new UserGateway();
    }
        
    public int getUid() {
        return data.getUid();
    }
    
    public String getUuser() {
        return data.getUuser();
    }
    
    public String getUpassword() {
        return data.getUpassword();
    }
    
    public String getUname() {
        return data.getUname();
    }
    
    public String getUaddres() {
        return data.getUaddres();
    }
    
    public int getUcnp() {
        return data.getUcnp();
    }
    
    public void insert(int uid, String uuser, String upassword, String uname, String uaddres, int ucnp){
	data.insert(uid, uuser, upassword, uname, uaddres, ucnp);
    }
    
    public void update(int uid, String uuser, String upassword, String uname, String uaddres, int ucnp){
		data.update(uid, uuser, upassword, uname, uaddres, ucnp);
    }
    
    public void delete(int uid){
               UserGateway u = DataSource.UserFinder.findByID(uid);
		data.delete(uid, u.getUuser(), u.getUpassword(), u.getUname(), u.getUaddres(), u.getUcnp());
    }
    
    @Override
    public String toString(){
        return data.toString();
    }
    public static String view(int id)
    {
        UserGateway aux = UserFinder.findByID(id);
        return aux.toString();
    }
    
    public static int verify(String user, String pass)
    {
        UserGateway aux = UserFinder.findByUser(user);
        if(aux.getUpassword().equals(pass)) return aux.getUid();
        else return 0;
    }
    
    public static String viewAll(){
        String all = new String("");
        ArrayList<UserGateway> aux = new ArrayList<UserGateway>();
	aux = UserFinder.findAll();
	for(int i = 0;i<aux.size();i++)
        {
            all = all + aux.get(i).toString() + "\n";
        }
	return all;
    }	
	
	
    
}
