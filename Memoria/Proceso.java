
public class Proceso
{
    private String nombre; 
    private int  tamaño;
    private int tiempo; 
    private int numero;
    public Proceso(String nombre, int tamaño, int tiempo, int numero){
     this.nombre = nombre;
     this.tamaño = tamaño;
     this.tiempo = tiempo;
     this.numero = numero;
    }
    
    public String  getNombreProceso(){
     return nombre;
    }
    
    public int getTamaño(){
     return tamaño;
    }
    public int getTiempo(){
     return tiempo;
    }
    
    public int getNumero(){
     return numero;
    }
}
