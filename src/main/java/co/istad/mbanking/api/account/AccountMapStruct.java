package co.istad.mbanking.api.account;

import co.istad.mbanking.api.account.web.AccountDto;
import co.istad.mbanking.api.accounttype.AccountType;
import co.istad.mbanking.api.accounttype.AccountTypeMapStruct;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {AccountTypeMapStruct.class})
public interface AccountMapStruct {

    AccountDto toAccountDto(Account account);

    List<AccountDto> toAccountDtoList(List<Account> accounts);

    Account fromAccountDto(AccountDto accountDto);


    PageInfo<AccountDto> toAccountDtoPageInfo(PageInfo<Account> account);

}
