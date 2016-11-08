package com.arausuy.config

import com.typesafe.config.ConfigFactory


trait ApplicationConfig {

  val config = ConfigFactory.load("application.conf")
  val httpAddress = config.getString("http.address")
  val httpPort = config.getInt("http.port")


}
