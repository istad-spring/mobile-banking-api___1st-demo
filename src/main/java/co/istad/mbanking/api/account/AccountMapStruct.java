package co.istad.mbanking.api.account;

import co.istad.mbanking.api.account.web.AccountDto;
import co.istad.mbanking.api.accounttype.AccountType;
import co.istad.mbanking.api.accounttype.AccountTypeMapStruct;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = AccountTypeMapStruct.class)
public interface AccountMapStruct {

    @Mapping(source = "accountType.name", target = "accountTypeName")
    AccountDto toAccountDto(Account account, AccountType accountType);

    @Mapping(source = "accountTypeName", target = "accountType.name")
    Account fromAccountDto(AccountDto accountDto);


    @Mapping(source = "accounts.accountType.name", target = "accountTypeName")
    List<AccountDto> toAccountDtoList(List<Account> accounts, AccountType accountType);

    PageInfo<AccountDto> toAccountDtoPageInfo(PageInfo<Account> account);

}
