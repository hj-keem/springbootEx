package com.example.Springbootgradle.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection makeConnection() throws ClassNotFoundException, SQLException; //public 있어도 되고 없어도 됨.
}
