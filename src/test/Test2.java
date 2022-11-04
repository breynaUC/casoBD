/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import com.google.gson.Gson;
import daoImpl.ClienteDaoImpl2;
import model.Cliente;
import static test.Test.cdi;
import static test.Test.delete;
import static test.Test.gson;
import static test.Test.listar;

/**
 *
 * @author admin
 */
public class Test2 {
static ClienteDaoImpl2 cdi = new ClienteDaoImpl2();
  static Gson gson = new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        insertar();
        //update();
        //delete();
        //listar();
    }
    static void update(){
        System.out.println(cdi.create(new Cliente(11,"David","Reyna","Barreto","Lima",2)));
    }
    static void insertar(){
        System.out.println(cdi.create(new Cliente(0,"Ana","Ramos","Payala","Trujillo",2)));
    }
    
    static void listar(){
        System.out.println(gson.toJson(cdi.readAll()));
    }
    static void delete(){
        System.out.println(cdi.delete(12));
    }
}
