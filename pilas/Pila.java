package pilas;

public class Pila {

    private Nodo cabeza  ;
    private Nodo cola ;
    public static Integer longitud = 0;

    public Pila(Nodo cabeza  , Nodo cola) {
        this.cabeza = null;
        this.cola = null;
    }



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


    public static Integer getLongitud() {
        return longitud;
    }


    public static void setLongitud(Integer longitud) {
        Pila.longitud = longitud;
    }


    public void apilar(Plato plato) {
        Nodo nuevo = new Nodo(plato, null);
        if (this.cabeza == null) {
            this.cabeza = nuevo;
            this.cola = nuevo;
        } else {
            nuevo.setSiguiente(this.cabeza);
            this.cabeza = nuevo;
        }
    }

    public void desapilar(){
        if(this.cabeza == null) {
            throw new RuntimeException("no se puede desapilar en una estrutura que no existo ");
        }
      
        this.cabeza = this.cabeza.getSiguiente();
        Pila.longitud-- ;
    }

    public static void main(String[] args) {
        Pila pila = new Pila(null, null);
    
        pila.apilar(new Plato("macarrones con queso"));
    
        for (int i = 1; i <= 10; i++) {
            pila.apilar(new Plato("plato " + i));
        }
    
        pila.apilar(new Plato("quesito"));
    
        
        Nodo temp = pila.getCabeza();
        System.out.println("Contenido de la pila:");
        while (temp != null) {
            System.out.println(temp.getPlato().getNombre());
            temp = temp.getSiguiente();
        }
    }
    






}


class Nodo {
    private Plato plato;
    private Nodo siguiente;

    public Nodo(Plato plato , Nodo siguiente) {
        this.plato = plato;
        this.siguiente = siguiente;
        Pila.longitud++;
    }

    public Plato getPlato() {
        return this.plato;
    }

    public void sePlato(Plato plato) {
        this.plato =plato;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}


class Plato {
    private String nombre ;

    public Plato(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}