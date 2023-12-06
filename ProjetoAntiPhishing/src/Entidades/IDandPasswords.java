package Entidades;

import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public IDandPasswords(){
		
		logininfo.put("Levi Gonçalves","pizza");
		logininfo.put("teste","teste");
		logininfo.put("Bro","pizza");
		logininfo.put("a","a");
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}
