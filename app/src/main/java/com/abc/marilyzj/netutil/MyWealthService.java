package com.abc.marilyzj.netutil;


import com.abc.marilyzj.beans.ChangeOderTypeBean;
import com.abc.marilyzj.beans.CreateOderBean;
import com.abc.marilyzj.beans.HomeBean;
import com.abc.marilyzj.beans.LoginBean;
import com.abc.marilyzj.beans.OderInfoBean;
import com.abc.marilyzj.beans.OderListBean;
import com.abc.marilyzj.beans.ProductBean;
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

    @GET("RepairItems?method=getHomeList")
    Observable<HomeBean> getHomeData();

    @GET("RepairItems?method=getInfoById")
    Observable<ProductBean> getProduct(@QueryMap Map<String, String> map);

    @GET("OrderInfo?method=getOrderInfo")
    Observable<OderInfoBean> getOderDetail(@QueryMap Map<String, String> map);

    @GET("OrderInfo?method=getAllOrderByUser")
    Observable<OderListBean> getAllOder(@QueryMap Map<String, String> map);

    @POST("OrderInfo?method=createOrder")
    Observable<CreateOderBean> creatOder(@QueryMap Map<String, String> map);

    @POST("OrderInfo?method=changeType")
    Observable<ChangeOderTypeBean> changeType(@QueryMap Map<String, String> map);

    @GET("DeptInfo?method=getInfoByType")
    Observable<HomeBean> getInfoByType(@QueryMap Map<String, String> map);

}
