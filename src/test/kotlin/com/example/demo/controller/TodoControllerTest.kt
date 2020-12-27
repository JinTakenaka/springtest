package com.example.demo.controller

import com.example.demo.controller.dto.TodoInsertRequest
import com.example.demo.infrastructure.mapper.TodoMapper
import com.example.demo.model.TodoModel
import com.example.demo.service.TodoService
import org.assertj.core.api.Assertions.assertThat
import org.dbunit.DataSourceDatabaseTester
import org.dbunit.operation.DatabaseOperation
import org.dbunit.util.fileloader.CsvDataFileLoader
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

import org.springframework.util.ResourceUtils
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import javax.sql.DataSource
import java.text.SimpleDateFormat


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("[UT] TodoControllerTest")
//@Transactional//これのせいで挙動がおかしかった
//class TodoControllerTest(@Autowired val restTemplate: TestRestTemplate) {//未使用
class TodoControllerTest() {
    var todoListTest: List<TodoModel> = setupBA()//CSVをオブジェクトに読み込む

    @Autowired
    lateinit var mapper: TodoMapper

    @Autowired
    private lateinit var service: TodoService

    @Autowired
    private lateinit var dataSource: DataSource

    @BeforeEach
    fun setupBE(){//CSVからデータベースへ、テストデータの挿入
        println("setupBE")

        var databaseTester = DataSourceDatabaseTester(dataSource)
        databaseTester.setUpOperation = DatabaseOperation.CLEAN_INSERT

        var loader = CsvDataFileLoader()
        databaseTester.dataSet = loader.loadDataSet(ResourceUtils.getURL("classpath:dbunit/"))   // Requires tail slash

        databaseTester.onSetup()
    }

    fun setupBA():List<TodoModel>{//csvをList<List<TodoModel>>に変換
        println("setupBA")
        var todoList: MutableList<TodoModel> = mutableListOf()
        var br = BufferedReader(FileReader(File("src/test/resources/dbunit/todo.csv")))
//        var data: MutableList<MutableList<String>> = mutableListOf()//未使用
        br.readLine()//一行目を読み飛ばす
        var line = br.readLine()
        while (line!=null){
            val aline = line.split(",")
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            var todo:TodoModel = TodoModel(
                trimDoubleQuot(aline[0]),
                trimDoubleQuot(aline[1]),
                aline[2].toInt(),
                trimDoubleQuot(aline[3]),
                aline[4].toInt(),
                dateFormat.parse(aline[5]),
                trimDoubleQuot(aline[6])
            )
            todoList.add(todo)
//            data.add(line.split(",") as MutableList<String>)
            line = br.readLine()
        }
//        for ((i, a) in data.withIndex()){
//            for((j, str) in a.withIndex()){
//                data[i][j] = trimDoubleQuot(str)
//            }
//        }
        return todoList
    }

    fun trimDoubleQuot(str:String): String{
        var c = '"'
        if(str.substring(0,1).single()==c && str.substring(str.length-1,str.length).single()==c){
            return str.substring(1,str.length-1)
        }else{
            return str
        }
    }

    @Test
    fun findTest(){
        println("findTest")
        val actual = service.find()
        var expected = todoListTest[2].categoryId
        assertThat(actual[2].categoryId).isEqualTo(expected)
        //assertEquals(expected, actual)
    }

    @Test
    fun insertDataTest(){
        print("sizeOfTodoList:")
        println(service.find().size)
        println("insertTest")
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val body = TodoInsertRequest("title01", "emergency", "sss", dateFormat.parse("2018-11-29"), "www")
        val id = service.insert(body.title, body.category, body.detail, body.deadline, body.remarks)
        val actual = service.getTodoById(id)
        print("sizeOfTodoList:")
        println(service.find().size)
        assertThat(actual.detail).isEqualTo("sss")
    }

    @Test
    fun getTodoTest(){
        println("getTodoTest")
        val actual = service.getTodoById(todoListTest[3].id)
        assertThat(actual.detail).isEqualTo(todoListTest[3].detail)
    }

    @Test
    fun getTodoListTest(){
        println("getTodoListTest")
        val actual = service.getTodoList()
        assertThat(actual[2].deadline).isEqualTo(todoListTest[2].deadline)
    }

    @Test
    fun updateDataTest(){
        println(service.update(todoListTest[1].id,"completed"))//update実行
        var actual = service.getTodoById(todoListTest[1].id)
        assertThat(actual.statusId).isEqualTo(3)
    }

    @Test
    fun deleteDataTest(){
        println("deleteDataTest")
        val beforeNum = service.find().size
        var actual = service.getTodoById(todoListTest[3].id)
        val afterNum = service.find().size
        assertThat(afterNum).isEqualTo(beforeNum-1)
    }

//    @AfterEach
//    fun end(){
//        println("End")
//    }
}