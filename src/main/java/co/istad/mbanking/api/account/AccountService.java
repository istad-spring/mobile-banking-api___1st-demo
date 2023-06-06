package co.istad.mbanking.api.account;

import co.istad.mbanking.api.account.web.AccountDto;
import com.github.pagehelper.PageInfo;

public interface AccountService {

    PageInfo<AccountDto> findAllAccounts(int page, int limit);

}
