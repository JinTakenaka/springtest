package com.example.demo.mapper

import org.apache.ibatis.annotations.Mapper
import com.example.demo.model.TodoModel
import org.apache.ibatis.annotations.Options
import org.springframework.stereotype.Component

@Mapper
@Component
interface TodoMapper {
    // 抽象メソッドで定義する
    fun find(): List<TodoModel>

    //@Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(title:String)
//    fun insert(model: SampleModel)

    fun update(id: Int, hello_world: String)

    fun delete(id:Int)

    fun deleteAll()
}