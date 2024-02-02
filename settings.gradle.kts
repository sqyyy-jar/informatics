rootProject.name = "informatics"

sourceControl {
    gitRepository(uri("https://github.com/sqyyy-jar/java-notebooks.git")) {
        producesModule("com.github.sqyyy.jnb:core")
        producesModule("com.github.sqyyy.jnb:processor")
    }
}
