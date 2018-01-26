package com.example.st1drawermenu;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-01-26.
 */

public class ValidateRequest extends StringRequest {

    final static private String URL = "http://givetest.cafe24.com/UserValidate.php";
    private Map<String, String> parameters;

    public ValidateRequest(String userID, Response.Listener<String> Listener) {
        super(Method.POST,URL,Listener,null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);

    }



    public Map<String, String> getParams() {
        return parameters;
    }

}


