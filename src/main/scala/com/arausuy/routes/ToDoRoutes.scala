package com.arausuy.routes

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route


trait ToDoRoutes extends SprayJsonSupport {

  protected val getToDoRoute: Route = pathEndOrSingleSlash {
    get {
      complete("Return todo item")
    }
  } ~ path(IntNumber) { id =>
    get {
      complete(s"Return param : $id")
    }
  }

  val routes:Route = getToDoRoute

}
