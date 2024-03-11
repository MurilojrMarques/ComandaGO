package com.example.comandago

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.comandago.databinding.ActivityLoginBinding
import android.graphics.Color

class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("FFFFFF")

            binding.btnEntrar.setOnClickListener{
            checkLogin()
        }
    }

    private fun checkLogin() {
       val usuario =  binding.editUsuario.text.toString()
       val senha = binding.editSenha.text.toString()
       if(usuario.isEmpty() || senha.isEmpty()){
           alertaFalha("Usuário e Senha devem ser digitadas!")
       }
        else{
            enviarLogin()
       }
    }

    private fun enviarLogin() {
        val text = "Entrando!"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(this, text, duration)
        toast.show()
    }


    private fun alertaFalha(s: String) {
        AlertDialog.Builder(this)
            .setTitle("Falha")
            .setIcon(R.drawable.ic_atencao)
            .setMessage(s)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}


