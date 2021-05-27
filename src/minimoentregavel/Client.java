package minimoentregavel;

import java.rmi.registry.*;

public class Client {

   public static void main(String[] args) {

      String host = (args.length < 1) ? null : args[0];

      try {

         // Obt�m uma refer�ncia para o registro do RMI

         Registry registry = LocateRegistry.getRegistry(host);

 

         // Obt�m a stub do servidor

         parts stub= (parts) registry.lookup("Hello");

 

         // Chama o m�todo do servidor e imprime a mensagem

         String msg = stub.hello();

         System.out.println("Mensagem do Servidor: " + msg); 

      } catch (Exception ex) {

         ex.printStackTrace();

      } 

   }

}