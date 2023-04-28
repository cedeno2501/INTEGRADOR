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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulares() {
        return titulares;
    }

    public void setTitulares(String titulares) {
        this.titulares = titulares;
    }

    public Integer getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(Integer suplentes) {
        this.suplentes = suplentes;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(Integer partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public static Integer mostrarTodo(){
        Integer contador=0;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM equipos_argentina");
            System.out.println("id" + "|" + "nombre"+
                    "|" + "titulares" + "|" + "suplentes" + "|"
                    + "director" + "|" + "puntos" +
                    "|" + "partidos jugados");
            while(resultSet.next()){
                contador++;
                System.out.println(resultSet.getString("id") + "| " + resultSet.getString("nombre")+
                        "|   " + resultSet.getString("titulares") + "|   " + resultSet.getString("suplentes") + " |     "
                        + resultSet.getString("director_tecnico") + "   |     " + resultSet.getString("puntos") +
                        "   |     " + resultSet.getString("partidos_jugados"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return contador;
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
                System.out.println("No existe el equipo en nuestra base");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }
}
