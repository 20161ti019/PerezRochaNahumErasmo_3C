package mx.edu.utez.model.cartas;

import mx.edu.utez.model.tipo.BeanTipo;
import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class DaoCartas {
    private Connection con;
    private CallableStatement cstm;
    private ResultSet rs;
    final private Logger CONSOLE = LoggerFactory.getLogger(DaoCartas.class);

    public List<BeanCartas> findAll() {
        List<BeanCartas> listCartas = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM catalogo;");
            rs = cstm.executeQuery();

            while (rs.next()) {
                BeanTipo beanTipo = new BeanTipo();
                BeanCartas beanCartas = new BeanCartas();

                beanTipo.setIdTipo(rs.getInt("idTipo"));
                beanTipo.setNameTipo(rs.getString("nameTipo"));

                beanCartas.setIdCartas(rs.getInt("id"));
                beanCartas.setName(rs.getString("name"));
                beanCartas.setFechaDeRegistro(rs.getString("fechaDeRegistro"));
                beanCartas.setStatus(rs.getInt("status"));
                beanCartas.setTipo_idTipo(beanTipo);

                listCartas.add(beanCartas);
            }
        } catch (SQLException e) {
            CONSOLE.error("Ha ocurrido algún error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listCartas;
    }


    public boolean create(BeanCartas cartas) {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{INSERT INTO `catalogo` (`name`, `tipo_idTipo`, `fechaDeRegistro`, `status`) VALUES ('?', '?', '?', '?');}");
            cstm.setString(1, cartas.getName());
            cstm.setInt(2, cartas.getTipo_idTipo().getIdTipo());
            cstm.setString(3, cartas.getFechaDeRegistro());
            cstm.setInt(6, cartas.getStatus());
            cstm.execute();
            flag = true;
        } catch (SQLException e) {
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanCartas cartas) {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{UPDATE `catalogo` SET `name` = '?', `tipo_idTipo` = '?', `fechaDeRegistro` = '?' WHERE `catalogo`.`id` = '?';}");
            cstm.setString(1, cartas.getName());
            cstm.setInt(2, cartas.getTipo_idTipo().getIdTipo());
            cstm.setString(3, cartas.getFechaDeRegistro());
            cstm.setInt(4, cartas.getIdCartas());
            cstm.execute();
            flag = true;
        } catch (SQLException e) {
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(int id) {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{DELETE FROM `catalogo` WHERE `catalogo`.`id` = ?}");
            cstm.setInt(1, id);

            flag = cstm.execute();
        } catch (SQLException e) {
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return false;
    }


    public static void main(String[] args) {
        BeanCartas beanCartas = new BeanCartas();
        BeanTipo beanTipo = new BeanTipo();
        DaoCartas daoCartas = new DaoCartas();


        List<BeanCartas> listCartas = new ArrayList<>();
        listCartas = daoCartas.findAll();

        for (int i = 0; i < listCartas.size(); i++) {
            System.out.println(listCartas.get(i).getName());
        }
    }
}