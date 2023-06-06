package co.istad.mbanking.api.account;

import co.istad.mbanking.api.account.web.AccountDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountMapStruct accountMapStruct;

    @Override
    public PageInfo<AccountDto> findAllAccounts(int page, int limit) {

        PageInfo<Account> accountPageInfo = PageHelper.startPage(page, limit).doSelectPageInfo(accountMapper::select);

        /*List<AccountDto> accountDtoList = accountPageInfo.getList().stream()
                .map(new Function<Account, AccountDto>() {
                    @Override
                    public AccountDto apply(Account account) {
                        return AccountDto.builder()
                                .accountNo(account.getAccountNo())
                                .accountName(account.getAccountName())
                                .pin(account.getPin())
                                .accountTypeName(account.getAccountType().getName())
                                .build();
                    }
                })
                .toList();*/


        return accountMapStruct.toAccountDtoPageInfo(accountPageInfo);
    }
}
