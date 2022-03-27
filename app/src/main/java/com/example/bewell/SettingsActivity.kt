package com.example.bewell

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.recyclical.ViewHolder
import com.afollestad.recyclical.datasource.DataSource
import com.afollestad.recyclical.datasource.dataSourceTypedOf
import com.afollestad.recyclical.datasource.emptyDataSourceTyped
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import com.example.bewell.Utilities.logOut
import com.example.bewell.Utilities.setBottomNav
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val uid = FirebaseAuth.getInstance().currentUser?.uid
        val db = Firebase.firestore
        val dataSource: DataSource<Contacts> = emptyDataSourceTyped()

        val recyclerView = findViewById<RecyclerView>(R.id.contacts_recycler)
        val doctor_tv = findViewById<TextView>(R.id.doctor_contact)
        val name_tv = findViewById<TextView>(R.id.name)
        val bday_tv = findViewById<TextView>(R.id.date_of_birth)

        val log_out_b = findViewById<Button>(R.id.log_out)

        setBottomNav(findViewById(R.id.bottom_navigation), this)

        val docRef = db.collection("Users").document(uid.toString())
        docRef.get().addOnSuccessListener {
            if (it != null) {
                val data: PersonalInfo = it.toObject(PersonalInfo::class.java)!!
                data.contactEmail.forEach { item ->
                    dataSource.add(Contacts(item))
                }
                doctor_tv.text = data.doctorEmail
                name_tv.text = data.fName + " " + data.lName
                bday_tv.text = data.dateOfBirth
            } else {
                Log.d(this::class.java.simpleName, "No such document")
            }
        }.addOnFailureListener { exception ->
            Log.d(this::class.java.simpleName, "get failed with ", exception)
        }


        recyclerView.setup {
            withDataSource(dataSource)
            withItem<Contacts, ContactsViewHolder>(R.layout.view_holder_contact) {
                onBind(::ContactsViewHolder) { index, item ->
                    // PersonViewHolder is `this` here
                    email_tv.text = item.email
                }
                onClick { index ->
                    // item is a `val` in `this` here
                    Log.d("fasza", "short $index")
                }
                onLongClick { index ->
                    // item is a `val` in `this` here
                    Log.d("fasza", "long $index")
                }
            }
        }

        log_out_b.setOnClickListener {
            logOut(this)
        }

    }
}

class PersonalInfo constructor() {
    var conditionScore: String = ""
    var contactEmail: ArrayList<String> = arrayListOf()
    var dateOfBirth: String = ""
    var dateOfFirstTest: String = ""
    var doctorEmail: String = ""
    var fName: String = ""
    var lName: String = ""

    constructor(
        conditionScore: String,
        contactEmail: ArrayList<String>,
        dateOfBirth: String,
        dateOfFirstTest: String,
        doctorEmail: String,
        fName: String,
        lName: String
    ) : this() {
        this.conditionScore = conditionScore
        this.contactEmail = contactEmail
        this.dateOfBirth = dateOfBirth
        this.dateOfFirstTest = dateOfFirstTest
        this.doctorEmail = doctorEmail
        this.fName = fName
        this.lName = lName
    }

}


data class Contacts(
    var email: String
)

class ContactsViewHolder(itemView: View) : ViewHolder(itemView) {
    val email_tv: TextView = itemView.findViewById(R.id.contact_email)
}