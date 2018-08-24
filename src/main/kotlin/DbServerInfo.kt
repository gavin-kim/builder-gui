class PersonalProperties {

}

data class DBBuildProperties(
    val dbServer: DBServer,
    val admin: DBUser,
    val workbrain: DBUser,
    val archive: DBUser,
    val flywayMigrationOptions: FlywayMigrationOptions
) {

}

data class DBServer(
    val type: DBServer.Type,
    val name: String,
    val port: Int,
    val server: String,
    val drive: Char,
    val path: String,
    val driver: String,
    val version: String? = null,
    val flywaySchema: String,
    val flywayArchiveSchema: String,
    val dataType: DataType
) {

    val url: String = when (type) {
        Type.ORACLE -> "jdbc:oracle:thin:@$server:$port:$name"
        Type.SQL_SERVER -> "jdbc:sqlserver://$server:$port;database=$name"
    }

    enum class Type(val value: String) {
        ORACLE("Oracle"),
        SQL_SERVER("SqlServer"),
    }

    enum class DataType(val property: String) {
        QA("populate_qadata"),
        TEST("populate_testdata")
    }
}

data class FlywayMigrationOptions(
    val outOfOrder: Boolean = false,
    val repairOnStart: Boolean = true,
    val runStats: Boolean = false,
    val runas: Boolean = false,
    val failOnWarning: Boolean = false,
    val ignoreMissingMigrations: Boolean = false
)

data class DBUser(val username: String, val password: String)
