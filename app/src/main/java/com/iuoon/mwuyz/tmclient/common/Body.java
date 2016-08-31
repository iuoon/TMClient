package com.iuoon.mwuyz.tmclient.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iuoon.mwuyz.tmclient.model.TWUser;

/**
 * Created by mwuyz on 2016/8/30.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Body {
    @JsonProperty("User")
    private TWUser user;

    public TWUser getUser() {
        return user;
    }

    public void setUser(TWUser user) {
        this.user = user;
    }
}
