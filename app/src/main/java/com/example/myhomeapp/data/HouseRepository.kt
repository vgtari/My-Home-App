package com.example.myhomeapp.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.myhomeapp.models.House
import com.example.myhomeapp.models.Upload
import com.example.myhomeapp.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class HouseRepository(var navController: NavHostController, var context: Context) {
        var authRepository:AuthRepository
        var progress:ProgressDialog

        init {
            authRepository = AuthRepository(navController,context)
            if (!authRepository.isLoggedIn()){
                navController.navigate(ROUTE_LOGIN)
            }
            progress = ProgressDialog(context)
            progress.setTitle("Loading")
            progress.setMessage("Please wait...")
        }


        fun saveHouse(houseName:String, housePrice:String, houseDescription:String){
            var id = System.currentTimeMillis().toString()
            var houseData = House(houseName, housePrice, houseDescription, id)
            var houseRef = FirebaseDatabase.getInstance().getReference()
                .child("Houses/$id")
            progress.show()
            houseRef.setValue(houseData).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun viewHouse(upload: MutableState<Upload>, uploads:SnapshotStateList<Upload>): SnapshotStateList<Upload> {
            var ref = FirebaseDatabase.getInstance().getReference().child("uploads")

            progress.show()
            ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    progress.dismiss()
                    uploads.clear()
                    for (snap in snapshot.children){
                        val value = snap.getValue(Upload::class.java)
                        upload.value = value!!
                        uploads.add(value)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
                }
            })
            return uploads
        }

        fun deleteHouse(id:String){
            var delRef = FirebaseDatabase.getInstance().getReference()
                .child("uploads/$id")
            progress.show()
            delRef.removeValue().addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(context, "House deleted", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun updateHouse(image:String, name: String, price: String, description: String, id: String){
            var updateRef = FirebaseDatabase.getInstance().getReference()
                .child("uploads/$id")
            progress.show()
            var updateData = Upload(image, name, price, description , id)
            updateRef.setValue(updateData).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        //######-----------------------------------------------------------############//
        //######----------------IMAGE UPLOAD CODE--------------------------############//
        //######-----------------------------------------------------------############//


        // OPEN GALLERY TO PICK IMAGE
        fun saveHouseWithImage(houseName:String, housePrice:String, houseDescription: String, filePath: Uri){
            var id = System.currentTimeMillis().toString()
            var storageReference = FirebaseStorage.getInstance().getReference().child("Uploads/$id")
            progress.show()

            storageReference.putFile(filePath).addOnCompleteListener{
                progress.dismiss()
                if (it.isSuccessful){
                    // Proceed to store other data into the db
                    storageReference.downloadUrl.addOnSuccessListener {
                        var image = it.toString()
                        var houseData = Upload(image, houseName, housePrice, houseDescription, id)
                        var dbRef = FirebaseDatabase.getInstance()
                            .getReference().child("Uploads/$id")
                        dbRef.setValue(houseData)
                        Toast.makeText(context, "Upload successful", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
        }


        fun viewUploads(upload:MutableState<Upload>, uploads:SnapshotStateList<Upload>): SnapshotStateList<Upload> {
            var ref = FirebaseDatabase.getInstance().getReference().child("Uploads")

            progress.show()
            ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    progress.dismiss()
                    uploads.clear()
                    for (snap in snapshot.children){
                        val value = snap.getValue(Upload::class.java)
                        upload.value = value!!
                        uploads.add(value)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
                }
            })
            return uploads
        }


    }