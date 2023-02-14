# Google Cloud Functions Telegram bot to download tracks from Spotify, YouTube playlists
## Run locally
```shell
mvn function:run -Drun.functionTarget=ua.gladiator.bot.Main
```
## Deploy
```shell
gcloud builds submit --config builds/bot-cloudbuild.yaml --substitutions _TELEGRAM_BOT_TOKEN=<token>
```