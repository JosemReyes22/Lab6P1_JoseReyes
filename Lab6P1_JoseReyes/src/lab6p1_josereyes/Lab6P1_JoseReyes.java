/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_josereyes;

/**
 *
 * @author josem
 */
import java.util.Scanner;
import java.util.Random;
public class Lab6P1_JoseReyes {
    static Scanner r= new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int menu=1;
        
        while(menu==1){
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println("Bienvenido al menu principal\n1.Lista del super\n2.Vocales y Consonantes\n3.Floor and ceiling\n4.Salir");
            int opciones=r.nextInt();
            switch(opciones){
                case 1:{
                    System.out.println("Ingrese productos");
                    String productos=r.next();
                    String[] arregloPalabras = separarcadenas(productos);
                    System.out.print("Arreglo resultante: [");
                    for (int i = 0; i < arregloPalabras.length - 1; i++) {
                        System.out.print(arregloPalabras[i] + "][");
                    }
                    System.out.println(arregloPalabras[arregloPalabras.length - 1] + "]");
                }break;
                case 2:{
                    System.out.println("Ingrese la cadena");
                    String cadena=r.next();
                    char[]resultados=new char[cadena.length()];
                    resultados=caracteresArreglados(cadena);
                    
                    impresion1(resultados);
                }break;
                case 3:{
                    System.out.println("Ingrese el tamano del arreglo");
                    int num1=r.nextInt();
                    arregloaleatorio(num1);
                    int arreglo1[]=new int[num1];
                    int arrfinal[]=new int[2];
                    arreglo1=arregloaleatorio(num1);
                    arrfinal=MenorMayor(arreglo1);
                    impresion(arreglo1,arrfinal);
                }break;
                case 4:{
                    menu=0;
                    System.out.println("Programa finalizado");
                }break;
                default:
                    System.out.println("~~~Opcion no valida~~~");
            }
        }
    }
    public static int[] arregloaleatorio(int tam){
        int temporal[]=new int[tam];
        for (int i = 0; i <tam; i++) {
            temporal[i]=1000+ran.nextInt(1571);
        }
        return temporal;
    }
    public static void impresion(int[]arr,int []arrfinal){
        System.out.println("Arreglo generado");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("{"+arr[i]+"}");
        }
        System.out.println();
        System.out.println("Arreglo final");
        for (int i = 0; i < arrfinal.length; i++) {
            System.out.print("{"+arrfinal[i]+"}");
        }
        System.out.println();
    }
    public static int[]MenorMayor(int[]arr1){
        int menor[]=new int[1];
        menor[0]=999999999;
        int mayor[]=new int[1];
        mayor[0]=0;
        
        for (int i = 0; i < arr1.length; i++) {
            if(menor[0]>arr1[i]){
                menor[0]=arr1[i];
            }
            if(mayor[0]<arr1[i]){
                mayor[0]=arr1[i];
            }
        }
        int arreglofinal[]=new int[2];
        arreglofinal[0]=menor[0];
        arreglofinal[1]=mayor[0];
        return arreglofinal;
    }
    public static char[] caracteresArreglados(String palabra){
        String ordenada="";
        String ordenada2="";
        for (int i = 0; i <palabra.length(); i++) {
            char x= palabra.charAt(i);
            if(x== 'a' || x == 'e' || x== 'i' || x == 'o' || x == 'u'|| x == 'A' || x == 'E' || x == 'I' || x == 'O' ||x == 'U'){
                ordenada+=x;
            }else{
                ordenada2+=x;
            }
        }
        String ordenadafinal=ordenada+ordenada2;
        char []resultado=new char[ordenadafinal.length()];
        for (int j = 0; j < ordenadafinal.length(); j++) {
            char x=ordenadafinal.charAt(j);
            resultado[j]=x;            
        }
        return resultado;
    }
    public static void impresion1(char[]finals1){
        int z=finals1.length;
        System.out.println("Resultado");
        System.out.print("{");
        for (int j = 0; j < finals1.length; j++) {
            System.out.print(finals1[j]);
            if(z>1){
                System.out.print(",");
                z--;
            }
        }
        System.out.print("}");
        System.out.println();
    }
    public static String[]separarcadenas(String cadena){
        int cont = 1;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ',') {
                cont++;
            }
        }

        String[]arregloPalabras=new String[cont];
        int inicioPalabra = 0;
        int finPalabra = 0;
        int i = 0;
        while (i < cont) {
            while (finPalabra < cadena.length() && cadena.charAt(finPalabra) != ',') {
                finPalabra++;
            }
            arregloPalabras[i] = cadena.substring(inicioPalabra, finPalabra);
            inicioPalabra = finPalabra + 1;
            finPalabra = inicioPalabra;
            i++;
        }
        return arregloPalabras;
    }
}
