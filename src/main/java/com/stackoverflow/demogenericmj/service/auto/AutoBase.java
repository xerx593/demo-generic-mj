package com.stackoverflow.demogenericmj.service.auto;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackoverflow.demogenericmj.CallbackImpl;
import com.stackoverflow.demogenericmj.model.BaseEntity;
import com.stackoverflow.demogenericmj.service.BaseServiceI;
import com.thirdparty.ThirdPartyClass;

class AutoBase<T extends BaseEntity> implements BaseServiceI {

    @Autowired
    private ObjectProvider<CallbackImpl<T>> callback;

    @Override
    public void runService() {        
        ThirdPartyClass.get(callback.getIfAvailable());
    }
}
