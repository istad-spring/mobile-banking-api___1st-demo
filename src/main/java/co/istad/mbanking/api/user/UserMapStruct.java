package co.istad.mbanking.api.user;

import co.istad.mbanking.api.auth.web.LoggedInProfileDto;
import co.istad.mbanking.api.auth.web.RegisterDto;
import co.istad.mbanking.api.user.web.CreateUserDto;
import co.istad.mbanking.api.user.web.UpdateUserDto;
import co.istad.mbanking.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {

    User createUserDtoToUser(CreateUserDto createUserDto);

    User updateUserDtoToUser(UpdateUserDto updateUserDto);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    PageInfo<UserDto> userPageInfoToUserDtoPageInfo(PageInfo<User> userPageInfo);

    User registerDtoToUser(RegisterDto registerDto);

    LoggedInProfileDto userToLoggedInProfileDto(User user);

}
