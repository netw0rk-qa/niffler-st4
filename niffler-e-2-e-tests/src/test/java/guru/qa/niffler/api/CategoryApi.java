package guru.qa.niffler.api;

import guru.qa.niffler.model.CategoryJson;
import guru.qa.niffler.model.SpendJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CategoryApi {
    @POST("/category")
    Call<SpendJson> addCategory(@Body CategoryJson category);
}