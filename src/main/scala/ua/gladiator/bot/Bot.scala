package ua.gladiator.bot

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramWebhookCommandBot
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.{Chat, Message, Update, User}
import org.telegram.telegrambots.meta.bots.AbsSender

class Bot(token: String) extends TelegramWebhookCommandBot(token) {

  register(new BotCommand("start", "start") {
    override def execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array[String]): Unit = {
      absSender.execute[Message, SendMessage](
        new SendMessage(
          chat.getId.toString,
          "Welcome! Bot to collect music from Spotify/Youtube playlists. /help to get list of commands"
        )
      )
    }
  })

  register(new BotCommand("help", "help") {
    override def execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array[String]): Unit = {
      absSender.execute[Message, SendMessage](
        new SendMessage(
          chat.getId.toString,
          "/add <Spotify/Youtube playlist url>\n/remove <spotify/youtube playlist url>\n/list"
        )
      )
    }
  })

  override def processNonCommandUpdate(update: Update): Unit = ()

  override def getBotPath: String = ""

  override def getBotUsername: String = "tracks collector"
}
