import materia.controllers.*;
import materia.models.Nodo;
public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();
        
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);



        System.out.println("Nombre: Mateo Molina");
        System.out.println("El peso del arbol es: " + ab.getPeso());
        System.out.println("La altura del arbol es: " + ab.getAltura());
        System.out.println("El arbol InOrder: ");
        ab.imprimirArbolInOrden();
        System.out.println("");
        System.out.println(" El arbol InOrder con alturas: ");
        ab.imprimirArbolInOrdenAlt();
        System.out.println("");
        System.out.println("El arbol InOrder con Equilibrio: ");
        ab.imprimirArbolInOrdenFE();
        System.out.println("");
        System.out.println("El arbol esta equilibrado: " + ab.isEquilibrado());
        System.out.println("Agregar valor 15");

        ab.agregarNodo(new Nodo(15));

        ab.imprimirArbolInOrdenFE();
        System.out.println("Nodos desequilibrados:");
        
        ab.imprimirNodosDesequilibrados();



        
    }
}
