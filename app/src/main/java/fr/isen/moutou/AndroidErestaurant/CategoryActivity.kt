package fr.isen.moutou.AndroidErestaurant
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.restoagnes.databinding.ActivityCategoryBinding
import com.example.restoagnes.models.Dish
import com.example.restoagnes.models.Menu_result
import com.google.gson.GsonBuilder
import fr.isen.moutou.AndroidErestaurant.databinding.ActivityCategoryBinding
import org.json.JSONObject


enum class ItemTypes{ENTREES, PLATS, DESSERTS}
class CategoryActivity {


    class CategoryActivity : AppCompatActivity() {

        private lateinit var binding: ActivityCategoryBinding//lateinit pour l'initialiser plus tard

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding= ActivityCategoryBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val selectedItem = intent.getSerializableExtra(HomeActivity.CATEGORY_NAME) as? ItemTypes
            binding.categorytitle.text=getcategorytitle(selectedItem)

            launchrequest()
        }

        private fun getcategorytitle(item: ItemTypes?):String{
            return when(item){
                ItemTypes.ENTREES->"Entrées"
                ItemTypes.PLATS->"Plats"
                ItemTypes.DESSERTS->"Desserts"

                else -> ""
            }
        }

        private fun launchrequest(){
            val q = Volley.newRequestQueue(this)
            val url = "http://test.api.catering.bluecodegames.com/menu"
            val jsondata = JSONObject()
            jsondata.put("id_shop",1)//ajout clé valeur
            val request = JsonObjectRequest(Request.Method.POST,
                url,
                jsondata,
                {
                    val menuResult = GsonBuilder().create().fromJson(it.toString(),Menu_result::class.java)
                    //recuperer menu result en objet
                    loadlist(menuResult.data.first().items)
                },//response listener
                {
                    Log.d("Request",it.toString())
                })//reponse error listener
            q.add(request)
        }

        private fun loadlist(list:List<Dish>){
            val adapteur = CategoryAdapter(list) { dish ->
                Log.d("dish", "Selected dish ${dish.name}")

            }
            binding.recyclerView.layoutManager= LinearLayoutManager(this)//affichage en liste
            binding.recyclerView.adapter = adapteur
        }
    }
}