package ua.gladiator.bot

import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}

class Main extends HttpFunction {
  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.getWriter.write(sys.env.toString() + "\n" + sys.env.get("TELEGRAM_BOT_TOKEN"))
  }
}