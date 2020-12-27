package com.example.demo.service

import com.example.demo.infrastructure.mapper.TodoMapper
import com.example.demo.model.TodoListModel
import com.example.demo.model.TodoModel
import jdk.jfr.Category
import org.apache.ibatis.jdbc.Null
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoService(private val mapper: TodoMapper) {

    fun find() : List<TodoModel> = mapper.find()

    fun insert(title:String, category:String, detail:String, deadline:Date, remarks:String): String {
        val id:String = UUID.randomUUID().toString()
        return if (id!="" && title!="" && category!="" && detail!="") {
            //mapper.insert(id, title, mapper.getCategoryIdByCategory(category), detail, mapper.getStatusIdByStatus(status), deadline, remarks)
            mapper.insert(id, title, mapper.getCategoryIdByCategory(category), detail, 1, deadline, remarks)
            id
        }else "false"
        //return mapper.getTodoById(id)!=null
    }

    fun getTodoById(id:String):TodoModel{
        return mapper.getTodoById(id)
    }

    fun getTodoList():List<TodoListModel> = mapper.getTodoList()

    fun update(id:String, status:String):Boolean{
        var model= mapper.getTodoById(id)
        when(model.statusId) {
            1 -> if (status != "in_progress" && status != "cancelled") return false//未実施→実施中、取りやめ
            2 -> if (status != "completed" && status != "cancelled") return false//実施中→完了、取りやめ
            3 -> return false//完了→なし
            4 -> return false//取りやめ→なし
        }
        mapper.update(id, mapper.getStatusIdByStatus(status))
        return true
    }

    fun delete(id:String):Boolean{
        val model= mapper.getTodoById(id)
        return if(model.statusId==3 || model.statusId==4){//状態が取りやめor完了
            mapper.delete(id)
            true
        }else false
    }
}