package co.istad.mbanking.api.accounttype;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface AccountTypeMapper {
    @SelectProvider(type = AccountTypeProvider.class, method = "buildSelectSql")
    List<AccountType> select();

    @SelectProvider(type = AccountTypeProvider.class, method = "buildSelectByIdSql")
    Optional<AccountType> selectById(@Param("id") Integer id);

    @InsertProvider(type = AccountTypeProvider.class, method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("ac") AccountType accountType);

    @UpdateProvider(type = AccountTypeProvider.class, method = "buildUpdateSql")
    void update(@Param("ac") AccountType accountType);
}
