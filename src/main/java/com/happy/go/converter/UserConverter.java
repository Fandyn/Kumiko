package com.happy.go.converter;

import com.happy.go.entity.User;
import com.happy.go.entity.VO.UserQuery;
import org.mapstruct.Mapper;
import java.util.List;

//阴间玩意，未知原因，本类不发生变化时，无法编译完全
@Mapper(componentModel = "spring")
public interface UserConverter {

    User userQuery2user(UserQuery userQuery);

    UserQuery user2UserQuery(User user);

    List<UserQuery> userlist2querylist(List<User> users);


}
