
import javafx.application.Application
import javafx.scene.text.FontWeight
import tornadofx.*
import java.sql.DriverManager
import kotlin.math.absoluteValue

private val data = observableList(1, 2, 3, 4, 5)

fun main(args: Array<String>) {
    val properties = FileLoader.loadProperties("d:\\dev\\build\\personal.properties")
    //properties.list(System.out)

    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORADEVL", "system", "ORADEVL").use { connection ->
        connection.clientInfo.list(System.out)
    }

    DriverManager.getConnection("jdbc:sqlserver://SQLDEVL:1433;database=;")

    //Application.launch(BuilderApp::class.java, *args)
}

class BuilderApp : App(MyView::class, Styles::class) {
    override val primaryView = MyView::class
}

class Styles : Stylesheet() {
    init {
        label {
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
            backgroundColor += c("#cecece")
        }
    }
}

class MyView : View() {
    override val root = borderpane {
        center {
            tableview(data) {
                readonlyColumn("A", Int::absoluteValue)
                readonlyColumn("B", Int::absoluteValue)
            }
        }
    }
}