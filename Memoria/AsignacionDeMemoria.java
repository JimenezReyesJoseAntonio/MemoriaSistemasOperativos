
/**
 * Write a description of class AsignacionDeMemoria here.
 * 
 * @author (Jose Antonio) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import javax.swing.JOptionPane; 
public class AsignacionDeMemoria
{
    public static void main(String args[]){
        ArrayList<Proceso>procesosAux = new ArrayList<Proceso>();
        ArrayList<Proceso>memoria = new ArrayList<Proceso>();   

        int tamañoMemoria,tamañoSO, tamañoPro, numero;
        int numProcesos, tiempo, tamaño;
        String nombreProceso;
        int aux = 0;

        tamañoMemoria  = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el tamaño de la memoria "));
        tamañoSO  = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el tamaño de memoria que ocupa el SO"));
        numProcesos  = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el numero de procesos  "));
        int ultimo = numProcesos;
        tamañoPro = tamañoMemoria - tamañoSO;
        System.out.println("El tamaño de la memoria es: " + tamañoMemoria + " k");
        System.out.println("El tamaño que ocupa el sistema operativo es: " + tamañoSO + " k");
        System.out.println("La memoria restante para los procesos de usuario es de : " + tamañoPro + " k");
        System.out.println("*********************");
        // agregar procesos 
        for(int j= 0; j < numProcesos; j++){
            nombreProceso = JOptionPane.showInputDialog(null, "Ingrese el nombre del proceso ");
            tiempo  = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el tiempo del proceso"));
            tamaño  = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el tamaño del proceso"));
            numero = j;
            Proceso proceso = new Proceso(nombreProceso, tamaño, tiempo, numero);
            procesosAux.add(proceso);
        }

        int x = tamañoPro;

        while(numProcesos > 0){
            int indice = 0;
            int i = 0;

            // mete los procesos a la memoria          
            for(Proceso s: procesosAux){

                if(tamañoPro >= s.getTamaño() && memoria.size() < 3 ){
                    memoria.add(s);
                    tamañoPro -= s.getTamaño();

                    aux++;
                }else{
                    break;
                }


            }
            // arreglo aux para agregar los tamaños de cada proceso;
            int []tamaños = new int[aux+1];

            System.out.println("[Procesos en memoria] ");
            //imprime los procesos que estan en memoria 
            for(Proceso p: memoria){

                String nombre = p.getNombreProceso();
                tamaños[i] = p.getTamaño();
                i++;
                System.out.println(nombre + " tamaño: " + p.getTamaño());
                procesosAux.remove(p);

            }
            System.out.println("------------------------");
            System.out.println("Memoria restante: " + tamañoPro);
            System.out.println("------------------------");

            tamaños[aux] = tamañoPro;

            System.out.println("[Procesos en espera]");
            System.out.println();
            // imprime los procesos en espera
            for(Proceso a: procesosAux){
                String nombre = a.getNombreProceso();
                System.out.println(nombre + " tamaño: " + a.getTamaño() );

            }

            /*for(int n: tamaños){
            System.out.println(n);

            }*/
            // eliminamos el proceso con menor tiempo
            int k = 0;
            int n = 0;
            int menorTiempo =memoria.get(0).getTiempo();
            for(Proceso s: memoria){
                if( menorTiempo < s.getTiempo()){     // s.getTiempo < menorTiempo

                }else{
                    menorTiempo = s.getTiempo();  
                    n = k;

                }
                k++;
            }

            
            tamañoPro += memoria.get(n).getTamaño();
            System.out.println("--------------------------");
            System.out.println("El proceso " +  memoria.get(n).getNombreProceso() + " Termino ");
            
            System.out.println("--------------------------");

            memoria.remove(n);
            menorTiempo = 0;
            // cada que termine un proceso se sale de la memoria 
            numProcesos--;
        }
            System.out.println("------------------------");
            System.out.println("Memoria restante: " + tamañoPro);
            System.out.println("------------------------");
    }
}
