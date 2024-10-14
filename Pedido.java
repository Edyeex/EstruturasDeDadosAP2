class Pedido {

  int id;
  String descricao;
  Pedido next;

  public Pedido(int id, String descricao){

	this.id = id;
	this.descricao = descricao;
	this.next = null;

  }

}
