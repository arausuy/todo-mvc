package com.arausuy

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import com.arausuy.config.ApplicationConfig
import com.arausuy.routes.ToDoRoutes
import akka.http.scaladsl.settings.RoutingSettings
import akka.util.Timeout

import scala.concurrent.duration._

object System {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(10 seconds)


}

object Server extends App with ApplicationConfig with ToDoRoutes {
  import System._

  Http().bindAndHandle(Route.handlerFlow(routes), httpAddress, httpPort)
}
