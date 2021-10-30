package den.project.lesson18

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import den.project.lesson18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val first = FirstFragment()
    private val second = SecondFragment()
    private val three = Three_Fragment()
    private val fragments = arrayListOf(first, second, three)
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("myLog", "fragment size ${fragments.size}")



    }

    override fun onStart() {
        super.onStart()
        binding.button.setOnClickListener {
            if (count == fragments.size) {
                Log.d("myLog", "counter reset")
                count = 0
            }
            Log.d("myLog", count.toString())
            fragmentChange(count)
            count++
            Log.d("myLog", "fragment count $count")
        }
    }


    private fun openFragment(fragment: Fragment) {
        Log.d("myLog", "fragment open")
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(fragment.toString())
            .add(R.id.fvFragment, fragment)
            .commit()
    }

    private fun fragmentChange(fragment: Int) {
        openFragment(fragments[fragment])
        Log.d("myLog", "fragment change")
    }
}