package lt.ausra.employee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import lt.ausra.employee.databinding.ActivityMainBinding
import lt.ausra.employee.databinding.ActivitySecondBinding

class EmployeeDetails : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentExtra()
        setClickListenerOfSaveButton()
    }

    private fun getIntentExtra() {
        binding.idEditText.setText(
            intent.getIntExtra(Employees.MAIN_ACTIVITY_ITEM_ID, -1).toString()
        )
        binding.firstNameEditText.setText(
            intent.getStringExtra(Employees.MAIN_ACTIVITY_ITEM_FIRSTNAME)
        )
        binding.lastNameEditText.setText(
            intent.getStringExtra(Employees.MAIN_ACTIVITY_ITEM_LASTNAME)
        )
        binding.positionEditText.setText(
            intent.getStringExtra(Employees.MAIN_ACTIVITY_ITEM_POSITION)
        )
    }

    private fun setClickListenerOfSaveButton() {
        binding.saveButton.setOnClickListener {
            val finishIntent = Intent()

            finishIntent.putExtra(SECOND_ACTIVITY_ITEM_ID, (binding.idEditText.text.toString()).toInt())
            finishIntent.putExtra(SECOND_ACTIVITY_ITEM_FIRSTNAME, binding.firstNameEditText.text.toString())
            finishIntent.putExtra(SECOND_ACTIVITY_ITEM_LASTNAME, binding.lastNameEditText.text.toString())
            finishIntent.putExtra(SECOND_ACTIVITY_ITEM_POSITION, binding.positionEditText.text.toString())
            setResult(RESULT_OK, finishIntent)
            finish()
        }
    }

    companion object {
        const val SECOND_ACTIVITY_ITEM_ID = "lt.ausra.android_topics.secondactivity_Item_Id"
        const val SECOND_ACTIVITY_ITEM_FIRSTNAME = "lt.ausra.android_topics.secondactivity_firstname"
        const val SECOND_ACTIVITY_ITEM_LASTNAME = "lt.ausra.android_topics.secondactivity_lastname"
        const val SECOND_ACTIVITY_ITEM_POSITION = "lt.ausra.android_topics.secondactivity_position"
    }
}