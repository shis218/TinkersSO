package helloworld;
import java.rmi.*;
public interface helloworld extends Remote  {


   public String hello() throws RemoteException;

}