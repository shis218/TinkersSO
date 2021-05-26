
public class usuario {

private Blocos[] inventarioblocos;
private Parts[] inventariopartes;
private Items[] inventarioItens;
private int maximoInventario;
private int proxBlock;
private int proxPart;
private int proxItem;



public usuario(int tamanhoInventario) {
	//Gera inventarios
	maximoInventario=tamanhoInventario;
	inventarioblocos=new Blocos[tamanhoInventario];
	inventariopartes=new Parts[tamanhoInventario];
	inventarioItens=new Items[tamanhoInventario];
	proxBlock=0;
	proxPart=0;
	proxItem=0;
}

public Blocos[] getInventarioblocos() {
	return inventarioblocos;
}
public Parts[] getInventariopartes() {
	return inventariopartes;
}
public Items[] getInventarioItens() {
	return inventarioItens;
}


//Metodo adiciona recebe um bloco/parts/items em overload
public void adiciona(Blocos b){
	if(maximoInventario==proxBlock) {
		return;
	}
	inventarioblocos[proxBlock]=b;
	proxBlock++;
	
}
public void adiciona(Parts p){
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
