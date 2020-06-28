/**
 * @Author Tunç Gürsoy
 * */
import java.io.*
import java.lang.Exception
import java.net.ServerSocket
import java.net.Socket
import java.util.*

class Server
{
    private lateinit var text : String
    private lateinit var inputStream : Scanner
    private lateinit var outputStream : PrintWriter
    private lateinit var serverSocket : ServerSocket

    fun setServer(PortNumber : Int)
    {
        try {
                 println("Waiting for connection")
                serverSocket = ServerSocket(PortNumber)
                val socket : Socket = serverSocket.accept()
                inputStream = Scanner(InputStreamReader(socket.getInputStream()))
                outputStream = PrintWriter( DataOutputStream(socket.getOutputStream()))
                println("Connected")
            }catch (e : Exception)
                {
                    println("Connection Error!!!!!")
                }

    }
    fun listenPort() : String
    {
        text = inputStream.nextLine()
        return text
    }
    fun sendToPort(input : String)
    {
        outputStream.println("Server : "+input)
        outputStream.flush()
    }
    fun closeConnection()
    {
        inputStream.close()
        outputStream.close()
    }

}