package co.istad.mbanking.api.account.web;

import co.istad.mbanking.api.accounttype.AccountTypeDto;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AccountDto(String accountNo,
                         String accountName,
                         String pin,
                         BigDecimal transferLimit,
                         String accountTypeName) {
}
