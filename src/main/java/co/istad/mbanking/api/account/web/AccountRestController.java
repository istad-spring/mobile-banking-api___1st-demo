package co.istad.mbanking.api.account.web;

import co.istad.mbanking.api.account.AccountService;
import co.istad.mbanking.base.BaseRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @PostMapping("/search")
    public BaseRest<?> findAccountByNameOrNo(@RequestBody AccountNameOrNoDto accountNameOrNoDto) {

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account has been found successfully.")
                .timestamp(LocalDateTime.now())
                .data(accountService.findAccountByNoOrName(accountNameOrNoDto))
                .build();

    }

    @PostMapping
    public BaseRest<?> createNewAccount(@Valid @RequestBody NewAccountDto newAccountDto) {

        AccountDto accountDto = accountService.createNewAccount(newAccountDto);

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account have been created successfully.")
                .timestamp(LocalDateTime.now())
                .data(accountDto)
                .build();
    }

    @GetMapping
    public BaseRest<?> findAllAccounts(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                       @RequestParam(name = "limit", required = false, defaultValue = "20") int limit) {

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Accounts have been found successfully.")
                .timestamp(LocalDateTime.now())
                .data(accountService.findAllAccounts(page, limit))
                .build();

    }

    @PutMapping("/{accountNo}")
    public BaseRest<?> editAccountInfo(EditAccountInfoDto editAccountInfoDto,
                                       @PathVariable String accountNo) {

        AccountDto accountDto = accountService.editAccountInfo(accountNo, editAccountInfoDto);

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account have been edited successfully.")
                .timestamp(LocalDateTime.now())
                .data(accountDto)
                .build();
    }


}
