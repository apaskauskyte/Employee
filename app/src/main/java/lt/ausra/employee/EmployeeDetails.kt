package lt.ausra.employee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EmployeeDetails : AppCompatActivity() {

    lateinit var idEditText: EditText
    lateinit var firstNameEditText: EditText
    lateinit var lastNameEditText: EditText
    lateinit var positionEditText: EditText
    lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        idEditText = findViewById(R.id.idEditText)
        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)
        positionEditText = findViewById(R.id.positionEditText)
        saveButton = findViewById(R.id.saveButton)

        getIntentExtra()
        setClickListenerOfSaveButton()
    }

    private fun getIntentExtra() {
        idEditText.setText(
            intent.getIntExtra(Employees.MAIN_ACTIVITY_ITEM_ID, -1).toString()
        )
        firstNameEditText.setText(
            intent.getStringExtra(Employees.MAIN_ACTIVITY_ITEM_FIRSTNAME)
        )
        lastNameEditText.setText(
            intent.getStringExtra(Employees.MAIN_ACTIVITY_ITEM_LASTNAME)
        )
        positionEditText.setText(
            intent.getStringExtra(Employees.MAIN_ACTIVITY_ITEM_POSITION)
        )
    }

    private fun setClickListenerOfSaveButton() {
        saveButton.setOnClickListener {
            val finishIntent = Intent()

            finishIntent.putExtra(SECOND_ACTIVITY_ITEM_ID, (idEditText.text.toString()).toInt())
            finishIntent.putExtra(SECOND_ACTIVITY_ITEM_FIRSTNAME, firstNameEditText.text.toString())
            finishIntent.putExtra(SECOND_ACTIVITY_ITEM_LASTNAME, lastNameEditText.text.toString())
            finishIntent.putExtra(SECOND_ACTIVITY_ITEM_POSITION, positionEditText.text.toString())
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