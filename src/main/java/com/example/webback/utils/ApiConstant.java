package com.example.webback.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ApiConstant {

    private static final String ROOT_PATH = "api/v1";

    public static final String USER = ROOT_PATH + "/user";

    public static final String MESSAGES = ROOT_PATH + "/messages";

    public static final String FRIENDS = ROOT_PATH + "/friends";

    public static final String COMMENTS = ROOT_PATH + "/comments";
}
