package servlet;

import dao.ReportDao;
import entity.Report;
import impl.ReportDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonValueProcessor;
import net.sf.json.processors.JsonValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@WebServlet("/ShowReportServlet")
public class ShowReportServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ReportDao dao = new ReportDaoImpl();
    //显示被举报的信息
    List<Report> reports = dao.showReport();
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());
    JSONArray jsonArray = JSONArray.fromObject(reports,jsonConfig);
    PrintWriter out = response.getWriter();
    out.print(jsonArray);
    out.close();
    out.flush();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
