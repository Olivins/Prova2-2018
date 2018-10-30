package professorangoti.com.interaocomousuario.activities.api;

import java.util.List;
import retrofit2.Call;
import professorangoti.com.interaocomousuario.activities.domain.Value;
import retrofit2.http.GET;

public interface ValueApi {
    @GET("/precos")
    Call<List<Value>> getValues();
}
