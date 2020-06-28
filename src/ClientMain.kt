/**
 * @Author Tunç Gürsoy
 * */
fun main() {
    val Client = Client()
    Client.setClient("localhost",5656)
    Client.sendOutput("Hello Server")
    println(Client.listenPort())
    Client.closeConnection()
}