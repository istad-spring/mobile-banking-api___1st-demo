package co.istad.mbanking.api.account;

import co.istad.mbanking.api.accounttype.AccountType;
import co.istad.mbanking.api.accounttype.AccountTypeProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface AccountMapper {

    @SelectProvider(AccountProvider.class)
    @ResultMap(value = "accountResultMap")
    Optional<Account> selectByNameOrNo(String accountNameOrNo);


    @SelectProvider(AccountProvider.class)
    @Results(id = "accountResultMap", value = {
            @Result(property = "accountNo", column = "account_no"),
            @Result(property = "accountName", column = "account_name"),
            @Result(property = "transferLimit", column = "transfer_limit"),
            @Result(property = "accountType", column = "account_type", one = @One(select = "selectAccountType"))
    })
    List<Account> select();


    @SelectProvider(value = AccountTypeProvider.class, method = "buildSelectByIdSql")
    AccountType selectAccountType(Integer id);


    @SelectProvider(AccountProvider.class)
    boolean existsAccountNo(String accountNo);


    @SelectProvider(AccountProvider.class)
    boolean existsAccountName(String accountName);


    @SelectProvider(AccountProvider.class)
    boolean existsAccountPhoneNumber(String accountPhoneNumber);

}