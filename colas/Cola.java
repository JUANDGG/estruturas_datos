package colas;

public class Cola {
    // una cola es   lo mismo que una lista enlazada aqui las operaciones son mas distintas

    private Nodo cabeza = null ;
    private Nodo cola = null ;
    public static Integer  tamano = 0 ;
    
    public Cola(Nodo cabeza , Nodo cola) {
        this.cabeza = cabeza;
        this.cola = cola;
    }
    public Cola() {}

    public Nodo getCabeza() {
        return this.cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    public Nodo getCola() {
        return this.cola;
    }
    public void setCola(Nodo cola) {
        this.cola = cola;
    }
    public Integer getTamano() {
        return Cola.tamano;
    }

    
    public void insertar (Pedido pedido) {
        Nodo nuevaCola = new Nodo(pedido , null) ;

        if(this.cabeza == null) {
            this.cabeza = nuevaCola;
            this.cola = nuevaCola;
        }

        /* recuperamos el elemento que estaba en la colay como la cola no tiene
         siguiente a ese elemento le asignamos el nuevo nodo siguiente que lo que hace 
         es el nuevo nodo toma el lugar del ultimo en la cola */
         
        this.cola.setNodoSiguiente(nuevaCola);
        this.cola = nuevaCola;
    }


    
      public void despachar () {
        if (this.cabeza == null) {
            System.out.println("No hay elementos en la cola");
            return;
        }
    
        System.out.println("Despachando: " + this.cabeza.getPedido().getNombre());
        this.cabeza = this.cabeza.getNodoSiguiente();
    
        if (this.cabeza == null) {
            this.cola = null;
        }
    
        Cola.tamano--;
    }
    
    
    


    public static void main(String[] args) {

        // #1 producto en la cola
        Pedido pedido1 = new Pedido("shampoo" , 20) ;
    
        Nodo  nodoCabeza = new Nodo(pedido1, null);
        Nodo  tempActual = nodoCabeza ;


        for(int i = 0 ; i< 7 ; i++){
            Nodo nodoHijo = new Nodo(new Pedido("producto" + (i +1) , i) , null) ;
            tempActual.setNodoSiguiente(nodoHijo);
            tempActual = nodoHijo ;
        }
 
        Cola cola = new Cola(nodoCabeza , tempActual) ;


        System.out.println(cola.getCabeza().getPedido().getNombre());
        cola.despachar();
        System.out.println(cola.getCabeza().getPedido().getNombre());


        System.out.println(cola.getCola().getPedido().getNombre());
        cola.insertar(new Pedido("nuevo producto" , 10));

        System.out.println(cola.getCola().getPedido().getNombre());


        


     /*    while (nodo.getsiguente() != null) {
            System.out.println(nodo.getPedido().getNombre());
            nodo = nodo.getsiguente();
            
        } */




    }
}

 class Nodo {
    private Pedido pedido ;
    private Nodo nodoSiguiente = null ;

    public Nodo (Pedido pedido , Nodo nodoSiguiente){
        this.pedido = pedido;
        this.nodoSiguiente =nodoSiguiente ;
        Cola.tamano++;
    }

    public Nodo (){}

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Nodo getNodoSiguiente() {
        return this.nodoSiguiente;
    }

    public void setNodoSiguiente(Nodo nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }
}


class Pedido {
    private String nombre ;
    private int cantidad ;

    public Pedido (String nombre , int cantidad){
        this.nombre = nombre ;
        this.cantidad = cantidad ;
    }

    public String getNombre (){
        return this.nombre ;
    }

    public int getCantidad (){
        return this.cantidad ;
    }


    public void setNombre (String nombre){
        this.nombre = nombre ;
    }
    public void setCantidad (int cantidad){
        this.cantidad = cantidad ;
    }
}
