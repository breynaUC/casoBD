
package test;

import com.google.gson.Gson;
import daoImpl.ClienteDaoImpl;
import model.Cliente;

/**
 *
 * @author admin
 */
public class Test {
  static ClienteDaoImpl cdi = new ClienteDaoImpl();
  static Gson gson = new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        //insertar();
        //update();
        delete();
        listar();
    }
    static void update(){
        System.out.println(cdi.create(new Cliente(11,"David","Reyna","Barreto","Lima",2)));
    }
    static void insertar(){
        System.out.println(cdi.create(new Cliente(0,"Jose","Aranda","Ayala","Tacna",3)));
    }
    
    static void listar(){
        System.out.println(gson.toJson(cdi.readAll()));
    }
    static void delete(){
        System.out.println(cdi.delete(12));
    }
}
