package fr.isen.moutou.AndroidErestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fr.isen.moutou.AndroidErestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrees.setOnClickListener{
            val intent = Intent(this,CategoryActivity::class.java)
            intent.putExtra(CATEGORY_NAME,ItemTypes.ENTREES)
            startActivity(intent)
        }

        binding.buttonPlats.setOnClickListener{
            val intent = Intent(this,CategoryActivity::class.java)
            intent.putExtra(CATEGORY_NAME,ItemTypes.PLATS)
            startActivity(intent)
        }

        binding.buttonDesserts.setOnClickListener{
            val intent = Intent(this,CategoryActivity::class.java)
            intent.putExtra(CATEGORY_NAME,ItemTypes.DESSERTS)
            startActivity(intent)
        }
    }
    //put extra (clé valeur)
    companion object{
        const val CATEGORY_NAME = "category name"
    }

}