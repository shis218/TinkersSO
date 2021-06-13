import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class InstanciaPartServers implements Remote {

	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException, AlreadyBoundException {
		// TODO Auto-generated method stub
		
		 Registry registry = LocateRegistry.getRegistry();
		 InterfaceMundo mundo= (InterfaceMundo) registry.lookup("Mundo");
		 
		 
		 ArrayList<String[]> v= mundo.getNomelistaDeServidoresConhecidos();
		 for(int i=0;i<v.size();i++) {
			 System.out.println(v.get(i)[0]+"-->"+ v.get(i)[1]);
		 }
		 
		
	}

	
	public void criaFurnaces() throws RemoteException, NotBoundException, AlreadyBoundException {
		 Registry registry = LocateRegistry.getRegistry();
		String[][] maquinas={ {"Furnace155","Furnace"}, 
				 {"Furnace912","Furnace"},
				 {"Furnace17","Furnace"},
				 {"Workbech241","Workbech"},
				 {"TF312","ToolForge"},} ;
			
		 for(int i=0;i<maquinas.length;i++) {			 
			 PartServer partserv=new PartServer(maquinas[i][0],maquinas[i][1],registry); 
			 System.out.println("Servidor: "+maquinas[i][0]+" alocado com sucesso");
		 }
	}
}