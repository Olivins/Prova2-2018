package professorangoti.com.interaocomousuario.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import professorangoti.com.interaocomousuario.R;
import professorangoti.com.interaocomousuario.activities.api.ValueApi;
import professorangoti.com.interaocomousuario.activities.api.RetrofitFactory;
import professorangoti.com.interaocomousuario.activities.domain.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ValueActivity extends AppCompatActivity {

    private String pedido;
    private List<Value> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        pedido = intent.getStringExtra("pedido");
        Log.i("pedido", "Pedido: " + pedido);

        ValueApi api = RetrofitFactory.getPriceApi();
        api.getValues().enqueue(new Callback<List<Value>>() {

            @Override
            public void onResponse(Call<List<Value>> call, Response<List<Value>> response) {
                values = response.body();
                Log.i("prices:", values.toString());

                for (Value value : values) {
                    if (value.getProduto().contains(pedido)) {
                        TextView textView = findViewById(R.id.preco);
                        textView.setText(value.getValor());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Value>> call, Throwable t) {
                Log.e("Erro", "Erro ao recuperar preços", t);
            }
        });

    }
}
