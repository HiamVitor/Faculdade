
package Tad;

public class Livro {
    private String titulo;
    private String autor;
    private int paginas;
    //
    public Livro(){
        this.setTitulo("padrao");
        this.setAutor("padrao");
        this.setPaginas(1);
    }
    public Livro(String titulo,String autor, int paginas){
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setPaginas(paginas);
    }
    //
    public void setTitulo(String titulo){
        this.titulo=titulo.trim().isEmpty()?"PADRAO":titulo.toUpperCase();
    }
    public void setAutor(String autor){
        this.autor=autor.trim().isEmpty()?"PADRAO":autor.toUpperCase();
    }
    public void setPaginas(int paginas){
        this.paginas = paginas <=0 ? 1 : paginas;
    }
    //
    public String getTitulo(){
        return this.titulo;
    }
    public String getAutor(){
        return this.autor;
    }
    public int getPaginas(){
        return this.paginas;
    }
    //
    @Override
    public String toString(){
        return this.titulo;
    }
    
}
