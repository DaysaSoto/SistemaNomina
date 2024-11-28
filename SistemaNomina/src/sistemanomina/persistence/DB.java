package sistemanomina.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistemanomina.application.app;

/**
 *
 * @author Francis Leantony
 */
public class DB {
    public Connection conn = null;
    public Statement stm;
    public ResultSet resultado;
    
    app App = new app();
    
    public void DBConn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sistemanomina?" +
                                       "user=root&password=");
            stm = conn.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al conectar con la base de datos\n " + e.getMessage());
        }
    }
    
    public void DBClose() throws SQLException{
        conn.close();
    }
    
    public void insertEmpleadoAsalariado(String nombre, String apellido, String NoSocial, float Salario) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/sistemanomina";  // URL de la base de datos
        String usuario = "root";   // Usuario de la base de datos
        String contrasena = ""; // Contraseña de la base de datos
        
            String sql = "INSERT INTO empleadoasalariado (nombre, apellido, nosegurosocial, salariosemanal) VALUES (?, ?, ?, ?)";
       
            try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, nombre);
                stmt.setString(2, apellido);
                stmt.setString(3, NoSocial);
                stmt.setFloat(4, Salario);

                int filasAfectadas = stmt.executeUpdate();

               System.out.println(filasAfectadas + " fila(s) insertada(s).");
            } catch (SQLException e) {
                e.printStackTrace();  // En caso de error, mostramos el stack trace
            }

    }
    public void insertEmpleadoHora(String apellido, String NoSocial, float SueldoHora, float HorasTrabajadas) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/sistemanomina";  // URL de la base de datos
        String usuario = "root";   // Usuario de la base de datos
        String contrasena = ""; // Contraseña de la base de datos
        
        String sql = "INSERT INTO empleadohora (apellido, nosegurosocial, sueldoporhora, horastrabajadas) VALUES (?, ?, ?, ?)";
       
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
        PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, apellido);
        stmt.setString(2, NoSocial);
        stmt.setFloat(3, SueldoHora);
        stmt.setFloat(4, HorasTrabajadas);

        int filasAfectadas = stmt.executeUpdate();

        System.out.println(filasAfectadas + " fila(s) insertada(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }
    
    public void insertEmpleadoComision(String nombre, String apellido, String NoSocial, float VentaBruta, float Tarifa) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/sistemanomina";  // URL de la base de datos
        String usuario = "root";   // Usuario de la base de datos
        String contrasena = ""; // Contraseña de la base de datos
        
        String sql = "INSERT INTO empleadocomision (nombre, apellido, nosegurosocial, ventabruta, tarifa) VALUES (?, ?, ?, ?, ?)";
       
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
        PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, NoSocial);
        stmt.setFloat(4, VentaBruta);
        stmt.setFloat(5, Tarifa);

        int filasAfectadas = stmt.executeUpdate();

        System.out.println(filasAfectadas + " fila(s) insertada(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }
    
        public void insertEmpleadoComisionSalario(String nombre, String apellido, String NoSocial, float VentaBruta, float Tarifa, float Salario) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/sistemanomina";  // URL de la base de datos
        String usuario = "root";   // Usuario de la base de datos
        String contrasena = ""; // Contraseña de la base de datos
        
        String sql = "INSERT INTO empleadocomisionsalario (nombre, apellido, nosegurosocial, ventabruta, tarifa, salariobase) VALUES (?, ?, ?, ?, ?, ?)";
       
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
        PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, NoSocial);
        stmt.setFloat(4, VentaBruta);
        stmt.setFloat(5, Tarifa);
        stmt.setFloat(6, Salario);
        

        int filasAfectadas = stmt.executeUpdate();

        System.out.println(filasAfectadas + " fila(s) insertada(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }
    
    
    public void modifyEmpleadoAsalariado(int id, String nombre, String apellido, String NoSocial, float Salario) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sistemanomina";  
    String usuario = "root";   
    String contrasena = "";

        String selectSql = "SELECT nombre, apellido, nosegurosocial, salariosemanal FROM empleadoasalariado WHERE id = ?";
        String updateSql = "UPDATE empleadoasalariado SET nombre = ?, apellido = ?, nosegurosocial = ?, salariosemanal = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            selectStmt.setInt(1, id);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String currentNombre = rs.getString("nombre");
                String currentApellido = rs.getString("apellido");
                String currentNoSocial = rs.getString("nosegurosocial");
                float currentSalario = rs.getFloat("salariosemanal");

                nombre = (nombre == null || nombre.isEmpty()) ? currentNombre : nombre;
                apellido = (apellido == null || apellido.isEmpty()) ? currentApellido : apellido;
                NoSocial = (NoSocial == null || NoSocial.isEmpty()) ? currentNoSocial : NoSocial;
                Salario = (Salario == 0) ? currentSalario : Salario;

                updateStmt.setString(1, nombre);
                updateStmt.setString(2, apellido);
                updateStmt.setString(3, NoSocial);
                updateStmt.setFloat(4, Salario);
                updateStmt.setInt(5, id);

                int filasAfectadas = updateStmt.executeUpdate();
                System.out.println(filasAfectadas + " fila(s) actualizada(s).");
            } else {
                System.out.println("No se encontró un empleado con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
}
    
       public void modifyEmpleadoHora(int id, String apellido, String NoSocial, float SueldoHora, float HoraTrabajada) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sistemanomina";  
    String usuario = "root";   
    String contrasena = "";

        String selectSql = "SELECT apellido, nosegurosocial, sueldoporhora, horastrabajadas FROM empleadohora WHERE id = ?";
        String updateSql = "UPDATE empleadohora SET apellido = ?, nosegurosocial = ?, sueldoporhora = ?, horastrabajadas = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            selectStmt.setInt(1, id);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String currentApellido = rs.getString("apellido");
                String currentNoSocial = rs.getString("nosegurosocial");
                float currentSueldoPorHora = rs.getFloat("sueldoporhora");
                float currenthorastrabajadas = rs.getFloat("horastrabajadas");

                apellido = (apellido == null || apellido.isEmpty()) ? currentApellido : apellido;
                NoSocial = (NoSocial == null || NoSocial.isEmpty()) ? currentNoSocial : NoSocial;
                SueldoHora = (SueldoHora == 0) ? currentSueldoPorHora : SueldoHora;
                HoraTrabajada = (HoraTrabajada == 0) ? currenthorastrabajadas : HoraTrabajada;

                updateStmt.setString(1, apellido);
                updateStmt.setString(2, NoSocial);
                updateStmt.setFloat(3, SueldoHora);
                updateStmt.setFloat(4, HoraTrabajada);
                updateStmt.setInt(5, id);

                int filasAfectadas = updateStmt.executeUpdate();
                System.out.println(filasAfectadas + " fila(s) actualizada(s).");
            } else {
                System.out.println("No se encontró un empleado con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
} 
       
       
    public void modifyEmpleadoComision(int id, String nombre, String apellido, String NoSocial, float VentaBruta, float Tarifa) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sistemanomina";  
    String usuario = "root";   
    String contrasena = "";

        String selectSql = "SELECT nombre, apellido, nosegurosocial, ventabruta, tarifa FROM empleadocomision WHERE id = ?";
        String updateSql = "UPDATE empleadocomision SET nombre = ?, apellido = ?, nosegurosocial = ?, ventabruta = ?, tarifa = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            selectStmt.setInt(1, id);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String currentNombre = rs.getString("nombre");
                String currentApellido = rs.getString("apellido");
                String currentNoSocial = rs.getString("nosegurosocial");
                float currentVentaBruta = rs.getFloat("ventabruta");
                float currentTarifa = rs.getFloat("tarifa");

                nombre = (nombre == null || nombre.isEmpty()) ? currentNombre : nombre;
                apellido = (apellido == null || apellido.isEmpty()) ? currentApellido : apellido;
                NoSocial = (NoSocial == null || NoSocial.isEmpty()) ? currentNoSocial : NoSocial;
                VentaBruta = (VentaBruta == 0) ? currentVentaBruta : VentaBruta;
                Tarifa = (Tarifa == 0) ? currentTarifa : Tarifa;

                updateStmt.setString(1, nombre);
                updateStmt.setString(2, apellido);
                updateStmt.setString(3, NoSocial);
                updateStmt.setFloat(4, VentaBruta);
                updateStmt.setFloat(5, Tarifa);
                updateStmt.setInt(6, id);

                int filasAfectadas = updateStmt.executeUpdate();
                System.out.println(filasAfectadas + " fila(s) actualizada(s).");
            } else {
                System.out.println("No se encontró un empleado con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
} 
    
        public void modifyEmpleadoComisionSalario(int id, String nombre, String apellido, String NoSocial, float VentaBruta, float Tarifa, float Salario) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sistemanomina";  
    String usuario = "root";   
    String contrasena = "";

        String selectSql = "SELECT nombre, apellido, nosegurosocial, ventabruta, tarifa, salariobase FROM empleadocomisionsalario WHERE id = ?";
        String updateSql = "UPDATE empleadocomisionsalario SET nombre = ?, apellido = ?, nosegurosocial = ?, ventabruta = ?, tarifa = ?, salariobase = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            selectStmt.setInt(1, id);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String currentNombre = rs.getString("nombre");
                String currentApellido = rs.getString("apellido");
                String currentNoSocial = rs.getString("nosegurosocial");
                float currentVentaBruta = rs.getFloat("ventabruta");
                float currentTarifa = rs.getFloat("tarifa");
                float currentSalario = rs.getFloat("salariobase");

                nombre = (nombre == null || nombre.isEmpty()) ? currentNombre : nombre;
                apellido = (apellido == null || apellido.isEmpty()) ? currentApellido : apellido;
                NoSocial = (NoSocial == null || NoSocial.isEmpty()) ? currentNoSocial : NoSocial;
                VentaBruta = (VentaBruta == 0) ? currentVentaBruta : VentaBruta;
                Tarifa = (Tarifa == 0) ? currentTarifa : Tarifa;
                Salario = (Salario == 0) ? currentSalario : Salario;

                updateStmt.setString(1, nombre);
                updateStmt.setString(2, apellido);
                updateStmt.setString(3, NoSocial);
                updateStmt.setFloat(4, VentaBruta);
                updateStmt.setFloat(5, Tarifa);
                updateStmt.setFloat(6, Salario);
                updateStmt.setInt(7, id);

                int filasAfectadas = updateStmt.executeUpdate();
                System.out.println(filasAfectadas + " fila(s) actualizada(s).");
            } else {
                System.out.println("No se encontró un empleado con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
} 
    
    
   
    public void deleteEmpleado(String tabla, int id) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sistemanomina"; 
    String usuario = "root"; 
    String contrasena = ""; 

    String sql = "DELETE FROM "+ tabla +" WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);

        int filasAfectadas = stmt.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Empleado con ID " + id + " eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un empleado con el ID " + id + ".");
        }

    } catch (SQLException e) {
        System.err.println("Error al eliminar el empleado: " + e.getMessage());
        e.printStackTrace();
    }
}
    
    public void actualizarTablaEmpleadoAsalariado(JTable tabla) {
        String url = "jdbc:mysql://localhost:3306/sistemanomina"; 
        String usuario = "root"; 
        String contrasena = ""; 
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        String consultaSQL = "SELECT id, nombre, apellido, nosegurosocial, salariosemanal FROM empleadoasalariado";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consultaSQL)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String noSocial = rs.getString("nosegurosocial");
                double salario = rs.getDouble("salariosemanal");

                modelo.addRow(new Object[]{id,nombre, apellido, noSocial, salario});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la tabla: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarTablaEmpleadoHora(JTable tabla) {
        String url = "jdbc:mysql://localhost:3306/sistemanomina"; 
        String usuario = "root"; 
        String contrasena = ""; 
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        String consultaSQL = "SELECT id, apellido, nosegurosocial, sueldoporhora, horastrabajadas FROM empleadohora";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consultaSQL)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String apellido = rs.getString("apellido");
                String noSocial = rs.getString("nosegurosocial");
                double sueldoporhora = rs.getDouble("sueldoporhora");
                double horastrabajadas = rs.getDouble("horastrabajadas");
                double total = 0;
                total = App.CalcularEmpleadoHoras(horastrabajadas, sueldoporhora);

                modelo.addRow(new Object[]{id,apellido, noSocial, sueldoporhora, horastrabajadas, total});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la tabla: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarTablaEmpleadoComision(JTable tabla) {
        String url = "jdbc:mysql://localhost:3306/sistemanomina"; 
        String usuario = "root"; 
        String contrasena = ""; 
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        String consultaSQL = "SELECT id, nombre, apellido, nosegurosocial, ventabruta, tarifa FROM empleadocomision";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consultaSQL)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String noSocial = rs.getString("nosegurosocial");
                double ventabruta = rs.getDouble("ventabruta");
                double tarifa = rs.getDouble("tarifa");
                double total = App.CalcularEmpleadoComision(ventabruta, tarifa);

                modelo.addRow(new Object[]{id,nombre, apellido, noSocial, ventabruta, tarifa, total});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la tabla: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarTablaEmpleadoComisionSalario(JTable tabla) {
        String url = "jdbc:mysql://localhost:3306/sistemanomina"; 
        String usuario = "root"; 
        String contrasena = ""; 
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        String consultaSQL = "SELECT id, nombre, apellido, nosegurosocial, ventabruta, tarifa, salariobase FROM empleadocomisionsalario";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consultaSQL)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String noSocial = rs.getString("nosegurosocial");
                double ventabruta = rs.getDouble("ventabruta");
                double tarifa = rs.getDouble("tarifa");
                double salariobase = rs.getDouble("salariobase");
                double total = App.CalcularEmpleadoComisionSalario(ventabruta, tarifa, salariobase);

                modelo.addRow(new Object[]{id,nombre, apellido, noSocial, ventabruta, tarifa, salariobase, total});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la tabla: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
