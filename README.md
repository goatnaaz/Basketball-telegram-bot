#Basketball telegram bot

Basketball telegram bot for people who loves basketball and want to make looking for future games more easy.
## Idea
The main idea is to create bot which can help you to see future games and odds on them and also sse games with final result.
## MVP Scope
As a user, I want the psibility to see future games and odds for them .

# How it works 
Based on MVP Scope, we can specify next behaviours (here and after Telegram User, which is using JavaRush Telgegram bot will call User):
- User can see future games and odds on them
- User can see games that ended with final result
- User can set an inactive bot and do not receive notifications
- User can restart getting notifications
## How it works
Special bot parser wuld go to website with odds and store the information and will send it to you
## Deployment
Deployment process as easy as possible:
Required software:

- docker-compose

to deploy application, switch to needed branch and run docker compose:
docker-compose -f docker-compose.yml up
That's all.

# Local development
For local development and testing, use `docker-compose.yml`. 
Run command: 
```shell
docker-compose -f docker-compose.yml up
```
Next step, is to run SpringBoot app with configured **Edit Configuration** in which two env vars are provided: 

`bot.token=${BOT_TOKEN};bot.username=${BOT_USERNAME}`

 With these configurations - run SpringBoot main method.

# Technological stack
- SpringBoot as a skeleton framework
- PostgreSQL database as a database for saving user and subscription info
- Flyway database migration tool
- Telegram-bot SpringBoot starter
- Spring Data starter
- Unirest - lib for working with REST calls

## License
This project is Apache License 2.0 - see the [LICENSE](LICENSE) file for details

