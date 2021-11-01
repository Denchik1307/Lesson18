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
            pushMeButton()
        }
    }

    private fun openFragment(fragment: Fragment, myTag: String) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(myTag)
            .replace(R.id.fvFragmentConteiner, fragment)
            .commit()
    }

    fun pushMeButton() {
        when (countFragment) {
            0 -> openFragment(FirstFragment.newInstance(), FirstFragment.TAG)
            1 -> openFragment(SecondFragment.newInstance(), SecondFragment.TAG)
            2 -> openFragment(ThirdFragment.newInstance(), ThirdFragment.TAG)
        }
        countFragment++
        if (countFragment > 2) countFragment = 0
    }
}
