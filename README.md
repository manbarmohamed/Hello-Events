# Hello-Events

Hello-Events est une application web complète pour la gestion et la réservation d'événements. Ce projet offre une plateforme intuitive pour explorer, réserver, et gérer des événements.

## Sommaire
1. [Aperçu du Projet](#aperçu-du-projet)
2. [Fonctionnalités](#fonctionnalités)
3. [Technologies Utilisées](#technologies-utilisées)
4. [Installation et Configuration](#installation-et-configuration)
5. [Compilation et Exécution](#compilation-et-exécution)
6. [Documentation API](#documentation-api)


## Aperçu du Projet

Hello-Events est une application web développée pour la gestion des événements, incluant des fonctionnalités pour les utilisateurs et les administrateurs. Elle permet aux utilisateurs de découvrir des événements, de réserver des billets, et d'interagir avec d'autres utilisateurs et les administrateurs.

## Fonctionnalités

### Fonctionnalités Utilisateur
- **Page d'Accueil**: Affiche les événements à venir et en vedette.
- **Authentification Utilisateur**: Inscription, connexion, et gestion du profil.
- **Recherche d'Événements**: Rechercher et filtrer les événements disponibles.
- **Réservation**: Réserver des billets pour les événements.
- **Formulaire de Contact**: Soumettre des demandes ou poser des questions.

### Fonctionnalités Administrateur
- **Tableau de Bord**: Vue d'ensemble des statistiques de la plateforme.
- **Gestion des Utilisateurs**: Consultation et gestion des comptes utilisateurs.
- **Gestion des Événements**: Création, mise à jour et suppression d'événements.
- **Gestion des Contacts**: Gestion des demandes envoyées par les utilisateurs.

## Technologies Utilisées

- **Backend**: Spring Boot, Spring Security, Spring Data JPA
- **Frontend**: Angular (ou React, selon l'intégration)
- **Base de Données**: MySQL/PostgreSQL
- **Tests**: JUnit, Mockito
- **Conteneurisation**: Docker

## Installation et Configuration

### Prérequis
- Java 11+
- Maven
- Docker (pour la conteneurisation)

### Cloner le Répertoire
```bash
git clone https://github.com/username/hello-events.git
cd hello-events


### Compilation et Exécution
#### Sans Docker

- **Compiler l'application : ./mvnw clean install
- **Lancer l'application: ./mvnw spring-boot:run

#### Avec Docker

- **Construire l'image Docker : docker build -t hello-events .
- **Lancer le conteneur Docker: docker run -p 8080:8080 hello-events

### Documentation API

La documentation de l'API est disponible via Swagger UI à l'adresse http://localhost:8080/swagger-ui.html.

**POST /api/auth/signup : Enregistre un nouvel utilisateur.
***Corps de la requête:
{
  "username": "string",
  "email": "string",
  "password": "string"
}

**POST /api/auth/login : Authentifie un utilisateur et retourne un JWT.
***Corps de la requête:
{
  "username": "string",
  "password": "string"
}



