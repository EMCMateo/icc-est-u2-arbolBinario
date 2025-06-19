    package materia.controllers;
    import materia.models.Nodo;
    public class ArbolBinario {
        private Nodo root;
        private int peso;

        public ArbolBinario(){
            this.root = null;
        }

        public void insert(int valor){
            root = insertRec(root, valor);
            peso++;
            
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
            System.out.print(nodo.getIzquierdo() + ", ");
            imprimir(nodo.getIzquierdo());
            imprimir(nodo.getDerecho());
        }
    }



    public void imprimirArbolInOrdenAlt() {
        imprimirInOrdenAlt(root);
    }

    private void imprimirInOrdenAlt(Nodo nodo) {
        if (nodo != null) {
            imprimirInOrdenAlt(nodo.getIzquierdo());
            System.out.print(nodo.getValor() +" -> H: "+ getRecAltura(nodo)+ ", ");
            imprimirInOrdenAlt(nodo.getDerecho());
        }
    }

    public void imprimirArbolInOrdenFE() {
        imprimirInOrdenFE(root);
    }

    private void imprimirInOrdenFE(Nodo nodo) {
        if (nodo != null) {
            imprimirInOrdenFE(nodo.getIzquierdo());
            System.out.print(nodo.getValor() +" -> FE: "+ getFactorEquilibrioRec(nodo)+ ", ");
            imprimirInOrdenFE(nodo.getDerecho());
            
        }
    }


    public void imprimirArbolInOrden() {
        imprimirInOrden(root);
    }

    private void imprimirInOrden(Nodo nodo) {
        if (nodo != null) {
            imprimirInOrden(nodo.getIzquierdo());
            System.out.print(nodo.getValor() + ", ");
            imprimirInOrden(nodo.getDerecho());
        }
    }



    public boolean buscar(int valor) {
        return buscarRec(root, valor);
    }

    private boolean buscarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            System.out.println("El valor " + valor + " no se encuentra en el árbol.");
            return false;
        }
        if (nodo.getValor() == valor){
            System.out.println("El valor está en el arbol.");
            return true;
        }
        if (valor < nodo.getValor()) {
            return buscarRec(nodo.getIzquierdo(), valor);
        } else {
            return buscarRec(nodo.getDerecho(), valor);
        }   
    }


    public int getAltura() {
        return getRecAltura(root);
    }
    private int getRecAltura(Nodo nodo){
        if (nodo == null){
            return 0;

        }
        int leftHeight = getRecAltura(nodo.getIzquierdo());
        int rightHeight = getRecAltura(nodo.getDerecho());
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public int getPeso(){
        return peso;
    }



    public int getFactorEquilibrioPorNodo (){
        if (root == null) {
            return 0;
        }
        return getFactorEquilibrioRec(root);
    }

    private int getFactorEquilibrioRec(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int altIzq = getRecAltura(nodo.getIzquierdo());
        int altDer = getRecAltura(nodo.getDerecho());
        return altIzq - altDer;


    }

    public boolean isEquilibrado(){
        
        return isEquilibradoRec(root);

    }

    private boolean isEquilibradoRec(Nodo nodo) {
        if (nodo == null) {
            return true;
        }
        int factorEquilibrio = getFactorEquilibrioRec(nodo);
        if (getFactorEquilibrioRec(nodo) > 1 || getFactorEquilibrioRec(nodo) < -1   ) {
            return false;
        }
        return isEquilibradoRec(nodo.getIzquierdo()) && isEquilibradoRec(nodo.getDerecho());
    
    }

    

    public void agregarNodo(Nodo nodo){
        if (root == null) {
            root = nodo;
        } else {
            insertRec(root, nodo.getValor());
        }
    }

    public void imprimirNodosDesequilibrados() {
    System.out.print("Nodos desequilibrados ");
    imprimirNodosDesequilibradosRec(root);
    System.out.println();
}

    private void imprimirNodosDesequilibradosRec(Nodo nodo) {
    if (nodo != null) {
        int fe = getFactorEquilibrioRec(nodo);
        if (fe < -1 || fe > 1) {
            System.out.print(nodo.getValor() + "(fE = " + fe + ") ");
        }
        imprimirNodosDesequilibradosRec(nodo.getIzquierdo());
        imprimirNodosDesequilibradosRec(nodo.getDerecho());
    }
}
}