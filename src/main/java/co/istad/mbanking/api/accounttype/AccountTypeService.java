package co.istad.mbanking.api.accounttype;

import java.util.List;

public interface AccountTypeService {

    List<AccountTypeDto> findAll();

    AccountTypeDto findById(Integer id);

    AccountTypeDto createNew(AccountTypeDto accountTypeDto);

    AccountTypeDto updateById(Integer id, AccountTypeDto accountTypeDto);
}
