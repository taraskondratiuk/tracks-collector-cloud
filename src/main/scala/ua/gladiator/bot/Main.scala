package ua.gladiator.bot

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.cloud.functions.{HttpFunction, HttpRequest, HttpResponse}
import org.telegram.telegrambots.meta.api.objects.Update

class Main extends HttpFunction {
  override def service(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    val bot = new Bot(sys.env("TELEGRAM_BOT_TOKEN"))

    val update = new ObjectMapper().readValue(httpRequest.getInputStream, classOf[Update])

    bot.onWebhookUpdateReceived(update)
  }
}