package mx.edu.utez.controller;

import mx.edu.utez.model.cartas.BeanCartas;
import mx.edu.utez.model.cartas.DaoCartas;
import mx.edu.utez.model.tipo.BeanTipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletCartas", urlPatterns = {"/readCartas", "/createCartas", "/updateCartas", "deleteCartas"})
public class ServletCartas extends HttpServlet {
    private Map map = new HashMap();
    final private Logger CONSOLE = LoggerFactory.getLogger(ServletCartas.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        BeanCartas beanCartas = new BeanCartas();
        BeanTipo beanTipo = new BeanTipo();
        DaoCartas daoCartas = new DaoCartas();

        switch(action){
            case "create":

                beanTipo.setIdTipo(Integer.parseInt(request.getParameter("idTipo")));

                beanCartas.setName(request.getParameter("name"));
                beanCartas.setFechaDeRegistro(request.getParameter("date"));
                beanCartas.setTipo_idTipo(beanTipo);
                boolean flag = daoCartas.create(beanCartas);

                if(flag){
                    map.put("message", "Se ha registrado correctamente.");
                } else {
                    map.put("message", "No se registró correctamente.");
                }
                break;
            case "update":
                beanTipo.setIdTipo(Integer.parseInt(request.getParameter("idTipo")));

                beanCartas.setIdCartas(Integer.parseInt(request.getParameter("idCartas")));
                beanCartas.setName(request.getParameter("name"));
                beanCartas.setFechaDeRegistro(request.getParameter("date"));
                beanCartas.setTipo_idTipo(beanTipo);
                boolean flag1 = daoCartas.update(beanCartas);

                if(flag1){
                    map.put("message", "Se ha actualizado correctamente.");
                } else {
                    map.put("message", "No se actualizó correctamente.");
                }
                break;
            case "delete":
                if(new DaoCartas().delete(Integer.parseInt(request.getParameter("idCartas")))){
                    request.setAttribute("message", "Se ha eliminado correctamente.");
                } else {
                    CONSOLE.error("No se eliminó correctamente.");
                }
                break;
            default:
                request.getRequestDispatcher("/").forward(request, response);
                break;
        }

        response.sendRedirect(request.getContextPath() + "/readCartas");
    }
}
