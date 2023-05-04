package co.istad.mbanking.api.accounttype;

import co.istad.mbanking.base.BaseRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor
public class AccountTypeRestController {

    private final AccountTypeService accountTypeService;

    @GetMapping
    public BaseRest<?> findAll() {
        var accountTypeDtoList = accountTypeService.findAll();
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account types have been found")
                .timestamp(LocalDateTime.now())
                .data(accountTypeDtoList)
                .build();
    }

    @GetMapping("/{id}")
    public BaseRest<?> findById(@PathVariable Integer id) {
        var accountType = accountTypeService.findById(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account type has been found")
                .timestamp(LocalDateTime.now())
                .data(accountType)
                .build();
    }

    @PostMapping
    public BaseRest<?> createNew(@Valid @RequestBody AccountTypeDto body) {
        AccountTypeDto accountTypeDto = accountTypeService.createNew(body);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account type has been created")
                .timestamp(LocalDateTime.now())
                .data(accountTypeDto)
                .build();
    }

    @PutMapping("/{id}")
    public BaseRest<?> updateById(@PathVariable Integer id, @Valid @RequestBody AccountTypeDto body) {
        AccountTypeDto accountTypeDto = accountTypeService.updateById(id, body);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account type has been updated")
                .timestamp(LocalDateTime.now())
                .data(accountTypeDto)
                .build();
    }

}
