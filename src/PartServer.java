
import java.rmi.*;

import java.rmi.server.*;

import java.rmi.registry.*;

import java.util.ArrayList;

import minimoentregavel.parts;
public class PartServer implements Remote, InterfacePartServer {
int count=0;
private int ingameID; //Codigo fixo definido pelo protocolo,desta forma peças do mesmo tipo tem o mesmo ID. É definida no construtor e pode apenas ser consultada

private ListaDeMateriais materialTrait; //De qual material é primariamente feito essa parte, ela influencia nas caracteristicas de um item processado

private int codigoDestaPeca; //Codigo desta peça gerado na inicialização, cuidado, maquinas diferentes podem gerar o mesmo codigo
private String nome; //String do nome desta peça, não é possivel alterar seu nome após criada
private String[] recipeString; //String dos Subcomponentes(Em blocos/itens/outras partes) necessarios pra fazer esta peça
private int[] recipeIDs; //Numero de InGameIDs do recipe

private boolean existe;  //A peça existe e tem dados atrelados a ela
private int[] codigoDasPeçasUsadas;  //Caso a parte seja criada, então deve colocar quais 'codigoDestaPeca'/'codigoDesteBloco'/'CodigoDesteItem' foram usadas pra completar a recipe

/*	public static void main(String[] args) {
		try {

	         // Instancia o objeto servidor e a sua stub  

	         	        
	         Registry registry = LocateRegistry.getRegistry();
	         String[] a=registry.list();
	       for(int i=0;i<a.length;i++) {
	    	   if(a[i].contains("Hello")) {
	    		   registry.unbind("Hello");
	    		   
	    	   }
	    	   if(a[i].contains("Parter")) {
	    		   registry.unbind("Parter");	    		   
	    	   }   
	    	   
	       }
	       String[] matS=new String[9];
	       matS[0]="Madeira";
	       matS[1]="Madeira";
	       matS[2]="Madeira";
	       matS[3]="vazio";
	       int[] matI=new int[9];
	       matI[0]=50;
	       matI[1]=50;
	       matI[2]=50;
	       Parts server = new Parts(1,"cabeça",matS,matI,null);
	         Part stub = (Part) UnicastRemoteObject.exportObject(server, 0);
	         registry.bind("Parter", stub);
	         

	         System.out.println("Servidor pronto");

	      } catch (Exception ex) {

	         ex.printStackTrace();

	      } 

	}
	*/


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
	InterfaceMundo mundo= (InterfaceMundo) registry.lookup("Mundo");
	InterfacePartServer partServ=(InterfacePartServer) UnicastRemoteObject.exportObject(this, 0);
	registry.rebind(nome, partServ);
	mundo.adicionaPartServer(nome, function);
}
	@Override
	public void AdicionaRecipe(){
		
	}

	
}
