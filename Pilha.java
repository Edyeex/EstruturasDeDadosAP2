public class Pilha {
  private Pedido topo;

  public Pilha(){
	topo = null;
  }

  public void adicionar(int id, String descricao) {

	Pedido novoPedido = new Pedido(id, descricao);
	novoPedido.next = topo;
	topo = novoPedido;

  }

  public Pedido remover() {

	if (topo == null) return null;
	Pedido pedidoRemovido = topo;
	topo = topo.next;
	return pedidoRemovido;

  }

  public void mostrarPedidosCancelados(){

	Pedido atual = topo;
	while (atual != null){
	  System.out.println("ID: " + atual.id + ", Descrição: " + atual.descricao);
	  atual =atual.next;

	}
  }
}
