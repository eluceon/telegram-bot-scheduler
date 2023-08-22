This is a Spring Boot application that enables you to schedule and send messages to a Telegram group via POST requests. Messages, schedules, and chat IDs are stored in a database.

## Features

- Schedule messages to be sent at specific times to a Telegram group.
- Messages, chat IDs, and schedules are stored in a database for persistence.
- Send messages using the Telegram Bot API via POST requests.
- Customizable and configurable Spring Boot application.

## Getting Started

### Prerequisites

- Java
- Gradle
- Docker
- Docker Compose

### Installation

1. Clone the repository:
   `git clone git@github.com:eluceon/telegram-bot-scheduler.git`
2. configure:
- src/main/resources/application.yaml
- docker-compose/docker-compose.yml
- docker-compose/postgres/.postgres.env
- docker-compose/telegram-sender/.telegram-sender.env Replace "YOUR_TELEGRAM_TOKEN" with your Telegram bot token

### Running with Docker Compose
`sudo docker-compose -f docker-compose/docker-compose.yml up `
