package co.istad.mbanking.api.auth;

import co.istad.mbanking.api.auth.web.RegisterDto;
import co.istad.mbanking.api.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapStruct {

    User fromRegisterDto(RegisterDto registerDto);

}
