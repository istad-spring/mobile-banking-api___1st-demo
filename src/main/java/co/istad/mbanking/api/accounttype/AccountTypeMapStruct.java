package co.istad.mbanking.api.accounttype;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AccountTypeMapStruct {

    List<AccountTypeDto> toListAccountTypeDto(List<AccountType> accountTypes);

    AccountTypeDto toAccountTypeDto(AccountType accountType);

    AccountType fromAccountTypeDto(AccountTypeDto accountTypeDto);

}
