package st.bdd.work.work.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import st.bdd.work.work.model.User;

@Mapper
public interface UserMapper {

        @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
        void insert(User user);

}
