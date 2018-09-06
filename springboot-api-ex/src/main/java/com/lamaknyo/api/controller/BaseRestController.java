package com.lamaknyo.api.controller;

import com.lamaknyo.api.common.restemplate.Res;
import com.lamaknyo.api.common.restemplate.ResError;
import org.springframework.data.domain.Page;

import java.util.List;

public abstract class BaseRestController {
    public Res outOk(Object obj, int page, int limit) {
        Res res = new Res();
        res.setSuccess(true);
        res.setData(obj, page, limit);
        return res;
    }

    public Res outOk(Object obj) {
        Res res = new Res();
        res.setSuccess(true);
        res.setData(obj, 0, 0);
        return res;
    }


    public Res outOk(List<?> list, int page, int limit) {
        Res res = new Res();
        res.setSuccess(true);
        res.setData(list, page, limit);
        return res;
    }

    public Res outOk(Page<?> page) {
        Res res = new Res();
        res.setSuccess(true);
        res.setData(page, 0, 0);
        return res;
    }

    public Res outFail(String message, int code) {
        ResError e = new ResError();
        e.setMessage(message);
        e.setCode(code);

        Res res = new Res();
        res.setError(e);
        return res;
    }

}
