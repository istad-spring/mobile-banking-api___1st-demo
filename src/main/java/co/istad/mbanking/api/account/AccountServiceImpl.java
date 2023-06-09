package co.istad.mbanking.api.account;

import co.istad.mbanking.api.account.web.AccountDto;
import co.istad.mbanking.api.account.web.AccountNameOrNoDto;
import co.istad.mbanking.api.account.web.EditAccountInfoDto;
import co.istad.mbanking.api.account.web.NewAccountDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountMapStruct accountMapStruct;

    @Override
    public AccountDto findAccountByNoOrName(AccountNameOrNoDto accountNameOrNoDto) {

        log.info("Account Name or No: {}", accountNameOrNoDto.nameOrNo());

        Account account = accountMapper.selectByNameOrNo(accountNameOrNoDto.nameOrNo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Name or No hasn't been found"));

        return accountMapStruct.toAccountDto(account);
    }


    @Override
    public PageInfo<AccountDto> findAllAccounts(int page, int limit) {

        PageInfo<Account> accountPageInfo = PageHelper.startPage(page, limit).doSelectPageInfo(accountMapper::select);

        return accountMapStruct.toAccountDtoPageInfo(accountPageInfo);
    }


    @Override
    public AccountDto createNewAccount(NewAccountDto newAccountDto) {



        return null;
    }

    @Override
    public AccountDto editAccountInfo(String accountNo, EditAccountInfoDto editAccountInfoDto) {

        if (accountMapper.existsAccountNo(accountNo)) {
            log.info("{} exists!", accountNo);
        }

        return null;
    }
}
