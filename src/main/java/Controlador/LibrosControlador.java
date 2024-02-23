/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Libros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Belial
 */
public class LibrosControlador {
    
    
    
     private Libros libros;
    Controlador conectar = new Controlador();
    Connection conectado = (Connection) conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public LibrosControlador(Libros libros) {
        this.libros = libros;
    }

    public LibrosControlador() {
    }

    
    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }
    
    
  
    
    
     public ArrayList<Object[]> datosLibros() {
        ArrayList<Object[]> listaTotalLibros = new ArrayList<>();
        try {

            String SQL = "CALL VerTodosLosLibros();";
            ejecutar = (PreparedStatement) conectado.prepareCall(SQL);
            ResultSet res = ejecutar.executeQuery();
            //int cont = 1;

            while (res.next()) {

                Object[] fila = new Object[11];
                for (int i = 0; i < 11; i++) {
                    fila[i] = res.getObject(i + 1);

                }
                //fila[0] = cont;
                listaTotalLibros.add(fila);
                //cont++;
            }

            ejecutar.close();
            return listaTotalLibros;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }
    
    
    
}
