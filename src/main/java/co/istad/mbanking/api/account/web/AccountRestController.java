package co.istad.mbanking.api.account.web;

import co.istad.mbanking.api.account.AccountService;
import co.istad.mbanking.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

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


}
