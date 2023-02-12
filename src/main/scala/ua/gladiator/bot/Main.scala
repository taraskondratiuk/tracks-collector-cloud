package ua.gladiator.bot

import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}

class Main extends HttpFunction {
  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.getWriter.write("hi girls!")
  }
}