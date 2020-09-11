package com.mementos.moments.Utils;

import com.mementos.moments.Model.User;
import com.mementos.moments.Retrofit.ApiClient;
import com.mementos.moments.Retrofit.ApiInterface;

public class Common {
    public static final String BASE_URL = "http://192.168.43.249/memoria/public/";

    public static User currentUser = null;

    public static ApiInterface getAPI()
    {
        return ApiClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
