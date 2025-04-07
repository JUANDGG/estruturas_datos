

public class ListasDoblementeEnlazadas {
    private Nodo cabeza = null ;
    private Nodo cola =  null ;
    private static Integer  tamano = 0 ;

    public ListasDoblementeEnlazadas(Nodo cabeza  , Nodo cola) {
        this.cabeza = cabeza;
        this.cola = cola;
    }

    public ListasDoblementeEnlazadas() {}

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
        return ListasDoblementeEnlazadas.tamano;
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
        while (nodoCabeza.getNodoSiguiente() !=null) {
            if(contador == index){
                return nodoCabeza.getNodoSiguiente() ;
            }

            nodoCabeza = nodoCabeza.getNodoSiguiente() ;
            contador++;
        }

        return null ;

    }
  
    private static class Nodo {
        private Object dato ;
        private Nodo nodoSiguiente = null ;
        private Nodo nodoAnterior = null ;


        public Nodo (Object dato , Nodo nodoSigueinte , Nodo nodoAnterior){
            this.dato = dato;
            this.nodoSiguiente =nodoSigueinte ;
            this.nodoAnterior = nodoAnterior ;
            ListasDoblementeEnlazadas.tamano++;
        }

        public Nodo (){}

        public Object getDato (){
            return this.dato ;
        }
        public Nodo getNodoSiguiente() {
            return this.nodoSiguiente;
        }

        public void setNodoSiguiente(Nodo nodoSiguiente) {
            this.nodoSiguiente = nodoSiguiente;
        }

        public Nodo getNodoAnterior() {
            return this.nodoAnterior;
        }
        public void setNodoAnterior(Nodo nodoAnterior) {
            this.nodoAnterior = nodoAnterior;
        }
        public void setDato(Object dato) {
            this.dato = dato;
        }

      
    }

    public static void main(String[] args) {
        Nodo cabeza = new Nodo("hola soy la cabeza" , null, null);
        Nodo actual = cabeza;


        for (int i = 0  ;i<13 ;i++){
            Nodo nuevo_nodo = new Nodo( "hijo " + i , null  ,null) ;
            actual.setNodoSiguiente(nuevo_nodo);
            nuevo_nodo.setNodoAnterior(actual);
            actual = nuevo_nodo ;
        }
        ListasDoblementeEnlazadas lista = new ListasDoblementeEnlazadas(cabeza, actual);



         // mostrar los datos

         // para el tamaño xd
        Nodo refNodo = cabeza.getNodoSiguiente().getNodoAnterior();
        //System.out.println(refNodo.getDato());
        //ir a un elemento en especifico


        System.out.println(lista.getNodo(0).getNodoAnterior().getDato());
        

        
        
/* 
        while (refNodo != null){
            System.out.println(refNodo.getDato());
            refNodo = refNodo.getNodo();
        }
     */

    }
}


