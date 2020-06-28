/**
 * @Author Tunç Gürsoy
 * */

import java.io.DataOutputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Exception
import java.net.Socket
import java.util.*


class Client
{
    private lateinit var inputStream : Scanner
    private lateinit var outputStream: PrintWriter
    private lateinit var socket :Socket

    private var Try :Int = 0
    fun setClient(IP :String,port : Int)
    {
        try
        {
            if(Try==0)
            {
                println("Waiting for connection")

            }
            socket = Socket(IP,port)
            println("Connected")
            inputStream = Scanner(InputStreamReader(socket.getInputStream()))
            outputStream = PrintWriter(DataOutputStream(socket.getOutputStream()))
        }catch (e :Exception)
        {
            //if connection is  refused,automatically trys again
            if (Try!=500)
            {
                setClient(IP,port)
                Try++
            }

        }
    }
    fun sendOutput(input : String)
    {
        outputStream.println(
            "Client: $input")
        outputStream.flush()

    }
    fun listenPort(): String
    {  var text  = ""
        while (inputStream.hasNextLine()) {
            text += inputStream.nextLine()
        }

        return text

    }
    fun closeConnection()
    {
        inputStream.close()
        outputStream.close()
    }


}