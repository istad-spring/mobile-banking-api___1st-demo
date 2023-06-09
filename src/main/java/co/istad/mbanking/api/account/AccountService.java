package co.istad.mbanking.api.account;

import co.istad.mbanking.api.account.web.AccountDto;
import co.istad.mbanking.api.account.web.AccountNameOrNoDto;
import co.istad.mbanking.api.account.web.EditAccountInfoDto;
import co.istad.mbanking.api.account.web.NewAccountDto;
import com.github.pagehelper.PageInfo;

public interface AccountService {

    AccountDto findAccountByNoOrName(AccountNameOrNoDto accountNameOrNoDto);

    PageInfo<AccountDto> findAllAccounts(int page, int limit);

    AccountDto createNewAccount(NewAccountDto newAccountDto);

    AccountDto editAccountInfo(String accountNo, EditAccountInfoDto editAccountInfoDto);

}
