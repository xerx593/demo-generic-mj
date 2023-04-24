package com.stackoverflow.demogenericmj;

import com.stackoverflow.demogenericmj.model.BaseEntity;
import com.stackoverflow.demogenericmj.repo.BaseRepository;
import com.thirdparty.IThirdPartyCallback;

public class CallbackImpl<T extends BaseEntity> implements IThirdPartyCallback {

    // stateless, no problem:
    final BaseRepository<T> baseRepository;

    // state, problem! -> prototype/request/session
    String foo;

    public CallbackImpl(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @SuppressWarnings("java:S106")
    public void callback(String result) {
        System.err.println(this);
        foo = this.toString();
        baseRepository.findAll();
    }

    public String getFoo() {
        return foo;
    }
    
}
