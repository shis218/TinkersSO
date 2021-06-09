
public interface Bloco {

	//Getter-setters
	int getIngameID();

	int getcodigoDesteBloco();

	String getNome();

	//Afirma existencia do bloco
	boolean getExiste();

	Bloco ClonaBloco(int NovoCodigoDeBloco);
	/*Metodo externo		
		public String posicionaNoMundo(Blocos bloco,int x, int y, Mundo mundo) {
			Mundo.plano[x][y][z]==0){
			Mundo.plano[x][y][z]=bloco.getIngameID; //Quando bloco é colocado, ele perde seu Id unico Anterior, já que seu objeto vai ser destruido para evitar duplicação
			String strRet="Bloco"+ bloco.getNome()+"Id("+bloco.getId()+") adicionado no mundo na posição"+x+", "+y+", "+z;
			bloco.finalize();
			return strRet;
			}
		}
		*/

}