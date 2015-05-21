package com.ilunin.consul

import com.ilunin.spray.gun.Server
import com.ning.http.client.Response
import org.scalatest.{FreeSpec, Matchers}
import spray.http.ContentTypes

class HttpClientTest extends FreeSpec with Matchers {

  "The HTTP client should do the request to the server returned by Consul" in {

    val consulJson =
      """
        |[
        |  {
        |    "Node": "foobar",
        |    "Address": "127.0.0.1",
        |    "ServiceID": "myService",
        |    "ServiceName": "myService",
        |    "ServiceTags": null,
        |    "ServiceAddress": "",
        |    "ServicePort": 9999
        |  }
        |]
      """.stripMargin
    val consul = Server.simpleServer("localhost", 8500, ContentTypes.`application/json`, consulJson)
    val server = Server.simpleServer(interface = "127.0.0.1", port =  9999, content = "test")
    Server.executeWhileRunning(consul) {
      Server.executeWhileRunning(server) {
        val client = new HttpClient
        val response: Response = client.prepareGet("http://myService.service.consul").execute().get()
        response.getStatusCode should be (200)
        response.getResponseBody should be ("test")
      }

    }

  }

}
