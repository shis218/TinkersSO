import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class usuario {

private Bloco[] inventarioblocos;
private Part[] inventariopartes;
private Items[] inventarioItens;
private int maximoInventario;
private int proxBlock;
private int proxPart;
private int proxItem;
private InterfaceMundo mundo;

public static void main(String[] args) {

      String host = (args.length < 1) ? null : args[0];

      try {

         // Obt�m uma refer�ncia para o registro do RMI

         Registry registry = LocateRegistry.getRegistry(host);
         
    	 
         usuario usr=new usuario(42);

         // Obt�m a stub do servidor

         usr.mundo= (InterfaceMundo) registry.lookup("Mundo");
 /*        
         Part pi=usr.mundo.geraPart(7);
         
         usr.adiciona(pi);
 
         System.out.println("Ganhou part:  "+ usr.inventariopartes[0].getNome());
   */
         
         Scanner sc=new Scanner(System.in);
         System.out.println("Digite o comando a ser executado:");
         String dig=sc.nextLine();
         while(!dig.equalsIgnoreCase("sair")){
         
         System.out.println(usr.Executa(dig)); 
         System.out.println("Digite o comando a ser executado:");
         dig=sc.nextLine();
      } 
         System.out.println("Saindo");
         return ;
      }
         catch (Exception ex) {

         ex.printStackTrace();

      } 

}


public String Executa(String Comando) throws RemoteException {
	StringBuilder resp=new StringBuilder();
	Comando=Comando.replace("\n", "");
/*-----------Comandos exatos-----------*/
	if(Comando.equalsIgnoreCase("lista itens")){
		resp.append("\n Listando itens:");
			for(int i=0;i<inventarioItens.length;i++) {
				if(inventarioItens[i]!=null) {
					resp.append("item no slot: "+i+ " - "+ inventarioItens[i].getNome());
				}
			}
			return resp.toString();
	}
	if(Comando.equalsIgnoreCase("lista parts")){
		resp.append("\n Listando parts:");
		for(int i=0;i<inventariopartes.length;i++) {
			if(inventariopartes[i]!=null) {
				resp.append("item no slot: "+i+ " - "+ inventariopartes[i].getNome());
			}
		}
		return resp.toString();
	}
	if(Comando.equalsIgnoreCase("lista blocos")){
		resp.append("\n Listando blocos:");
		for(int i=0;i<inventarioblocos.length;i++) {
			if(inventarioblocos[i]!=null) {
				resp.append("item no slot: "+i+ " - "+ inventarioblocos[i].getNome());
			}
		}
		return resp.toString();
	}

	
	
	/*-----------Comandos com variavel-----------*/
	String[] Splitted=Comando.toLowerCase().split(" ");
	switch(Splitted[0]){
	case "adiciona":
		
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
	inventarioItens=new Items[tamanhoInventario];
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
	inventarioItens=new Items[tamanhoInventario];
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
public Items[] getInventarioItens() {
	return inventarioItens;
}


//Metodo adiciona recebe um bloco/parts/items em overload
public void adiciona(Bloco b){
	if(maximoInventario==proxBlock) {
		return;
	}
	inventarioblocos[proxBlock]=b;
	proxBlock++;
	
}
public void adiciona(Part p){
	if(maximoInventario==proxPart) {
		return;
	}
	inventariopartes[proxPart]=p;
	proxPart++;
	
}
public void adiciona(Items i){
	if(maximoInventario==proxItem) {
		return;
	}
	inventarioItens[proxItem]=i;
	proxItem++;
}

public void removeBloco(int index){
	//Remove logicamente
	inventarioblocos[index]=null;
}


public void removeParte(int index){
	//Remove logicamente
	inventariopartes[index]=null;
}


public void removeItem(int index){
	//Remove logicamente
	inventarioItens[index]=null;
}

/*fazer uma fun��o de ordenar o inventario quando o ultimo espa�o for utilizado*/

}
