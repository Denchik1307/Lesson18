package den.project.lesson18

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var countFragment = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        button.setOnClickListener {
            when (countFragment) {
                0 -> openFragment(FirstFragment.newInstance())
                1 -> openFragment(SecondFragment.newInstance())
                2 -> openFragment(ThreeFragment.newInstance())
            }
            countFragment++
            if (countFragment > 2) countFragment = 0
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
//            .addToBackStack(fragment.tag)
            .replace(R.id.fvFragmentConteiner, fragment)
            .commit()
    }
}