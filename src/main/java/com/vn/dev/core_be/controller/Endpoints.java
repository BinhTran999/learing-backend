package com.vn.dev.core_be.controller;

public interface Endpoints {

    String PREFIX = "api/base-nv";
    String PATH_VARIABLE_ID = "/{uuid}";

    String GET_ALL_PATH = "/get-all";
    String CREATE_PATH = "/";
    String UPDATE_PATH = PATH_VARIABLE_ID;
    String DELETE_PATH = PATH_VARIABLE_ID;
    String DETAIL_PATH = PATH_VARIABLE_ID;


}
