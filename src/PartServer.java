
import java.io.Serializable;
import java.rmi.*;

import java.rmi.server.*;

import java.rmi.registry.*;

import java.util.ArrayList;

import minimoentregavel.parts;
public class PartServer implements Remote, InterfacePartServer, Serializable {
int count=0;
private String nome; //Nome desse server no registry
ArrayList<Parts> vecParts=new ArrayList<Parts>();

public String getNome() {
	return this.nome;
}


public static void main(String[] args) throws AccessException, RemoteException, NotBoundException, AlreadyBoundException {
	 Registry registry = LocateRegistry.getRegistry();
	 InterfaceMundo mundo= (InterfaceMundo) registry.lookup("Mundo");
	 
	 
	 PartServer partserv=new PartServer(args[0], args[1],registry);
	 InterfacePartServer partServ=(InterfacePartServer) UnicastRemoteObject.exportObject(partserv, 0);
	 registry.rebind(args[0], partServ);
	 mundo.adicionaPartServer(args[0], args[1]);
	 
}


public  PartServer(String nome,String function,Registry registry) throws AccessException, RemoteException, NotBoundException, AlreadyBoundException {	
	super();
	this.nome=nome;
	InterfaceMundo mundo= (InterfaceMundo) registry.lookup("Mundo");
	InterfacePartServer partServ=(InterfacePartServer) UnicastRemoteObject.exportObject(this, 0);
	registry.rebind(nome.toLowerCase(), partServ);
	mundo.adicionaPartServer(nome, function);
}
	@Override
	public void AdicionaRecipe(){
		
	}

	
}
