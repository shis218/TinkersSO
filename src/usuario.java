import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class usuario {

private Bloco[] inventarioblocos;
private Part[] inventariopartes;
private Items[] inventarioItens;
private int maximoInventario;
private int proxBlock;
private int proxPart;
private int proxItem;

public static void main(String[] args) {

      String host = (args.length < 1) ? null : args[0];

      try {

         // Obtém uma referência para o registro do RMI

         Registry registry = LocateRegistry.getRegistry(host);

 

         // Obtém a stub do servidor

         Part stub= (Part) registry.lookup("Parter");

 

         // Chama o método do servidor e imprime a mensagem

         String msg = stub.getExiste()+"";

         System.out.println("Mensagem do Servidor: peça existe?" + msg); 

         stub.Monta(stub.getCodigoDestaPeca(), null);
         msg = stub.getExiste()+"";

         System.out.println("Mensagem do Servidor: peça existe?" + msg); 
         
        	 
         
         
      } catch (Exception ex) {

         ex.printStackTrace();

      } 

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

/*fazer uma função de ordenar o inventario quando o ultimo espaço for utilizado*/

}
