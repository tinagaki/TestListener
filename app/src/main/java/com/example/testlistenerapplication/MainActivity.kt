package com.example.testlistenerapplication

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Task.TestListenner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val context = applicationContext

        fab.setOnClickListener { view ->
            Toast.makeText(context, "start Task", Toast.LENGTH_SHORT).show()

            val task = Task()
            task.setListener(this)
            task.taskStart()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSuccess(result: Int) {
        val context = applicationContext

        Toast.makeText(context, "end Task result:: $result", Toast.LENGTH_SHORT).show()

    }

}
