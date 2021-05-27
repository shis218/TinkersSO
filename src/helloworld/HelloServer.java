package helloworld;
import java.rmi.*;

import java.rmi.server.*;

import java.rmi.registry.*;

import java.util.ArrayList;
public class HelloServer implements helloworld {
int count=0;
	public static void main(String[] args) {
		try {

	         // Instancia o objeto servidor e a sua stub  

	         HelloServer server = new HelloServer();

	         helloworld stub = (helloworld) UnicastRemoteObject.exportObject(server, 0);

	         // Registra a stub no RMI Registry para que ela seja obtida pelos clientes

	         Registry registry = LocateRegistry.getRegistry();
	         String[] a=registry.list();
	       for(int i=0;i<a.length;i++) {
	    	   if(a[i].contains("Hello")) {
	    		   registry.unbind("Hello");
	    	   }
	       }
	         
	         registry.bind("Hello", stub);
	         

	         System.out.println("Servidor pronto");

	      } catch (Exception ex) {

	         ex.printStackTrace();

	      } 

	}

	@Override
	public String hello() throws RemoteException {
		 System.out.println("Executando hello()");
		 count++;
		   return "Hello!!! user number+"+this.count;
	}

}
