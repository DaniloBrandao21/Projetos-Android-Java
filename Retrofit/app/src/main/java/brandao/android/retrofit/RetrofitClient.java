package brandao.android.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //Criando padrão singleton
    private static Retrofit retrofit;



    private static Retrofit getRetrofirClient(){

        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
    public static <S> S createService(Class<S> serviceClass){
        return getRetrofirClient().create(serviceClass);
    }
}
