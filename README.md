Nowoczesna aplikacja typu marketplace, która wykorzystuje trzy różne typy baz danych (dokumentową, grafową i relacyjną), każdą dokładnie tam, gdzie sprawdza się najlepiej.
✅ Architektura mikroserwisowa
✅ Osobne bazy danych: PostgreSQL, MongoDB, Neo4j
✅ Zewnętrzny Spring Cloud Config Server z GitHuba
✅ Zasady Clean Architecture i SOLID
✅ Gotowa pod CI/CD, Dockera, bezpieczeństwo (np. Keycloak)
Krótkie założenia:
Użytkownicy mogą:

tworzyć profil (PostgreSQL)

dodawać portfolio projektów z metadanymi (MongoDB)

nawiązywać relacje zawodowe, przeszukiwać graf kontaktów (Neo4j)
🔧 Technologie:
Spring Boot 3 (Spring Web, Spring Data JPA, Spring Data MongoDB, Spring Data Neo4j, Mikroservisy ) 

Spring Security (OAuth2, Keyclaok)

Discovery Service + Api gatway 

MapStruct / ModelMapper (mapowanie DTO)

Testy: JUnit 5, Testcontainers (dla trzech baz)

Flyway (dla PostgreSQL)

Docker Compose (z trzema bazami + keycloak)

Osobny mikroserwis dla config server (Centralizacja zarządzania konfiguracją)

 ( security) 


💡 Przykładowe use case’y:
Zarejestruj użytkownika i zapisz dane w PostgreSQL.

Użytkownik dodaje portfolio → zapis do MongoDB.

Użytkownik dodaje kontakt do innego użytkownika → relacja w Neo4j.

Szukaj ludzi z danej technologii, którzy są w 2. stopniu znajomości → Cypher query.

Wyswietl profil: dane osobowe (PostgreSQL), projekty (MongoDB), liczba kontaktów (Neo4j).
