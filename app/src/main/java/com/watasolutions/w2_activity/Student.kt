package com.watasolutions.w2_activity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Student(val username: String, val password: String) : Parcelable {
}