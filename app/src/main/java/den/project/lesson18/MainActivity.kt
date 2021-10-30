package den.project.lesson18

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import den.project.lesson18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var countFragment = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.button.setOnClickListener {
            when (countFragment) {
                0 -> openFragment(FirstFragment())
                1 -> openFragment(SecondFragment())
                2 -> openFragment(ThreeFragment())
            }
            countFragment++
            if (countFragment > 2) countFragment = 0
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(fragment.tag)
            .replace(R.id.fvFragmentConteiner, fragment)
            .commit()
    }
}