package com.lamaknyo.api.common.security;

import io.jsonwebtoken.Claims;

public class ClaimResult {
    private boolean right;
    private String error;
    private Claims claimBody;

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public Claims getClaimBody() {
        return claimBody;
    }

    public void setClaimBody(Claims claimBody) {
        this.claimBody = claimBody;
    }
}
