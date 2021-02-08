package com.happy.go.converter;

import com.happy.go.entity.User;
import com.happy.go.entity.VO.UserQuery;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserConverter {

    User userQuery2user(UserQuery userQuery);

    UserQuery user2UserQuery(User user);

    List<UserQuery> userlist2querylist(List<User> users);

//    Error:(16, 21) java: Can't map Collection element "com.happy.go.entity.User user" to "com.happy.go.entity.VO.UserQuery userQuery". Consider to declare/implement a mapping method: "com.happy.go.entity.VO.UserQuery map(com.happy.go.entity.User value)".
}
