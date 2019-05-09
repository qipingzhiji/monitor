package com.holk.service;

import com.holk.entity.Comm;
import com.holk.entity.Result;

public interface UserService {
    Result validateUser(Comm comm);
    String getServerPort(String name, String id, String port);
}
