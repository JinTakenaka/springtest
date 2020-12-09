package com.example.demo.mapper

import org.apache.ibatis.annotations.Mapper
import com.example.demo.model.SampleModel
import org.springframework.stereotype.Component

@Mapper
@Component
interface SampleMapper {
    // 抽象メソッドで定義する
    fun find(): List<SampleModel>

}