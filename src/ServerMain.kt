/**
 * @Author Tunç Gürsoy
 * */
fun main() {
    val server   = Server()
    server.setServer(5656)
    server.sendToPort("Hello Client")
    println(server.listenPort())
    server.closeConnection()
}