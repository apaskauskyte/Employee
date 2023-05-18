package lt.ausra.employee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import lt.ausra.employee.databinding.EmployeeBinding

class CustomAdapter(context: Context) : BaseAdapter() {

    private val list = mutableListOf<Employee>()
    private val inflater = LayoutInflater.from(context)

    fun add(vararg employee: Employee) {
        list.addAll(employee)
        notifyDataSetChanged()
    }

    fun add(employees: List<Employee>) {
        list.addAll(employees)
        notifyDataSetChanged()
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    fun remove(vararg employee: Employee) {
        list.removeAll(employee)
        notifyDataSetChanged()
    }

    fun remove(employees: List<Employee>) {
        list.removeAll(employees)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        val binding: EmployeeBinding

        if (view == null) {
            binding = EmployeeBinding.inflate(inflater, parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = view.tag as EmployeeBinding
        }

        binding.idTextView.text = list[position].id.toString()
        binding.firstNameTextView.text = list[position].firstName
        binding.lastNameTextView.text = list[position].lastName
        binding.positionTextView.text = list[position].position

        return view
    }

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = list.size
}