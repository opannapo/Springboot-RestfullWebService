package com.lamaknyo.api.common.restemplate;

import com.lamaknyo.api.common.exceptions.NoResultException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@ResponseStatus(value = HttpStatus.OK)
public class Res {
    private Object data;
    private boolean isSuccess;
    private ResError error;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data, int page, int limit) {
        System.out.print("LOG DATA -> " + data);
        if (data == null || data.equals(Optional.empty())) {
            /*ResError e = new ResError();
            e.setMessage("No Content");
            e.setCode(HttpStatus.NO_CONTENT.value());
            setSuccess(false);
            setError(e);
            return;*/
            throw new NoResultException("Upppsss sorry, Content Not Found");
        }


        if (data instanceof List) {
            ResDataArray dArray = new ResDataArray();
            dArray.setList((List) data);
            dArray.setCount(((List) data).size());
            dArray.setPage(page);
            dArray.setLimit(limit);
            this.data = dArray;
        } else if (data instanceof Page) {
            ResDataArray dArray = new ResDataArray();
            Page p = (Page) data;
            dArray.setList(p.getContent());
            dArray.setCount(p.getContent().size());
            dArray.setPage(p.getNumber() + 1);
            dArray.setLimit(p.getSize());
            dArray.setHasNext(!p.isLast());
            dArray.setTotal(p.getTotalElements());
            this.data = dArray;
        } else {
            this.data = data;
        }
    }

    public ResError getError() {
        return error;
    }

    public void setError(ResError error) {
        this.error = error;
    }

}
