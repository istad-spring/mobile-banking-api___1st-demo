package co.istad.mbanking.api.accounttype;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountTypeMapStruct {
    List<AccountTypeDto> toListAccountTypeDto(List<AccountType> model);
    AccountTypeDto toAccountTypeDto(AccountType model);

    AccountType fromAccountTypeDto(AccountTypeDto accountTypeDto);
}
