package com.example.indiannationalkennelclub;

import com.example.indiannationalkennelclub.ResponseModel.AddNonInkcDogRegisterResponse;
import com.example.indiannationalkennelclub.ResponseModel.LitterRegisterFromResponse;
import com.example.indiannationalkennelclub.ResponseModel.MicroResponse;
import com.example.indiannationalkennelclub.ResponseModel.PedigreeFromResponse;
import com.example.indiannationalkennelclub.ResponseModel.UnknowPedigreeFromResponse;
import com.example.indiannationalkennelclub.ResponseModel.UpdateProfileResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {


//    @Headers({"Userid:24775 ",
//              "Usertoken:N0VQPY7F"})

    @Multipart
    @POST("update_profile")
    Call<UpdateProfileResponse> Update(@Part MultipartBody.Part user_profile_image,
                                       @Part("user_email_id")RequestBody userEmail,
                                       @Part("user_local")RequestBody local,
                                       @Part("user_state")RequestBody state,
                                       @Part("user_pincode")RequestBody pincode,
                                       @Part("user_address")RequestBody add1,
                                       @Part("user_address_2")RequestBody add2,
                                       @Part("user_district")RequestBody distic,
                                       @Part("gender")RequestBody gender,
                                       @Part("alternet_contact_number")RequestBody contact,
                                       @Header("Userid")String UserId,
                                       @Header("Usertoken")String Usertoken);

    @Multipart
    @POST("non_inkc_registration")
    Call<AddNonInkcDogRegisterResponse> AddData(@Part MultipartBody.Part pet_image,
                                                @Part MultipartBody.Part front_side_certificate,
                                                @Part MultipartBody.Part back_side_certificate,
                                                @Part("pet_registration_number")RequestBody pet_registration_number,
                                                @Part("kennel_club_prefix")RequestBody kennel_club_prefix,
                                                @Part("pet_name")RequestBody pet_name,
                                                @Part("birth_date")RequestBody birth_date,
                                                @Part("pet_sub_category_id")RequestBody pet_sub_category_id,
                                                @Part("pet_gender")RequestBody pet_gender,
                                                @Header("Userid")String UserId,
                                                @Header("Usertoken")String Usertoken
    );

    @Multipart
    @POST("pedigree_dog_registration")
    Call<PedigreeFromResponse> AddDataPadigree(@Part MultipartBody.Part pet_image,
                                               @Part("sire_reg_number")RequestBody sire_reg_number,
                                               @Part("dam_reg_number")RequestBody dam_reg_number,
                                               @Part("pet_gender")RequestBody pet_gender,
                                               @Part("birth_date")RequestBody birth_date,
                                               @Part("pet_name")RequestBody pet_name,
                                               @Part("color_marking")RequestBody color_marking,
                                               @Part("is_microchip_require")RequestBody is_microchip_require,
                                               @Part("is_second_owner")RequestBody is_second_owner,
                                               @Part("second_owner_id")RequestBody second_owner_id,
                                               @Header("Userid")String UserId,
                                               @Header("Usertoken")String Usertoken
                                               );

    @Multipart
    @POST("unknown_pedigree_dog_registration")
    Call<UnknowPedigreeFromResponse> AddUnknowPedigree(@Part MultipartBody.Part pet_image,
                                                       @Part MultipartBody.Part pet_height_image,
                                                       @Part MultipartBody.Part pet_side_image,
                                                       @Part("pet_sub_category_id")RequestBody pet_sub_category_id,
                                                       @Part("pet_gender")RequestBody pet_gender,
                                                       @Part("birth_date")RequestBody birth_date,
                                                       @Part("pet_name")RequestBody pet_name,
                                                       @Part("color_marking")RequestBody color_marking,
                                                       @Part("is_microchip_require")RequestBody is_microchip_require,
                                                       @Part("is_second_owner")RequestBody is_second_owner,
                                                       @Part("second_owner_id")RequestBody second_owner_id,
                                                       @Header("Userid")String UserId,
                                                       @Header("Usertoken")String Usertoken
    );

    @Multipart
    @POST("upload_document_microchip")
    Call<MicroResponse> MicroAdd(@Part MultipartBody.Part upload_microchip_document,
                                 @Part("implementer_name")RequestBody implementer_name,
                                 @Part("implement_by")RequestBody implement_by,
                                 @Part("pet_microchip_number")RequestBody pet_microchip_number,
                                 @Part("implementer_mobile_number") RequestBody implementer_mobile_number,
                                 @Part("implemented_date")RequestBody implemented_date,
                                 @Header("Userid")String UserId,
                                 @Header("Usertoken")String Usertoken
                                 );

    @Multipart
    @POST("litter_registration")
    Call<LitterRegisterFromResponse> LitterAdd(@Part MultipartBody.Part pet_image,
                                               @Part("sire_reg_number")RequestBody sire_reg_number,
                                               @Part("dam_reg_number")RequestBody dam_reg_number,
                                               @Part("pet_gender[]")RequestBody pet_gender,
                                               @Part("birth_date")RequestBody birth_date,
                                               @Part("pet_name[]")RequestBody pet_name,
                                               @Part("color_marking[]")RequestBody color_marking,
                                               @Part("kennel_name")RequestBody kennel_name,
                                               @Part("kennel_name_pre")RequestBody kennel_name_pre,
                                               @Header("Userid")String UserId,
                                               @Header("Usertoken")String Usertoken
                                               );
}
