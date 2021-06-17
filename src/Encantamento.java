import java.io.Serializable;

public class Encantamento implements Serializable{
private int CodigoDoEncantamento;
private String nome;
private String[] requisitosDoEncantamento;
private int[] IDsrequisitosDoEncantamento;


public int getCodigoDoEncantamento() {
	return CodigoDoEncantamento;
}
public void setCodigoDoEncantamento(int codigoDoEncantamento) {
	CodigoDoEncantamento = codigoDoEncantamento;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String[] getRequisitosDoEncantamento() {
	return requisitosDoEncantamento;
}
public void setRequisitosDoEncantamento(String[] requisitosDoEncantamento) {
	this.requisitosDoEncantamento = requisitosDoEncantamento;
}
public int[] getIDsrequisitosDoEncantamento() {
	return IDsrequisitosDoEncantamento;
}
public void setIDsrequisitosDoEncantamento(int[] iDsrequisitosDoEncantamento) {
	IDsrequisitosDoEncantamento = iDsrequisitosDoEncantamento;
}

}
