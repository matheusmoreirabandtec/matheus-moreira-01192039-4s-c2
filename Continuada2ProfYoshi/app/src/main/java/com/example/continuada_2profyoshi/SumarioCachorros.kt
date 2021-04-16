package com.example.continuada_2profyoshi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SumarioCachorros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sumario_cachorros)

        val layoutLista: LinearLayout = findViewById(R.id.layout_lista)

        val apiCachorros = ConexãoApiCachorros.criar()
        var qtdIndicados = 0
        var qtdNaoIndicados = 0

        apiCachorros.get().enqueue(object : Callback<List<Cachorro>> {
            override fun onResponse(call: Call<List<Cachorro>>, response: Response<List<Cachorro>>) {
                response.body()?.forEach {

                    if(it.indicadoCriancas){
                        qtdIndicados++
                    }else{
                        qtdNaoIndicados++
                    }

                    val tvIndicados: TextView = findViewById(R.id.tv_indicado_qtd)
                    tvIndicados.text = qtdIndicados.toString()

                    val tvNaoIndicados: TextView = findViewById(R.id.tv_nao_indicado_qtd)
                    tvNaoIndicados.text = qtdNaoIndicados.toString()

                    val totalCachorros: TextView = findViewById(R.id.tv_total_cachorros_qtd)
                    totalCachorros.text = (qtdNaoIndicados + qtdIndicados).toString()

                    val tvCachorro = TextView(baseContext)
                    tvCachorro.text = "Id: ${it.id} - Raça: ${it.raca} - Preço Médio: ${it.precoMedio} - Se da bem com Crianças ?  ${it.indicadoCriancas}"
                    tvCachorro.setTextColor(Color.parseColor("#33CAFF"))

                    layoutLista.addView(tvCachorro)
                }
            }

            override fun onFailure(call: Call<List<Cachorro>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("Erro", "Erro Louco: " + t.message!!)

            }


        })
    }
}