package Backend.servlet;

import Backend.db.MySQLDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.runoob.db.*;
/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用 GBK 设置中文正常显示
        response.setCharacterEncoding("GBK");
        String x=request.getParameter("operation");
        MySQLDemo mysql=new MySQLDemo();
        mysql.open();
        String index= request.getParameterValues("index")[0];
        if (x.equals("1")) {
        	mysql.update("state", "封号中","iduser",index );
        }else if(x.equals("2")) {
        	mysql.update("state", "已删除","iduser",index );
        }else  {
        	mysql.update("state", "正常","iduser",index);
        }
        mysql.close();
        request.getRequestDispatcher("backend.jsp").forward(request, response);
//        request.getRequestDispatcher("NewFile5.jsp").forward(request,response); 
//        response.sendRedirect("NewFile.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}