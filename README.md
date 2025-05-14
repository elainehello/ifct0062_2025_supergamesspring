
# Spring Boot Videogames Project

A Spring Boot application for managing videogames with PostgreSQL database integration.

## Features

- CRUD operations for videogames
- Genre management
- Platform-based filtering
- Thymeleaf templates for the web interface
- JPA/Hibernate for database operations

## Technologies

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- Maven

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/fernandopaniagua/ifct0062_2025_supergamesspring/
│   │       ├── controller/    # MVC Controllers
│   │       ├── model/        # Entity classes
│   │       ├── repository/   # Data access layer
│   │       ├── service/      # Business logic
│   │       └── logsystem/    # Logging functionality
│   └── resources/
│       ├── static/          # Static resources (CSS, images)
│       ├── templates/       # Thymeleaf templates
│       └── application.properties
```

## Getting Started

1. Clone the repository
2. Configure your PostgreSQL database settings in `application.properties`
3. Run `mvn clean install` to build the project
4. Start the application using Spring Boot

## API Endpoints

- `GET /`: Show main page with all videogames
- `GET /create-videogame`: Create new videogame form
- `GET /edit-videogame`: Edit existing videogame
- `GET /delete-videogame`: Delete a videogame

## Models

### Videogame
- id: Integer
- title: String
- platform: String
- multiplayer: boolean
- price: Integer
- genre: Genre (ManyToOne relationship)

### Genre
- id: Integer
- name: String
- description: String

## Contributing

Feel free to submit issues and enhancement requests.

## License

This project is licensed under the terms specified in the project configuration.
