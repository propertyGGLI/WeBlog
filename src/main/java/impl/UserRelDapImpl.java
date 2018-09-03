package impl;

import dao.UserRelDao;
import entity.UserInfo;
import entity.UserRel;
import entity.getCount;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class UserRelDapImpl extends BaseDao<getCount> implements UserRelDao {
    //粉丝的粉丝数量
    public List<getCount> getCountFans(int i){
        return executeQuery("select attention_id,count(*) as COUNT from User_rel where attention_id in(select fans_id from user_rel where attention_id=?)group by attention_id order by attention_id asc", new Object[]{i});
    }
    //关注的关注数量
    public List<getCount> getCountAttention(int i){
        return executeQuery("select fans_id,count(*) as COUNT from User_rel where fans_id in(select attention_id from user_rel where fans_id=?)group by fans_id order by fans_id asc", new Object[]{i});
    }
    //粉丝的微博数
    public List<getCount> getCountFansBlog(int i){
        return executeQuery("select user_id,count(*) as COUNT from Blog_Content where user_id=? group by user_id order by user_id asc",new Object[]{i});
    }
    //粉丝的关注数量
    public List<getCount> getCountFansA(int i){
        return executeQuery("select fans_id,count(*) as COUNT from User_rel where fans_id in(select fans_id from user_rel where attention_id=?)group by fans_id order by fans_id asc",new Object[]{i});
    }
    //关注的粉丝数量
    public List<getCount> getCountAttentionF(int i){
        return executeQuery("select attention_id,count(*) as COUNT from User_rel where attention_id in(select attention_id from user_rel where fans_id=?)group by attention_id order by attention_id asc", new Object[]{i});
    }
    //关注的微博数
    public List<getCount> getCountAttentionBlog(int i){
        return executeQuery("select user_id,count(*) as COUNT from Blog_Content where user_id in(select attention_id from user_rel where fans_id=?) group by user_id order by user_id asc",new Object[]{i});
    }
    //互相关注
    public int insertAttention(BigDecimal REL_ID,BigDecimal ATTENTION_ID){
        return executeUpdate("insert into user_rel(fans_id,attention_id)values(?,?)",new Object[]{REL_ID,ATTENTION_ID});
    }
    //取消关注
    public int deleteAttention(BigDecimal ATTENTION_ID){
        return executeUpdate("delete * from user_rel where attention_id=?",new Object[]{ATTENTION_ID});
    }
}
