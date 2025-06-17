package materia.controllers;
import materia.models.Nodo;
public class ArbolBinario {
    private Nodo root;

    public ArbolBinario(){
        this.root = null;
    }

    public void insert(int valor){
        root = insertRec(root, valor);
        
    }

    private Nodo insertRec(Nodo padre, int valor){
        if (padre == null) {
            return new Nodo(valor);
        }
        if (valor < padre.getValor()) {
            padre.setIzquierdo(insertRec(padre.getIzquierdo(), valor));
        } else if (valor > padre.getValor()) {
            padre.setDerecho(insertRec(padre.getDerecho(), valor));
        } else {
            System.out.println("El valor ya existe.");
            
        }
        return padre;
        
    }

    public void imprimirArbol(){
        imprimir(root);
    }

    private void imprimir(Nodo nodo) {
    if (nodo != null) {
        System.out.print(nodo.getValor() + ", ");
        imprimir(nodo.getIzquierdo());
        imprimir(nodo.getDerecho());
    }
}
}
