package com.ltizzi.EasyBankBackend.constants;

public interface SecurityConstants {

    public static final String JWT_KEY = System.getenv("SECRET");
    public static final String JWT_HEADER = "Authorization";
}
