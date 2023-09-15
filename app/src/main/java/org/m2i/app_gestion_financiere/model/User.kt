package org.m2i.app_gestion_financiere.model

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "users_tbl")
data class User(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "user_lastName" )
    val lastName: String,
    @ColumnInfo(name = "user_firstName" )
    val firstName: String,
    @ColumnInfo(name = "user_email" )
    val email: Email,
    @ColumnInfo(name = "user_password" )
    val password: String
)
