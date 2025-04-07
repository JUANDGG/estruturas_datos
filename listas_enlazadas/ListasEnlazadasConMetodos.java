

public class ListasEnlazadasConMetodos {
    private Nodo cabeza = null ;
    private Nodo cola =  null ;
    private static Integer  tamano = 0 ;

    public ListasEnlazadasConMetodos(Nodo cabeza  , Nodo cola) {
        this.cabeza = cabeza;
        this.cola = cola;
    }

    public ListasEnlazadasConMetodos() {}

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    public Integer getTamano() {
        return ListasEnlazadasConMetodos.tamano;
    }

    public void setTamano(Integer tamano) {
        this.tamano = tamano;
    }

    public Nodo getNodo(int index){
        if(this.cabeza == null) {
            return null ;
        }

        Nodo nodoCabeza = this.cabeza  ;
        int contador = 0;
        while (nodoCabeza.getNodo() !=null) {
            if(contador == index){
                return nodoCabeza.getNodo() ;
            }

            nodoCabeza = nodoCabeza.getNodo() ;
            contador++;
        }

        return null ;

    }
  
    private static class Nodo {
        private Object dato ;
        private Nodo nodo = null ;

        public Nodo (Object dato , Nodo nodo){
            this.dato = dato;
            this.nodo =nodo ;
            ListasEnlazadasConMetodos.tamano++;
        }

        public Nodo (){}

        public Object getDato() {
            return dato;
        }

        public Nodo getNodo() {
            return nodo;
        }

        public void setDato(Object dato) {
            this.dato = dato;
        }

        public void setNodo(Nodo nodo) {
            this.nodo = nodo;
        }
    }

    public static void main(String[] args) {
        Nodo cabeza = new Nodo("hola soy la cabeza" , null);
        Nodo actual = cabeza;

        for (int i = 0  ;i<13 ;i++){
            Nodo nuevo_nodo = new Nodo(i , null ) ;
            actual.setNodo(nuevo_nodo);
            actual = nuevo_nodo ;
        }
        ListasEnlazadasConMetodos lista = new ListasEnlazadasConMetodos(cabeza, actual);



         // mostrar los datos

         // para el tamaño xd
        Nodo refNodo = cabeza.getNodo();
        System.out.println(lista.getTamano());
        //ir a un elemento en especifico


        System.out.println(lista.getNodo(0));



        

        while (refNodo != null){
            System.out.println(refNodo.getDato());
            refNodo = refNodo.getNodo();
        }
    }
}


