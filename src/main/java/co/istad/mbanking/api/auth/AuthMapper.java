package co.istad.mbanking.api.auth;

import co.istad.mbanking.api.user.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface AuthMapper {

    @InsertProvider(type = AuthProvider.class, method = "buildRegisterSql")
    void register(@Param("u") User user);

    @Select("SELECT * FROM users WHERE email = #{email} AND is_deleted = FALSE")
    Optional<User> selectByEmail(@Param("email") String email);

}
