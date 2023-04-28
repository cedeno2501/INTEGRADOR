package main;

import conexion.ConexionDB;
import service.Equipo;

import java.util.Scanner;

public interface Main {
    public static void main(String[] args) {

        ConexionDB.getConnection();

        Scanner scanner = new Scanner(System.in);
        Integer opcion=0;
        do{
            System.out.println("****MENU****");
            System.out.println("1 - Listar todos los equipos");
            System.out.println("2 - Mostrar un equipo");
            System.out.println("3 - Salir");
            System.out.println("Elija una opción:");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    Equipo.mostrarTodo();
                    break;

                case 2:
                    System.out.println("Escriba el nombre del equipo:");
                    String name = scanner.next();
                    Equipo.mostrarEquipo(name);
                    break;

                case 3:
                    break;
            }

        }while(!opcion.equals(3));
    }
}
