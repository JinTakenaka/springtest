package com.example.demo.infrastructure.mapper

import org.apache.ibatis.annotations.Mapper
import com.example.demo.model.SampleModel
import org.apache.ibatis.annotations.Options
import org.springframework.stereotype.Component

@Mapper
@Component
interface SampleMapper {
    // 抽象メソッドで定義する
    fun find(): List<SampleModel>

    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(hello_world:String)
//    fun insert(model: SampleModel)

    fun update(id: Int, hello_world: String)

    fun delete(id:Int)

    fun deleteAll()
}