package lt.ausra.employee

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import lt.ausra.employee.databinding.ActivityMainBinding

class Employees : AppCompatActivity() {

    private lateinit var adapter: CustomAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf<Employee>()
        adapter = CustomAdapter(this)
        adapter.add(
            Employee(101, "Jane", "Doe", "CEO"),
            Employee(102, "John", "Smith", "CFO")
        )

        binding.itemListView.adapter = adapter

        setClickOpenEmployeeDetails()
        openEmployeeDetails()
    }

    private fun openEmployeeDetails() {
        binding.openButton.setOnClickListener {
            startActivityForResult.launch(Intent(this, EmployeeDetails::class.java))
        }
    }

    private fun setClickOpenEmployeeDetails() {
        binding.itemListView.setOnItemClickListener { adapterView, view, position, l ->
            val employee: Employee = adapterView.getItemAtPosition(position) as Employee

            val itemIntent = Intent(this, EmployeeDetails::class.java)
            itemIntent.putExtra(MAIN_ACTIVITY_ITEM_ID, employee.id)
            itemIntent.putExtra(MAIN_ACTIVITY_ITEM_FIRSTNAME, employee.firstName)
            itemIntent.putExtra(MAIN_ACTIVITY_ITEM_LASTNAME, employee.lastName)
            itemIntent.putExtra(MAIN_ACTIVITY_ITEM_POSITION, employee.position)
            startActivity(itemIntent)
        }
    }

    private val startActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when (result.resultCode) {
                Activity.RESULT_OK -> {
                    val item = Employee(
                        id = result.data?.getIntExtra(
                            EmployeeDetails.SECOND_ACTIVITY_ITEM_ID, 0
                        ) ?: 0,
                        firstName = result.data?.getStringExtra(
                            EmployeeDetails.SECOND_ACTIVITY_ITEM_FIRSTNAME
                        ) ?: "",
                        lastName = result.data?.getStringExtra(
                            EmployeeDetails.SECOND_ACTIVITY_ITEM_LASTNAME
                        ) ?: "",
                        position = result.data?.getStringExtra(
                            EmployeeDetails.SECOND_ACTIVITY_ITEM_LASTNAME
                        ) ?: "",
                    )

                    adapter.add(item)
                }
            }
        }

    companion object {
        const val MAIN_ACTIVITY_ITEM_ID = "lt.ausra.android_topics.secondactivity_Item_Id"
        const val MAIN_ACTIVITY_ITEM_FIRSTNAME = "lt.ausra.android_topics.secondactivity_firstname"
        const val MAIN_ACTIVITY_ITEM_LASTNAME = "lt.ausra.android_topics.secondactivity_lastname"
        const val MAIN_ACTIVITY_ITEM_POSITION = "lt.ausra.android_topics.secondactivity_position"
    }
}