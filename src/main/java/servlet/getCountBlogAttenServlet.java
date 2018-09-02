package servlet;

import dao.UserRelDao;
import entity.getCount;
import impl.UserRelDapImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/getCountABlogServlet")
public class getCountBlogAttenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //BigDecimal userid = new BigDecimal(request.getParameter("USER_ID"));
        UserRelDao dao =new UserRelDapImpl();
        List<getCount> list=dao.getCountAttentionBlog(47);
        JSONArray array = JSONArray.fromObject(list);
        PrintWriter out=response.getWriter();
        out.print(array);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
