package dao;

import entity.Report;
import entity.UserInfo;

import java.math.BigDecimal;
import java.util.List;

public interface ReportDao {
  //查询被举报的微博内容
  List<Report> showReport();

  //将report清零
  List<Report> CancelReport(BigDecimal BLOG_ID);
}
