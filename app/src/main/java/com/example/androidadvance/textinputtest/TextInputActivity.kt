package com.example.androidadvance.textinputtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidadvance.R
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Matcher
import java.util.regex.Pattern

class TextInputActivity : AppCompatActivity() {
    companion object {
        const val EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"（），：；<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
    }
    private val pattern = Pattern.compile(EMAIL_PATTERN)
    private lateinit var matcher: Matcher
    private lateinit var tlUsername: TextInputLayout
    private lateinit var tlPassword: TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input)
        tlUsername = findViewById(R.id.tl_username)
        tlPassword = findViewById(R.id.tl_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            login()
        }
    }

    /**
     * 验证密码长度
     */
    private fun validatePassword(password: String): Boolean {
        return password.length > 6
    }

    /**
     * 验证邮箱格式
     */
    private fun validateUserName(username: String): Boolean {
        matcher = pattern.matcher(username)
        return matcher.matches();
    }

    /**
     * 登录
     */
    private fun login() {
        val username = tlUsername.editText?.text.toString()
        val password = tlPassword.editText?.text.toString()
        if (!validateUserName(username)) {
            tlUsername.isErrorEnabled = true
            tlUsername.error = "请输入正确的邮箱地址"
        } else if (!validatePassword(password)) {
            tlPassword.isErrorEnabled = true
            tlPassword.error = "密码字数过少"
        } else {
            tlUsername.isErrorEnabled = false
            tlPassword.isErrorEnabled = false
            Toast.makeText(applicationContext,"登陆成功",Toast.LENGTH_SHORT).show()
        }
    }

}