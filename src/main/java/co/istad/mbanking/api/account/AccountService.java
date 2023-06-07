package co.istad.mbanking.api.account;

import co.istad.mbanking.api.account.web.AccountDto;
import co.istad.mbanking.api.account.web.AccountNameOrNoDto;
import com.github.pagehelper.PageInfo;

public interface AccountService {

    AccountDto findAccountByNoOrName(AccountNameOrNoDto accountNameOrNoDto);

    PageInfo<AccountDto> findAllAccounts(int page, int limit);

}
