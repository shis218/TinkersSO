import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import minimoentregavel.World;

public class admin {

private Bloco[] inventarioblocos;
private Part[] inventariopartes;
private Item[] inventarioItens;
private int maximoInventario;
private int proxBlock;
private int proxPart;
private int proxItem;
private InterfaceMundo mundo;
private InterfacePartServer partserver;
static Registry registry;

public static void main(String[] args) {
	admin adm=new admin();
	
	
      //String host = (args.length < 1) ? null : args[0];

      try {

         // Obtém uma referência para o registro do RMI

    	  adm.registry = LocateRegistry.getRegistry();
         
    	 
         

         // Obtém a stub do servidor

    	  adm.mundo= (InterfaceMundo) adm.registry.lookup("Mundo");

         
         Scanner sc=new Scanner(System.in);
         System.out.println("Digite o comando a ser executado:");
         String dig=sc.nextLine();
         while(!dig.equalsIgnoreCase("sair")){
         
         System.out.println(adm.Executa(dig)); 
         System.out.println("Digite o comando a ser executado: (escreva Help caso queira ver a lista de comandos)");
         dig=sc.nextLine();
      } 
         System.out.println("Saindo");
         return ;
      }
         catch (Exception ex) {

         ex.printStackTrace();

      } 

}




public String Executa(String Comando) throws RemoteException, NotBoundException {
	StringBuilder resp=new StringBuilder();
	Comando=Comando.replace("\n", "");
/*-----------Comandos exatos-----------*/
	if(Comando.equalsIgnoreCase("lista meus itens")||(Comando.equalsIgnoreCase("lista item"))){
		resp.append("\n Listando itens:\n");
			for(int i=0;i<inventarioItens.length;i++) {
				if(inventarioItens[i]!=null) {
					resp.append("item no slot: "+i+ " - "+ inventarioItens[i].getNome());
				}
			}
			return resp.toString();
	}
	if((Comando.equalsIgnoreCase("lista meus parts")) || (Comando.equalsIgnoreCase("lista part") )){
		resp.append("\n Listando parts:\\n");
		for(int i=0;i<inventariopartes.length;i++) {
			if(inventariopartes[i]!=null) {
				resp.append("item no slot: "+i+ " - "+ inventariopartes[i].getNome());
			}
		}
		return resp.toString();
	}
	if(Comando.equalsIgnoreCase("lista meus blocos")||(Comando.equalsIgnoreCase("lista bloco"))){
		resp.append("\n Listando blocos:\\n");
		for(int i=0;i<inventarioblocos.length;i++) {
			if(inventarioblocos[i]!=null) {
				resp.append("item no slot: "+i+ " - "+ inventarioblocos[i].getNome());
			}
		}
		return resp.toString();
	}
	if(Comando.equalsIgnoreCase("lista funções")){
		resp.append("Server possui as seguintes funções:\n");
		ArrayList<String[]> vetf=this.mundo.getNomelistaDeServidoresConhecidos();
		Iterator<String[]> iv=vetf.iterator();
		int count=0;
		while(iv.hasNext()) {
			String[] nextone=iv.next();
			resp.append(nextone[0]+"  "+nextone[1]+"\n");
			}
		return resp.toString();
		
	}
	
	if(Comando.equalsIgnoreCase("lista itens do server")){
		
		return resp.toString();
		
	}
	
	if(Comando.equalsIgnoreCase("lista parts do server")){
		
		return resp.toString();
		
	}

	if(Comando.equalsIgnoreCase("lista blocos do server")){
	
	return resp.toString();
	
	}
	
	
	if(Comando.equalsIgnoreCase("help")){
		resp.append("\n Para utilizar digite um dos comandos: adiciona/cria (blocos/parts/itens) [item name] ,monta parts [item name],  deleta(bloco/parts/itens) [item name] , ");
		resp.append("\n loga [nome do server] , desloga , lista meus (itens/blocos/parts) , lista funções, lista (blocos/parts/itens) do server, procura server [funcao],loga aleatorio [função] ,");
		resp.append("\n ");
		
		return resp.toString();
	}
	
	
	/*-----------Comandos com variavel-----------*/
	String[] Splitted=Comando.toLowerCase().split(" ");
	switch(Splitted[0]){		
		case "loga":
	
			
			break;
				
				default: 
					resp.append("Comando invalido! Apenas parts podem ser montadas. \n");
					break;
		
	
	
}
	return resp.toString();	
	}


void adicionaItem(String nome) {
	
}

void adicionaMaterial(String nome) {
	
}
void adicionaEncantamento(String nome) {
	
}
void adicionaPart(String nome) {
	
}
void adicionaBloco(String nome) {
	
}

void criaPartServer(String nome) {
	
}

void criaRecipe(String nome) {
	
}


void DesligaPartServer(String nome) {
	
}




}
