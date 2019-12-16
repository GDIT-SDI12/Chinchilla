# CHINCHILLA
Chinchilla is a platform to connect people.
We connect those who want to work and those who need help.

## Getting Started
### Prerequisites
To compile, run, and use this application you need:
- JDK 8+
- [Maven](https://maven.apache.org/)
- a database (we use [PostgreSQL](https://www.postgresql.org/))

### Installation
1. get this repository on your computer (clone or download)
1. create a database
1. import tables from [our dump file](db/tables.sql)
1. set up URL, USER and PASSWORD properties into [hibernate configuration file](src/main/resources/hibernate.cfg.xml)
