package com.example.data.model;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {

       Scanner sn = new Scanner(System.in);

       //Variables a utilizar
       boolean salir = false;
       int opcion = 0, tipo1, tipo2, tipo3, tipo4, num_tipos;

       //Menu
       do {

           System.out.println("Programa para folagor03");
           System.out.println("1. Mostrar debilidades");
           System.out.println("2. Mostrar eficacias");
           System.out.println("3. Mostrar toda la informacion de un tipo");
           System.out.println("4. Eficacia de un tipo a otro");
           System.out.println("5. Salir");
           System.out.println("6. Nueva");
           System.out.println("Elije una opción");
           opcion = sn.nextInt();

           switch (opcion) {

               case 1:

                   //Pedimos el numero de tipos y validamos, solo 1 o 2 tipos
                   do {

                       System.out.println("Elije el numero de tipos, solo 1 o 2");
                       num_tipos = sn.nextInt();

                       if (!(num_tipos == 1 || num_tipos == 2)) {
                           System.out.println("Tienes que introducir 1 o 2");
                       }

                   } while (!(num_tipos == 1 || num_tipos == 2));

                   //elegimos el primer tipo
                   System.out.println("Primer tipo del pokemon");
                   tipo1 = elegirTipo(sn);

                   if (num_tipos == 2) {

                       //Si elegimos 2 tipos, aqui elegimos el 2º tipo
                       //Validamos para que no se repita, no existe el tipo FUEGO FUEGO por ejemplo
                       do {

                           System.out.println("Segundo tipo del pokemon");
                           tipo2 = elegirTipo(sn);
                           if (tipo2 == tipo1) {
                               System.out.println("Los tipos no deben ser iguales");
                           }

                       } while (tipo2 == tipo1);

                       //Mostramos las debilidades de los dos tipos
                       mostrarDebilidades(tipo1, tipo2);

                   } else {

                       //Mostramos las debilidades de los tipos
                       mostrarDebilidades(tipo1);
                   }

                   break;
               case 2:

                   //elegimos el primer y único tipo
                   System.out.println("Tipo del pokemon atacante");
                   tipo1 = elegirTipo(sn);

                   //Mostramos las eficacias
                   mostrarEficaces(tipo1);

                   break;
               case 3:

                   //elegimos el primer y único tipo
                   System.out.println("Tipo del pokemon atacante");
                   tipo1 = elegirTipo(sn);

                   //Mostramos la información respecto al tipo
                   mostrarInfo(tipo1);

                   break;
               case 4:

                   //Pedimos si queremos uno o dos tipos y validamos
                   do {

                       System.out.println("Elije el numero de tipos del oponente, solo 1 o 2");
                       num_tipos = sn.nextInt();

                       if (!(num_tipos == 1 || num_tipos == 2)) {
                           System.out.println("Tienes que introducir 1 o 2");
                       }

                   } while (!(num_tipos == 1 || num_tipos == 2));

                   System.out.println("Pokemon atacante");
                   tipo1 = elegirTipo(sn);

                   System.out.println("Primer tipo del pokemon oponente");
                   tipo2 = elegirTipo(sn);

                   if (num_tipos == 2) {

                       do {

                           System.out.println("Segundo tipo del pokemon oponente");
                           tipo3 = elegirTipo(sn);
                           if (tipo3 == tipo2) {
                               System.out.println("Los tipos no deben ser iguales");
                           }

                       } while (tipo2 == tipo3);

                       mostrarEficaciaTipo(tipo1, tipo2, tipo3);
                   } else {
                       mostrarEficaciaTipo(tipo1, tipo2);
                   }
                   break;

               case 5:
                   salir = true;
                   break;
               case 6:
            	   System.out.println("Primer tipo del pokemon atacante");
                   tipo1 = elegirTipo(sn);
                   
                   do {

                       System.out.println("Segundo tipo del pokemon atacante");
                       tipo2 = elegirTipo(sn);
                       if (tipo1 == tipo2) {
                           System.out.println("Los tipos no deben ser iguales");
                       }

                   } while (tipo1 == tipo2);
                   
                   System.out.println("Primer tipo del pokemon defensor");
                   tipo3 = elegirTipo(sn);
                   
                   do {

                       System.out.println("Segundo tipo del pokemon defensor");
                       tipo4 = elegirTipo(sn);
                       if (tipo3 == tipo4) {
                           System.out.println("Los tipos no deben ser iguales");
                       }

                   } while (tipo3 == tipo4);
                   
            	   mostrarEficaciaTipo(tipo1, tipo2, tipo3, tipo4);
               default:

           }

       } while (!salir);

   }

   /**
    * Listamos los tipos de pokemon que hay
    */
   private static void listarTipos() {

       for (int i = 0; i < Tabla.tiposPokemon.length; i++) {
           System.out.println(i + ". " + Tabla.tiposPokemon[i]);
       }

   }

   /**
    * Elegimos el tipo de pokemon que queremos
    *
    * @param sn
    * @return indice del tipo de pokemon que usaremos
    */
   public static int elegirTipo(Scanner sn) {

       int eleccion;
       listarTipos();

       do {
           eleccion = sn.nextInt();

           if (!(eleccion >= 0 && eleccion < Tabla.tiposPokemon.length)) {
               System.out.println("Tiene que estar entre 0 y 17");
           }

       } while (!(eleccion >= 0 && eleccion < Tabla.tiposPokemon.length));

       return eleccion;

   }

   /**
    * Muestra todas las debilidades del tipo pasado
    *
    * @param tipo
    */
   public static void mostrarDebilidades(int tipo) {

       for (int i = 0; i < Tabla.efectividadesPokemon.length; i++) {

           if (Tabla.efectividadesPokemon[i][tipo] == Tabla.EFICACIA_EME) {
               System.out.println("- " + Tabla.tiposPokemon[i]);
           }

       }

   }

   /**
    * Muestra todas las debilidades comunes de los tipos pasados
    *
    * @param tipo1
    * @param tipo2
    */
   public static void mostrarDebilidades(int tipo1, int tipo2) {

       double efectividadFinal = 0;

       for (int i = 0; i < Tabla.efectividadesPokemon.length; i++) {

           efectividadFinal = Tabla.efectividadesPokemon[i][tipo1] * Tabla.efectividadesPokemon[i][tipo2];

           if (efectividadFinal >= Tabla.EFICACIA_EME) {
               System.out.println("- " + Tabla.tiposPokemon[i] + ": x" + (int) efectividadFinal);
           }

       }

   }

   /**
    * Muestra las eficacias del tipo pasado
    *
    * @param tipo
    */
   public static void mostrarEficaces(int tipo) {

       for (int j = 0; j < Tabla.efectividadesPokemon.length; j++) {

           if (Tabla.efectividadesPokemon[tipo][j] == Tabla.EFICACIA_EME) {
               System.out.println("- " + Tabla.tiposPokemon[j]);
           }

       }

   }

   /**
    * Muestra la informacion del tipo pasado
    *
    * @param tipo
    */
   public static void mostrarInfo(int tipo) {

       for (int j = 0; j < Tabla.efectividadesPokemon.length; j++) {
           System.out.println("- " + Tabla.tiposPokemon[j] + " " + mostrarEficacia(Tabla.efectividadesPokemon[tipo][j]));
       }

   }

   /**
    * Muestra el mensaje asociado a la eficacia
    *
    * @param eficacia
    * @return
    */
   public static String mostrarEficacia(double eficacia) {

       String mensaje;

       if (eficacia == Tabla.EFICACIA_DE) {
           mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_DE];
       } else if (eficacia == Tabla.EFICACIA_EME) {
           mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_EME];
       } else if (eficacia == Tabla.EFICACIA_NEUTRO) {
           mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_NEUTRO];
       } else if (eficacia == Tabla.EFICACIA_NME) {
           mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_NME];
       } else if (eficacia == Tabla.EFICACIA_DNE) {
           mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_DNE];
       } else {
           mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_NA];
       }

       return mensaje;

   }

   /**
    * Muestra la eficacia (con palabras) de un tipo a otro tipo
    *
    * @param tipoAtacante
    * @param tipoOponente
    */
   public static void mostrarEficaciaTipo(int tipoAtacante, int tipoOponente) {
	   System.out.println(Tabla.efectividadesPokemon[tipoAtacante][tipoOponente]);
       System.out.println(mostrarEficacia(Tabla.efectividadesPokemon[tipoAtacante][tipoOponente]));
   }

   /**
    * Muestra la eficacia (con palabras) de un tipo a un pokemon con dos tipos
    *
    * @param tipoAtacante
    * @param tipo1Oponente
    * @param tipo2Oponente
    */
   public static void mostrarEficaciaTipo(int tipoAtacante, int tipo1Oponente, int tipo2Oponente) {
       //multiplico las efectivadades
       double efectividad = Tabla.efectividadesPokemon[tipoAtacante][tipo1Oponente] * Tabla.efectividadesPokemon[tipoAtacante][tipo2Oponente];
       System.out.println(efectividad);
       System.out.println(mostrarEficacia(efectividad));
   }
   
   /**
    * Muestra la eficacia (con palabras) de un pokemon con dos tipos a un pokemon con dos tipos
    *
    * @param tipo1Atacante
    * @param tipo2Atacante
    * @param tipo1Oponente
    * @param tipo2Oponente
    */
   public static void mostrarEficaciaTipo(int tipo1Atacante, int tipo2Atacante, int tipo1Oponente, int tipo2Oponente) {
       //multiplico las efectivadades
       double efectividad1 = Tabla.efectividadesPokemon[tipo1Atacante][tipo1Oponente] * Tabla.efectividadesPokemon[tipo1Atacante][tipo2Oponente];
       double efectividad2 = Tabla.efectividadesPokemon[tipo2Atacante][tipo1Oponente] * Tabla.efectividadesPokemon[tipo2Atacante][tipo2Oponente];
       double efectividad = efectividad1*efectividad2;
       System.out.println(Tabla.efectividadesPokemon[tipo1Atacante][tipo1Oponente] + "  " + Tabla.efectividadesPokemon[tipo1Atacante][tipo2Oponente]);
       System.out.println(Tabla.efectividadesPokemon[tipo2Atacante][tipo1Oponente] + "  " + Tabla.efectividadesPokemon[tipo2Atacante][tipo2Oponente]);
       System.out.println(efectividad1 + "   " + efectividad2  + "   " + efectividad);
       System.out.println(mostrarEficacia(efectividad));
   }

}
