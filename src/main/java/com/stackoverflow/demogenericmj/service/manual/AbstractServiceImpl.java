package com.stackoverflow.demogenericmj.service.manual;

import com.stackoverflow.demogenericmj.CallbackImpl;
import com.stackoverflow.demogenericmj.model.BaseEntity;
import com.stackoverflow.demogenericmj.service.BaseServiceI;
import com.thirdparty.ThirdPartyClass;

public abstract class AbstractServiceImpl<T extends BaseEntity> implements BaseServiceI {
    @Override
    public void runService() {
        ThirdPartyClass.get(callback());
    }
    protected abstract CallbackImpl<T> callback();
}