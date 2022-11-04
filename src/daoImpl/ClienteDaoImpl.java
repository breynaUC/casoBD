
package daoImpl;
import config.Conexion;
import dao.Operaciones;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;

/**
 *
 * @author admin
 */
public class ClienteDaoImpl implements Operaciones<Cliente>{
    private Connection cx;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public int create(Cliente t) {
        String SQL = "insert into cliente (nombre,apellido1,apellido2,ciudad,categoria) values("
                + " ?,?,?,?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellido1());
            ps.setString(3, t.getApellido2());
            ps.setString(4, t.getCiudad());
            ps.setInt(5, t.getCategoria());
            x = ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Cliente t) {
       String SQL = " update cliente set nombre=?, apellido1=?, apellido2=?, ciudad=?, categoria=? where id=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellido1());
            ps.setString(3, t.getApellido2());
            ps.setString(4, t.getCiudad());
            ps.setInt(5, t.getCategoria());
            ps.setInt(6, t.getId());
            x = ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "delete from cliente where id=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Cliente read(int id) {
        Cliente c = new Cliente();
        String SQL = "select *from cliente where id=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
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
        String SQL = "select *from cliente";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
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
