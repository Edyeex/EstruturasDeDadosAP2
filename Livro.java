public class Livro {
  int id;
  String titulo;
  String autor;
  Livro prev, next;

  public Livro(int id, String titulo, String autor) {
	this.id = id;
	this.titulo = titulo;
	this.autor = autor;
	this.prev = this.next = null;
  }
}
