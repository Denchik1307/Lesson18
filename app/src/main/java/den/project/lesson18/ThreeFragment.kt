package den.project.lesson18

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ThreeFragment : Fragment() {

    companion object {
        const val TAG = "den.project.lesson18.Three_Fragment"

        fun newInstance() = ThreeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_three_layout, container, false)


}