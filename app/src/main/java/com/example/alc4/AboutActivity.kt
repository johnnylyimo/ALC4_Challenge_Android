package com.example.alc4

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.Color
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_about.*


class AboutActivity : AppCompatActivity() {

    private val URL = "https://andela.com/alc/"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = getString(R.string.about_alc)

        webview.settings.javaScriptEnabled = true // allow Javascript running in this webpage
        webview.settings.setSupportZoom(false) // disable user to zoom in n out of webpage


        //Using anonymous class  modify functionality of webview, this singleton object run when webpage is open
        webview.webViewClient = object : WebViewClient() {

            //             do error handling
            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                super.onReceivedSslError(view, handler, error)

                val builder = AlertDialog.Builder(this@AboutActivity)// Build alert dialog
                var msg = ""
                when(error?.primaryError){ // return int(3) then compared
                    SslError.SSL_UNTRUSTED -> msg = "The certificate authority is not trusted"
                    SslError.SSL_EXPIRED -> msg = "The certificate has Expired"
                    SslError.SSL_IDMISMATCH -> msg = "The certificate hostname mismatch"
                    SslError.SSL_NOTYETVALID -> msg = "The certificate is not yet valid"
                }

                val url = error?.url
                val errorNo = error?.primaryError
//                builder.setMessage(getString(R.string.notification_error_ssl_cert_invalid)) //set message of alert dialog
                builder.setMessage("SSL Certification Error! number: $errorNo \n$msg on this url: $url") //set message of alert dialog

                builder.setPositiveButton("continue") {_, _ ->
                    handler?.proceed()
                    Toast.makeText(applicationContext, "proceed", Toast.LENGTH_SHORT).show()
                }

                builder.setNegativeButton("cancel") { _, _ ->  // _ represent unused parameters: dialog, which
                    handler?.cancel()
                    }

                val alert = builder.create() // create dialog box
                alert.setTitle("SSL Permission!") // set title for alert dialog box
                alert.show() //show alert dialog

            }



        } //WebViewClient closing brace

        webview.loadUrl(URL)

    } // onCreate closing brace
} // AboutActivity closing brace
























//            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
//                super.onReceivedError(view, request, error)
////                showErrorDialog()
//            }
//
//            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//                super.onPageStarted(view, url, favicon)
//            }
//
//
//            override fun onPageFinished(view: WebView?, url: String?) {
//                super.onPageFinished(view, url)
//            }