package dao;

import entity.UserInfo;
import entity.UserRel;
import entity.getCount;

import java.math.BigDecimal;
import java.util.List;

public interface UserRelDao {
    List<getCount> getCountFans(int i);
    List<getCount> getCountAttention(int i);
    List<getCount> getCountFansA(int i);
    List<getCount> getCountAttentionF(int i);
    List<getCount> getCountFansBlog(int i);
    List<getCount> getCountAttentionBlog(int i);
    int insertAttention(BigDecimal REL_ID, BigDecimal ATTENTION_ID);
    int deleteAttention(BigDecimal ATTENTION_ID);
}
