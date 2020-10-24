/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg9;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alfredo
 */
public class Deck {
    
     List<Card> List = new ArrayList<>();
    Card card = new Card();
    //
     public Deck() {
        Crearcartas("Tréboles", "Negro");
        Crearcartas("Corazones", "Rojo");
        Crearcartas("Picas", "Negro");
        Crearcartas("Diamantes", "Rojo");
    }
    
    public void Crearcartas(String palo , String color) {
    for (int i = 2; i < 15; i++) {
            card.setPalo(palo);
            card.setColor(color);
            card.setValor(Integer.toString(i));
            
            if(i == 11){
                
                card.setValor("J");
            }
            if(i == 12){
                card.setValor("Q");
            }
            
            if(i == 13){
                card.setValor("K");
            }
            
            if(i == 14){
                card.setValor("A");
            }
            
            List.add(card);
            card = new Card();
        }

    }
    
    
    
    public void shuffle(){
    
        System.out.print("Se mezclo del deck \n");
    }
    
    public void head(){
        
       System.out.print("palo: " +  List.get(0).getPalo() + "  color: "+  List.get(0).getColor()  +"  valor: "+ List.get(0).getValor());
        List.remove(0);
       System.out.print("\n Quedan "+List.size()+" cartas \n"); 
    }
    
    public void pick(){
         int Random = (int) (Math.random() * (List.size() - 1) + 0);
         
         System.out.print("palo: " +  List.get(Random).getPalo() + "  color: "+  List.get(Random).getColor()  +"  valor: "+ List.get(Random).getValor());
        List.remove(Random);
        
       System.out.print("\n Quedan "+List.size()+" cartas \n"); 
         
    }
    
    public void hand(){
        
        for(int i = 0; i < 5; i++){
        System.out.print("palo: " +  List.get(i).getPalo() + "  color: "+  List.get(i).getColor()  +"  valor: "+ List.get(i).getValor());
        System.out.print("\n Quedan "+List.size()+" cartas \n"); 
     }
        for(int i = 0; i < 5; i++){
           List.remove(i); 
        }
        
        System.out.print("\n Quedan "+List.size()+" cartas \n"); 
    }
    
    public void menu(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        String tecla = null;
        String res = " ";
       
        do{
        System.out.print("Bienvenido al poker. \n");
        System.out.print("Elige una opcion. \n");
        System.out.print("1: Mezclar el deck.  \n");
        System.out.print("2: Sacar una carta. \n");
        System.out.print("3: Carta al azar. \n");
        System.out.print("4: Generar una mano de 5 cartas. \n");
        System.out.print("0: Salir. \n");
        
        opcion = entrada.nextInt();
        
        
        switch(opcion){
            
            case 1:
                shuffle();
                break;
            case 2:
                head();
                break;
            case 3:
                pick();
                break;
            case 4:
                hand();
                break;
            case 0:
                System.out.print("Juego finalizado \n");
                System.exit(0);
                break;
            default:
                System.out.print("Ingresa una opcion valida \n");
                
        }
                
                System.out.print("Quiere volver a jugar? \n");
                System.out.println(" si o no: ");
		tecla = new Scanner(System.in).nextLine();
        
        }while (tecla.equals("si") || tecla.equals("Si"));  
    } 
}
