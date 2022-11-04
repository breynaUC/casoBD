package daoImpl;

import config.Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import dao.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Cliente;

/**
 *
 * @author admin
 */
public class ClienteDaoImpl2 implements Operaciones<Cliente>{
    private CallableStatement cstmt;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Cliente t) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cstmt = cx.prepareCall("{call sp_insertar_cliente(?,?,?,?,?)}");
            cstmt.setString(1, t.getNombre());
            cstmt.setString(2, t.getApellido1());
            cstmt.setString(3, t.getApellido2());
            cstmt.setString(4, t.getCiudad());
            cstmt.setInt(5, t.getCategoria());
            x = cstmt.executeUpdate();

        } catch (SQLException e) {
        }
        return x;
    }

    @Override
    public int update(Cliente t) { 
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cstmt = cx.prepareCall("{call sp_modificar_cliente(?,?,?,?,?,?)}");
            cstmt.setString(1, t.getNombre());
            cstmt.setString(2, t.getApellido1());
            cstmt.setString(3, t.getApellido2());
            cstmt.setString(4, t.getCiudad());
            cstmt.setInt(5, t.getCategoria());
            cstmt.setInt(6, t.getId());
            x = cstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cstmt = cx.prepareCall("{call sp_eliminar_cliente(?)}");
            cstmt.setInt(1, id);
            x = cstmt.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Cliente read(int id) {
       Cliente c = new Cliente();
        try {
            cx = Conexion.getConexion();
            cstmt = cx.prepareCall("{call sp_listar_cliente(?)}");
            cstmt.setInt(1, id);
            rs = cstmt.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));
                c.setApellido2(rs.getString("apellido2"));
                c.setCiudad(rs.getString("ciudad"));
                c.setCategoria(rs.getInt("categoria"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return c;
    }

    @Override
    public List<Cliente> readAll() {
        List<Cliente> lista = new ArrayList<>();        
        try {
            cx = Conexion.getConexion();
            cstmt = cx.prepareCall("{call sp_listar_clientes()}");
            rs = cstmt.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));
                c.setApellido2(rs.getString("apellido2"));
                c.setCiudad(rs.getString("ciudad"));
                c.setCategoria(rs.getInt("categoria"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }

    @Override
    public List<Map<String, Object>> readAll2(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
