package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static conexion.ConexionDB.connection;
import static conexion.ConexionDB.statement;

public class Equipo {

    private String nombre;
    private String titulares;
    private Integer suplentes;
    private String directorTecnico;
    private Integer puntos;
    private Integer partidosJugados;

    public Equipo() {
    }

    public Equipo(String nombre, String titulares, Integer suplentes, String directorTecnico, Integer puntos, Integer partidosJugados) {
        this.nombre = nombre;
        this.titulares = titulares;
        this.suplentes = suplentes;
        this.directorTecnico = directorTecnico;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
    }



    public static void mostrarTodo(){

        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM equipos_argentina");
            System.out.println("resultSet:"+ resultSet);
            System.out.println("id" + "|" + "nombre"+
                    "|" + "titulares" + "|" + "suplentes" + "|"
                    + "director" + "|" + "puntos" +
                    "|" + "partidos jugados");

            while(resultSet.next()){

                System.out.println(resultSet.getString("id") + "| " + resultSet.getString("nombre")+
                        "|   " + resultSet.getString("titulares") + "|   " + resultSet.getString("suplentes") + " |     "
                        + resultSet.getString("director_tecnico") + "   |     " + resultSet.getString("puntos") +
                        "   |     " + resultSet.getString("partidos_jugados"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public static void mostrarEquipo(String nombre) {

        try {
            PreparedStatement parametro = null;
            String sql = "SELECT * FROM equipos_argentina WHERE nombre = ?";
            parametro = connection.prepareStatement(sql);
            parametro.setString(1,nombre);
            ResultSet result = parametro.executeQuery();


            if(result.next()){

                System.out.println("id" + "|" + "nombre" +
                                "|" + "titulares" + "|" + "suplentes" + "|"
                                + "director" + "|" + "puntos" +
                                "|" + "partidos jugados");
                System.out.println(result.getString("id") + " |" + result.getString("nombre")+
                            "|  " + result.getString("titulares") + "    |    " + result.getString("suplentes") + "  |  "
                            + result.getString("director_tecnico") + " |   " + result.getString("puntos") +
                            "|   " + result.getString("partidos_jugados"));

            } else{
                System.out.println("No existe el equipo, consulte la lista con la opcion 1");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }
}
