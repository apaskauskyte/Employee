package lt.ausra.employee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

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
        val view = convertView ?: inflater.inflate(R.layout.employee, parent, false)

        view.findViewById<TextView>(R.id.idTextView).text = list[position].id.toString()
        view.findViewById<TextView>(R.id.firstNameTextView).text = list[position].firstName
        view.findViewById<TextView>(R.id.lastNameTextView).text = list[position].lastName
        view.findViewById<TextView>(R.id.positionTextView).text = list[position].position

        return view
    }

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = list.size
}