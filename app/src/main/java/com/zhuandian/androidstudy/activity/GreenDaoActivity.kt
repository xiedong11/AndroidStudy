package com.zhuandian.androidstudy.activity

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhuandian.androidstudy.R
import com.zhuandian.androidstudy.dao.DaoMaster
import com.zhuandian.androidstudy.dao.DaoSession
import com.zhuandian.androidstudy.dao.UserDao
import com.zhuandian.androidstudy.entity.User
import kotlinx.android.synthetic.main.activity_green_dao.*

class GreenDaoActivity : AppCompatActivity() {

    lateinit var daoMaster: DaoMaster
    lateinit var daoSession: DaoSession
    lateinit var db: SQLiteDatabase
    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_green_dao)

        btn_add.setOnClickListener {
            addData2DB()
        }

        btn_query.setOnClickListener {
            queryDB()
        }
        initDB()
    }

    private fun queryDB() {
        var list = userDao.queryBuilder().list()
        list.forEach{
            println(it.name.toString()+"------------------")
        }
    }

    private fun addData2DB() {
        var user = User()
        user.name= Math.random().toString()+"--name"
        userDao.insert(user)
    }

    private fun initDB() {
        db = DaoMaster.DevOpenHelper(this, "TestDB.db", null).writableDatabase
        daoMaster = DaoMaster(db)
        daoSession = daoMaster.newSession()
        userDao = daoSession.userDao
    }
}
