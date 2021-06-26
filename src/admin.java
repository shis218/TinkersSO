import java.rmi.AlreadyBoundException;
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
    	/*  adm.adicionaMaterialNoServer("Knightslime2", 320, 415, 50, (float) 1.4);
    	  adm.adicionaMaterialNoServer("Knightslime", 320, 415, 50, (float) 1.4);
    	  System.out.println(adm.mundo.PrintaMateriais());
    	  */
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




public String Executa(String Comando) throws RemoteException, NotBoundException, AlreadyBoundException {
	StringBuilder resp=new StringBuilder();
	Comando=Comando.replace("\n", "");
	/*-----------Comandos com variavel-----------*/
	String[] Splitted=Comando.toLowerCase().split(" ");
	switch(Splitted[0]){		
		case "deleta":
		//Sempre deleta server;
			DesligaPartServer(Splitted[2]);
			
		break;
		
		case "adiciona":
			switch(Splitted[1]){
			case "item":
				adicionaItemNoServer(Splitted[2]);
				resp.append("Adicionado");
			break;
			case "bloco":
				adicionaBlocoNoServer(Splitted[2]);
				resp.append("Adicionado,mas blocos não são funcionais");
			break;
			
			case "part":
				//Escreve nome da parte, nome da maquina, e seu material, então uma sequencia de itens do recipe, caso uma das strrings seja "0", pare.
				String nome=Splitted[2];
				String nomeMaquinaRegistry=Splitted[3];
				String nomeMaterial=Splitted[4];
				String[] recipeString=new String[9];
				for(int i=0;i<9;i++) {
					if(Splitted[i+5].equals("-1")) {
						for(int j=i;j<9;j++) {
							//Prenche com "null"
							recipeString[j] = "null";
						}
						break;
					}
				recipeString[i] = Splitted[i+5];
				}
				
				adicionaPartRecipeNoServer(nome, nomeMaquinaRegistry,recipeString, nomeMaterial);
				resp.append("Adicionado");
			break;
			
			case "server":
				//Adiciona um servidor [Nome-> funcao]
				criaPartServer(Splitted[2], Splitted[3]);
				break;
			}
			
		break;
		case "lista":
			switch(Splitted[1]){
			case "item":
				resp.append("Listando itens no mundo");
				resp.append(mundo.listaItens());
			break;
			case "bloco":
				resp.append("Listando itens no mundo, blocos estao desativados");
				resp.append(mundo.listaItens());
			break;
			
			case "parts":
				resp.append("Lista de parts no servidor:"+Splitted[2]+" \n");
				Registry registry = LocateRegistry.getRegistry();					
				//Loga naquele partserver e pede a lista
				InterfacePartServer ps=(InterfacePartServer) registry.lookup(Splitted[2]);
				resp.append(ps.consultaRecipes());
				break;
			case "servers":
				resp.append(mundo.listaServers());
				break;
			}
			
			
		break;
				
				default: 
					resp.append("Comando invalido! Apenas parts podem ser montadas. \n");
					break;
		
	
	
}
	return resp.toString();	
	}


void adicionaItemNoServer(String nome) throws RemoteException {
	mundo.adicionaItemNoServer(nome);
}

void adicionaMaterialNoServer(String nome,int Headdurabilidade,int Partsdurabilidade,int handleDurabilidade,float durabilityModifier) throws RemoteException {
	
	//Parte de encantamentos não foi implementada
	mundo.adicionaMaterialNoServer(nome, Headdurabilidade, null, null, Partsdurabilidade, null, null, handleDurabilidade, durabilityModifier);
	
	 
}

void adicionaPartRecipeNoServer(String nome, String nomeMaquinaRegistry,String[] recipeString, String nomeMaterial) throws RemoteException, NotBoundException {
	Registry registry = LocateRegistry.getRegistry();	
	//Coloca na lista de itens
	mundo.adicionaItemNoServer(nome);
	
	//Loga naquele partserver e adiciona
	InterfacePartServer ps=(InterfacePartServer) registry.lookup(nomeMaquinaRegistry);
	System.out.print("Tentando adicionar no mundo"+ps.getNome()+"\n");
	
	ps.AdicionaRecipe(nome, recipeString, nomeMaterial);
}
void adicionaBlocoNoServer(String nome) throws RemoteException {
	mundo.adicionaItemNoServer(nome);
	//Bloco não foi implementado
}




void criaPartServer(String nome, String Funcao) throws RemoteException, NotBoundException, AlreadyBoundException {
	 Registry registry = LocateRegistry.getRegistry();						 	
	 PartServer partserv=new PartServer(nome, Funcao,registry); 
	 System.out.println("Servidor: "+nome+" alocado com sucesso");
		
}




void DesligaPartServer(String nome) throws RemoteException, NotBoundException {
	Registry registry = LocateRegistry.getRegistry();
	registry.unbind(nome);
	mundo.removeServer(nome);
	System.out.println("Servidor: "+nome+" desligado com sucesso");
}




}
