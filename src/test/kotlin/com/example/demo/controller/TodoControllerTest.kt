package com.example.demo.controller

import com.example.demo.SpringtestApplication
import com.example.demo.TestDataResources
import com.example.demo.infrastructure.mapper.TodoMapper
import com.example.demo.model.TodoModel
import com.example.demo.service.TodoService
import com.github.springtestdbunit.DbUnitTestExecutionListener
import com.github.springtestdbunit.annotation.DatabaseSetup
import org.apache.ibatis.annotations.Mapper
import org.assertj.core.api.Assertions.assertThat
import org.dbunit.DataSourceDatabaseTester
import org.dbunit.database.DatabaseConnection
import org.dbunit.dataset.csv.CsvDataSet
import org.dbunit.operation.DatabaseOperation
import org.dbunit.util.fileloader.CsvDataFileLoader
import org.junit.After
import org.junit.Before
import org.junit.jupiter.api.*
//import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.skyscreamer.jsonassert.JSONAssert.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener

import org.springframework.util.ResourceUtils
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import javax.sql.DataSource
import java.text.SimpleDateFormat



@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("[UT] TodoControllerTest")
@Transactional
class TodoControllerTest(@Autowired val restTemplate: TestRestTemplate) {
//class TodoControllerTest() {
    var todoListTest: List<TodoModel> = setupBE()

    @Autowired
    lateinit var mapper: TodoMapper

    @Autowired
    private lateinit var service: TodoService

    @Autowired
//    private lateinit var testDataResource: TestDataResources
    private lateinit var dataSource: DataSource

    companion object{
//        @Autowired
//        private lateinit var dataSource: DataSource

//        @JvmStatic
//        @BeforeAll
//        fun setupBA(){
//            println("setupBA")
////            lateinit var dataSource: DataSource
//
//            var databaseTester = DataSourceDatabaseTester(dataSource)
//            databaseTester.setUpOperation = DatabaseOperation.CLEAN_INSERT
//
//            var loader = CsvDataFileLoader()
//            databaseTester.dataSet = loader.loadDataSet(ResourceUtils.getURL("classpath:dbunit/"))   // Requires tail slash
//
//            databaseTester.onSetup()
//        }
    }

    @BeforeEach
    fun setupBA(){
        println("setupBA")
//            lateinit var dataSource: DataSource

        var databaseTester = DataSourceDatabaseTester(dataSource)
        databaseTester.setUpOperation = DatabaseOperation.CLEAN_INSERT

        var loader = CsvDataFileLoader()
        databaseTester.dataSet = loader.loadDataSet(ResourceUtils.getURL("classpath:dbunit/"))   // Requires tail slash

        databaseTester.onSetup()
    }

    fun setupBE():List<TodoModel>{
        println("setupBE")
        //csvをList<todo_>に変換
        var todoList: MutableList<TodoModel> = mutableListOf()
        var br = BufferedReader(FileReader(File("src/test/resources/dbunit/todo.csv")))
//        var data: MutableList<MutableList<String>> = mutableListOf()
//        var todoListTest: MutableList<TodoModel> = mutableListOf()
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
//        val actual = service.getTodoList()
//        val actual = service.getTodoById("4e4600b3-c0fc-4ffd-815d-0fc5c53d69e6")
//        assertEquals()
//        assertThat(actual).isNotNull().isNotEmpty().hasSize(2);
        var expected = todoListTest[2].categoryId
        assertThat(actual[2].categoryId).isEqualTo(expected)
        //assertEquals(expected, actual)
    }

    @AfterEach
    fun ffff(){
        println("End")
    }
}