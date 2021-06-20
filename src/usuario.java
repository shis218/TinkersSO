import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class usuario {

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
	usuario usr=new usuario(42);
	
	
      //String host = (args.length < 1) ? null : args[0];

      try {

         // Obt�m uma refer�ncia para o registro do RMI

    	  usr.registry = LocateRegistry.getRegistry();
         
    	 
         

         // Obt�m a stub do servidor

         usr.mundo= (InterfaceMundo) usr.registry.lookup("Mundo");

         
         Scanner sc=new Scanner(System.in);
         System.out.println("Digite o comando a ser executado:");
         String dig=sc.nextLine();
         while(!dig.equalsIgnoreCase("sair")){
         
         System.out.println(usr.Executa(dig)); 
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
	if(Comando.equalsIgnoreCase("lista fun��es")){
		resp.append("Server possui as seguintes fun��es:\n");
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
		resp.append("\n Para utilizar digite um dos comandos: adiciona/cria (blocos/parts/itens) [item name] ,monta (blocos/parts/itens) [item name],  deleta(bloco/parts/itens) [item name] , ");
		resp.append("\n loga [nome do server] , desloga , lista meus (itens/blocos/parts) , lista fun��es, lista (blocos/parts/itens) do server, procura server [funcao],loga aleatorio [fun��o]");
		
		
		return resp.toString();
	}
	
	
	/*-----------Comandos com variavel-----------*/
	String[] Splitted=Comando.toLowerCase().split(" ");
	switch(Splitted[0]){
		case "adiciona":  //
		case "cria":	
			switch(Splitted[1]){
				case "bloco":
				case "blocos":
					adiciona(mundo.geraBloco(Integer.parseInt(Splitted[2])));
					break;
				case "part":
				case "parts":
					adiciona(mundo.geraPart(Integer.parseInt(Splitted[2])));
					break;
					
				case "item":
				case "itens":
					
					adiciona(mundo.geraItem(Integer.parseInt(Splitted[2])));
					break;
					
		}
			break;
		case "deleta":	
			switch(Splitted[1]){
				case "bloco":
				case "blocos":
					removeBloco(Integer.parseInt(Splitted[2]));
					break;
				case "part":
				case "parts":
					removeParte(Integer.parseInt(Splitted[2]));
					break;
					
				case "item":
				case "itens":
					
					removeItem(Integer.parseInt(Splitted[2]));
					break;
				
			}	
			break;
		case "loga":
			partserver=(InterfacePartServer) registry.lookup(Splitted[1]);
			resp.append("Logando em:"+Splitted[1]);
			break;
		case "desloga":
			resp.append("Deslogando de: "+partserver.getNome());
			partserver=null;
			
			break;	
			
		case "monta":
			switch(Splitted[1]){
				case "parts":
				case "part":
					//Monta a parte
					
					
				break;
				
				default: 
					resp.append("Comando invalido! Apenas parts podem ser montadas. \n");
					break;
			}
			
			break;
			
		case "procura":
			if(Splitted[1].equalsIgnoreCase("server")) {
				//Recebe a string do server e se conecta com ele.
				String sev=mundo.ProcuraServer(Splitted[2]);
				resp.append("Logando em:"+sev);
				
				partserver=(InterfacePartServer) registry.lookup(sev);
			}
			else {
				resp.append("Comando invalido! \n");
			}
			break;
	default: 	
		resp.append("Comando invalido! \n");
	}
		
		//Colocar pra reconhecer EXECUTA MAQUINA
	
	
	
	return resp.toString();
	
}


public usuario(int tamanhoInventario) {
	//Gera inventarios
	maximoInventario=tamanhoInventario;
	inventarioblocos=new Bloco[tamanhoInventario];
	inventariopartes=new Part[tamanhoInventario];
	inventarioItens=new Item[tamanhoInventario];
	proxBlock=0;
	proxPart=0;
	proxItem=0;
}

//Construtor j� com o mundo externo passado por parametro
public usuario(int tamanhoInventario, Mundo m) {
	//Gera inventarios
	maximoInventario=tamanhoInventario;
	inventarioblocos=new Bloco[tamanhoInventario];
	inventariopartes=new Part[tamanhoInventario];
	inventarioItens=new Item[tamanhoInventario];
	proxBlock=0;
	proxPart=0;
	proxItem=0;
	this.mundo=m;
}
public Bloco[] getInventarioblocos() {
	return inventarioblocos;
}
public Part[] getInventariopartes() {
	return inventariopartes;
}
public Item[] getInventarioItens() {
	return inventarioItens;
}


//Metodo adiciona recebe um bloco/parts/items em overload
public void adiciona(Bloco b) throws RemoteException {
	if(maximoInventario==proxBlock) {
		System.out.print("Item desse usuario chegou no limite.");
		return;
	}
	inventarioblocos[proxBlock]=b;
	proxBlock++;
	System.out.println(b.getNome()+"Adicionado com sucesso");
	
}
public void adiciona(Part p) throws RemoteException{
	if(maximoInventario==proxPart) {
		System.out.print("Item desse usuario chegou no limite.");
		return;
	}
	inventariopartes[proxPart]=p;
	proxPart++;
	System.out.println(p.getNome()+"Adicionado com sucesso");
}
public void adiciona(Item i)  throws RemoteException{
	if(maximoInventario==proxItem) {
		System.out.print("Item desse usuario chegou no limite.");
		return;
	}
	inventarioItens[proxItem]=i;
	proxItem++;
	System.out.println(i.getNome()+"Adicionado com sucesso");
}

public void removeBloco(int index){
	//Remove tirando a referencia na lista, o item ainda pode ser consultado por outras referencias
	inventarioblocos[index]=null;
}


public void removeParte(int index){
	//Remove tirando a referencia na lista, o item ainda pode ser consultado por outras referencias
	inventariopartes[index]=null;
}


public void removeItem(int index){
	//Remove tirando a referencia na lista, o item ainda pode ser consultado por outras referencias
	inventarioItens[index]=null;
}



}
