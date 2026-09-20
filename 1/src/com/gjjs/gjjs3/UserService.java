package com.gjjs.gjjs3;

public interface UserService {
    void login(String loginName, String passWord) throws Exception;
    void deleteUsers() throws Exception;
    String[] selectUsers() throws Exception;
}
