
public class ListasEnlazadasBasico<T> {
    //podemos guardar elementos que sean del mismo tipo

    //NODOS : dondes van los datos encapsulados 
    //PUNTEROS ADELANTE  : apuntan al siguiente elemntos
    //PUNTEROS ATRAS :apuntas al anterior elemento

    
    private Nodo<T> nodoCabeza ;
    private Nodo<T> nodoCola ;


    public Nodo<T>  getNodoCabeaza (){
        return this.nodoCabeza;
    }

    public void setNodoCabeza (Nodo nodoCabeza){
        this.nodoCabeza = nodoCabeza;
    }

    public Nodo<T> getNodoCola (){
        return this.nodoCola = nodoCola ;
    }

    public void setNodoCola (Nodo<T> nodoCola){
        this.nodoCola = nodoCola;
    }

    public ListasEnlazadasBasico (){}

    public ListasEnlazadasBasico (Nodo nodoCabeza , Nodo<T> nodoCola){
        this.nodoCabeza = nodoCabeza ;
        this.nodoCola =  nodoCola;
    }





    public static void main(String[] args) {
        Nodo<String> nodoCabeza = new Nodo<>("cabeza" ,null) ;
        Nodo<String> tempActual = nodoCabeza ;

        for(int i = 0 ; i< 7 ; i++){
            Nodo<String> nodoHijo = new Nodo("hijo" + (i +1) , null) ;
            tempActual.setPuntero(nodoHijo);
            tempActual = nodoHijo ;
        }

        ListasEnlazadasBasico<String> lista = new ListasEnlazadasBasico<>(nodoCabeza , tempActual) ;


        Nodo<String> temp =  lista.getNodoCabeaza();
        while (temp!=null) {
            System.out.println(temp.getDato());
            temp = temp.getPuntero();
            
        }


    }


}


class Nodo<T>  {
    private T dato ;
    private Nodo<T>  puntero ;

    public Nodo (T dato  , Nodo<T>  puntero ){
        this.dato = dato ;
        this.puntero = puntero;
    }

    public Nodo (){}

    public T getDato (){
        return this.dato ;
    }

    public Nodo<T> getPuntero (){
        return this.puntero ;
    }

    public void setDato (T dato) {
        this.dato = dato ;
    }

    public void setPuntero (Nodo<T> puntero) {
        this.puntero = puntero ;
    }
}