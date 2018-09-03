package servlet;

import dao.UserInfoDao;
import entity.UserInfo;
import impl.UserInfoDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    UserInfoDao dao = new UserInfoDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //查询个人信息
        List<UserInfo> list = dao.showAllUser(73);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray array = JSONArray.fromObject(list,jsonConfig);
        PrintWriter out =response.getWriter();
        out.print(array);
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
