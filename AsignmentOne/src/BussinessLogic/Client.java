/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

import java.util.ArrayList;

import DataSource.ClientFinder;
import DataSource.ClientGateway;

public class Client {

  	 
    private ClientGateway data;
    
	public Client(ClientGateway a) {
		super();
		data = a;
		
	}
	public Client (){
		super();
		data = new ClientGateway();
	}
	
	public int getCid() {
            return data.getCid();
        }
    
        public String getName() {
            return data.getName();
        }

        public String getBi() {
            return data.getBi();
        }

        public int getCnp() {
            return data.getCnp();
        }

        public String getAdresa() {
            return data.getAdresa();
        }

	public void insert(int cid, String name,String BI,int  CNP, String adresa){
		data.insert(cid, name, BI, CNP, adresa);
	}
	
    @Override
	public String toString(){
		return data.toString();
	}
        
        public static String viewAll(){
                String all = new String("");
		ArrayList<ClientGateway> aux = new ArrayList<ClientGateway>();
		aux = ClientFinder.findAll();
		for(int i = 0;i<aux.size();i++)
                {   
                   // if(aid == aux.get(i).getCid())
                    all = all + aux.get(i).toString() + "\n";
                }
		return all;
	}
	public void update(int cid, String name,String BI,int  CNP, String adresa){
		data.update(cid, name, BI, CNP, adresa);
	}
	
	
	public static Client findById(int id){
		return new Client(ClientFinder.findByID(id));
	}
	
	public static  ArrayList<Client> findAll(){
		ArrayList<Client> ret = new ArrayList<Client>();
		ArrayList<ClientGateway> aux = new ArrayList<ClientGateway>();
		aux = ClientFinder.findAll();
		for(int i = 0;i<aux.size();i++)
                {
			ret.add(new Client(aux.get(i)));
                }
		
		return ret;
	}
	
	/*public static  ArrayList<Client> search(String name, String CNP, String address, Long id){
		ArrayList<Client> ret = new ArrayList<Client>();
		ArrayList<ClientGateway> aux = new ArrayList<ClientGateway>();
		aux = ClientFinder.search(name,CNP,address,id);
		for(int i = 0;i<aux.size();i++)
			ret.add(new Client(aux.get(i)));
		
		return ret;
	}
	*/
	

}
