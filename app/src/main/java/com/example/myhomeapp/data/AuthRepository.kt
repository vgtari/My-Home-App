package com.example.myhomeapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.myhomeapp.models.User
import com.example.myhomeapp.navigation.ROUTE_HOME
import com.example.myhomeapp.navigation.ROUTE_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthRepository (var navController: NavHostController, var context: Context) {
    var mAuth: FirebaseAuth
    var progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun signup(name: String, email: String, password: String) {
        progress.show()
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            progress.dismiss()
            if(it.isSuccessful){
                var userId = mAuth.currentUser!!.uid
                var userData = User(name,email,password, userId)
                var regRef = FirebaseDatabase.getInstance().getReference().child("Users/$userId")
                regRef.setValue(userData).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(context, "Signup successful", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_HOME)
                    }
                }
            }
        }
    }

    fun login(email:String,password:String){
        progress.show()
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            progress.dismiss()
            if(it.isSuccessful){
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_HOME)
            }
        }
    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser != null
    }
}