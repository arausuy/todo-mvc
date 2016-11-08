package com.arausuy.routes

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route


trait ToDoRoutes extends SprayJsonSupport {

  protected val getToDoRoute: Route = pathEndOrSingleSlash {
    get {
      complete("Return todo items")
    }
  } ~ path(IntNumber) { id =>
    get {
      complete(s"Return param : $id")
    }
  }

  protected val addItem: Route = path("add") {
    post {
      complete(s"added item")
    }
  }

  protected val updateToDoItem: Route = path (IntNumber) { id =>
    put {
      complete(s"Updated item : $id")
    }
  }

  protected val deleteToDoItem: Route = path (IntNumber) { id =>
    delete {
     complete(s"Deleted todo item : $id")
    }
  }

  val routes:Route = getToDoRoute ~ deleteToDoItem ~ addItem ~ updateToDoItem

}
