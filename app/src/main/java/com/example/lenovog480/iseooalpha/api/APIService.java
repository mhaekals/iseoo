package com.example.lenovog480.iseooalpha.api;

import com.example.lenovog480.iseooalpha.model.ApiResponseModel;
import com.example.lenovog480.iseooalpha.model.JasaModel;
import com.example.lenovog480.iseooalpha.model.OrderModel;
import com.example.lenovog480.iseooalpha.model.RequestModel;
import com.example.lenovog480.iseooalpha.model.SponsorModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by Lenovo G480 on 10/23/2017.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("Login")
    Call<ApiResponseModel> login(@Field("username")String username,
                                 @Field("password")String password);

    @FormUrlEncoded
    @POST("User")
    Call<ApiResponseModel> regist(@Field("nama_lengkap")String nama_lengkap,
                                  @Field("username")String username,
                                  @Field("email")String email,
                                  @Field("password")String password,
                                  @Field("no_telp")String no_telp);

    @FormUrlEncoded
    @POST("Event")
    Call<ApiResponseModel> newEvent(@Field("nama_event")String nama_event,
                                    @Field("jenis_event")String jenis_event,
                                    @Field("creator")String creator,
                                    @Field("deskripsi_event") String deskripsi_event,
                                    @Field("tanggal")String tanggal);


    @GET("Event")
    Call<ApiResponseModel> viewEvent();


    @FormUrlEncoded
    @POST("Layanan")
    Call<ApiResponseModel> newJasa(@Field("nama_jasa")String nama_jasa,
                                    @Field("harga")String harga,
                                    @Field("kontak")String kontak,
                                    @Field("jenis_jasa") String jenis_jasa,
                                    @Field("deskripsi")String deskripsi,
                                    @Field("untuk_event")String untuk_event,
                                           @Field("pemilik")String pemilik);

    @FormUrlEncoded
    @POST("Sponsor")
    Call<ApiResponseModel> newSponsor(@Field("nama_sponsor")String nama_sponsor,
                                   @Field("kontak")String kontak,
                                   @Field("jenis_sponsor") String jenis_jasa,
                                   @Field("deskripsi")String deskripsi,
                                   @Field("untuk_event")String untuk_event,
                                   @Field("pemilik")String pemilik);

    @GET("Sponsor")
    Call<SponsorModel> viewSponsor();

    @GET("Venue")
    Call<JasaModel> viewTempat();

    @GET("Equipment")
    Call<JasaModel> viewPerlengkapan();

    @FormUrlEncoded
    @POST("Request")
    Call<ApiResponseModel> request(@Field("lama_event")String lama_event,
                                   @Field("tanggal_mulai")String tggl_mulai,
                                   @Field("id_event")String event,
                                   @Field("id_sponsor")String sponsor);

    @FormUrlEncoded
    @POST("Order")
    Call<ApiResponseModel> order(@Field("lama_event")String lama_event,
                                 @Field("tanggal_mulai")String tggl_mulai,
                                 @Field("id_event")String event,
                                 @Field("id_jasa")String jasa);

    @GET("Order")
    Call<OrderModel> viewOrder();

    @GET("Request")
    Call<RequestModel> viewRequest();

    @FormUrlEncoded
    @PUT("Order")
    Call<ApiResponseModel> updateOrder(@Field("id_order")String id,
                                       @Field("status")String status);

    @FormUrlEncoded
    @PUT("Request")
    Call<ApiResponseModel> updateRequest(@Field("id_request")String id,
                                       @Field("status")String status);

}
