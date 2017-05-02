package com.abc.marilyzj.netutil;


import com.abc.marilyzj.beans.LoginBean;
import com.abc.marilyzj.beans.RegisterBean;
import com.abc.marilyzj.beans.ResetPassBean;
import com.abc.marilyzj.beans.SetInfoBean;
import com.abc.marilyzj.beans.YanZhengBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface MyWealthService {

//    @POST("phone/api/newLogin")
//    Observable<LoginBean> getLogin(@QueryMap Map<String, String> map);
//
//    @GET("phone/api/register/validateCaptcha")
//    Observable<PictureCodeBean> verPictureCode(@QueryMap Map<String, String> map);
//
//    @GET("phone/api/accountInfo")
//    Observable<AccountInfoBean> getAccountInfo();
//
//    @GET("phone/api/logout")
//    Observable<ExitBean> toExit();


    @GET("UserInfo?method=login")
    Observable<LoginBean> getLogin(@QueryMap Map<String, String> map);

    @GET("UserInfo?method=register")
    Observable<RegisterBean> getRegister(@QueryMap Map<String, String> map);

    @GET("UserInfo?method=getCode")
    Observable<YanZhengBean> getYanZheng(@QueryMap Map<String, String> map);

    @GET("UserInfo?method=rePwd")
    Observable<ResetPassBean> getResetPass(@QueryMap Map<String, String> map);

    @POST("UserInfo?method=update")
    Observable<SetInfoBean> setPersonInfo(@QueryMap Map<String, String> map);

}
