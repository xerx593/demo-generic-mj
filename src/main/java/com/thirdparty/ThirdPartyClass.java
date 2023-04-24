package com.thirdparty;

public class ThirdPartyClass {
    private ThirdPartyClass() {
    }

    @SuppressWarnings("java:S106") // use of System.out/err, sowwy!;)
    public static void get(IThirdPartyCallback callback) {
        callback.callback("hello");
    }

}
